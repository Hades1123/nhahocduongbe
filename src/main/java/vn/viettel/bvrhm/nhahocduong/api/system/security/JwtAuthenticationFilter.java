package vn.viettel.bvrhm.nhahocduong.api.system.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.viettel.bvrhm.nhahocduong.api.auth.JwtService;
import vn.viettel.bvrhm.nhahocduong.api.auth.internal.AuthenticationService;

import java.io.IOException;
import java.util.List;

import static java.util.Objects.isNull;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Autowired
  private JwtService jwtService;
  @Autowired
  private AuthenticationService authenticationService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwtString;
    final String userId;
    final String username;

    // No JWT in Authorization header -> continue down the chain
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    jwtString = authHeader.substring(7);

    // Invalid JWT token -> continue down the chain
    if (!jwtService.isTokenValid(jwtString)) {
      filterChain.doFilter(request, response);
      return;
    }

    userId = jwtService.extractUserId(jwtString);
    username = jwtService.extractUsername(jwtString);

    // User not existed
    UserAuthDetails userAuthDetails = authenticationService.loadUserByUsername(username);
    if (isNull(userAuthDetails)) {
      filterChain.doFilter(request, response);
      return;
    }

    // TODO extract roles
    // Option 1: get from JWT token => Use this for now
    // Option 2: load from database => Revise later
    List<String> authorityStrList = jwtService.extractRoles(jwtString);

    List<Authority> authorityList = authorityStrList.stream().map(Authority::fromName).toList();

    // populate Authentication object into SecurityContext
    Authentication authentication = new AuthenticationToken(userId, null, authorityList);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request, response);
  }
}
