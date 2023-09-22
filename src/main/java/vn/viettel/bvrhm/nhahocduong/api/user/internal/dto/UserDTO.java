package vn.viettel.bvrhm.nhahocduong.api.user.internal.dto;

import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto.OrganizationDTO;

import java.time.LocalDate;
import java.util.List;

public record UserDTO (
  Long id,
  String username,
  String password,
  String firstName,
  String lastName,
  String email,
  String phoneNumber,
  LocalDate birthDate,
  List<RoleDTO> roleList,
  OrganizationDTO organization
) {}
