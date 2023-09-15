package vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: longlb1
 * @since: 14-Sep-23
 */
public enum OrganizationType {
    HEALTH_DEPARTMENT(1, "Sở y tế"),
    SCHOOL(2, "Trường học");

    private Integer code;
    private String name;

    OrganizationType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    @JsonValue
    public String getName() {
        return this.name;
    }
}
