package vn.viettel.bvrhm.nhahocduong.api.common.internal.helper;

import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto.OrganizationDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: longlb1
 * @since: 29-Sep-23
 */
public class OrganizationServiceHelper {
    public static List<String> getFlattenClassList(OrganizationDTO organizationDTO) {
        if (organizationDTO.getClasses() == null || organizationDTO.getClasses().isEmpty()) return null;
        return organizationDTO.getClasses()
                .values()
                .stream()
                .reduce((classList, classList2) -> {
                    classList.addAll(classList2);
                    return classList;
                })
                .orElse(null);
    }
    public static List<String> getDuplicateClassList(OrganizationDTO organizationDTO) {
        List<String> flattenClassList = getFlattenClassList(organizationDTO);
        Set<String> classes = new HashSet<>();
        return flattenClassList.stream().filter(clazz -> !classes.add(clazz.trim().toLowerCase())).toList();
    }
}
