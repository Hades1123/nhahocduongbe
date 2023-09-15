package vn.viettel.bvrhm.nhahocduong.api.auth.internal.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import vn.viettel.bvrhm.nhahocduong.api.system.security.UserAuthDetails;
import vn.viettel.bvrhm.nhahocduong.api.user.UserDTO;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserAuthDetailsMapper {

  @Mapping(source = "id", target = "userId")
  UserAuthDetails userAuthDetailsFromUserDTO(UserDTO userDTO);
}
