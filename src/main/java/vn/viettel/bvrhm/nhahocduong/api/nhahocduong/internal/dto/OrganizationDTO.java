package vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto;

import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.Grade;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.OrganizationType;

import java.util.List;
import java.util.Map;

public record OrganizationDTO(
  Long id,
  String name,
  String address,
  String code,
  String areaCode,
  Map<Grade, List<String>> classes,
  OrganizationType type
) {}