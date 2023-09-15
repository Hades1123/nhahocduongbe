package vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto.search;

import lombok.Data;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.OrganizationType;

/**
 * @author: longlb1
 * @since: 14-Sep-23
 */

@Data
public class SearchOrganizationDTO{
    private String areaCode;
    private OrganizationType type = OrganizationType.SCHOOL;
}
