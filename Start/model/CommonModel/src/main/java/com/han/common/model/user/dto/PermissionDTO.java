package com.han.common.model.user.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * 权限 DTO
 */
@Data
public class PermissionDTO
        implements Serializable {

    /**
     * 权限 Key
     */
    private String key;

    /**
     * 权限 Value
     */
    private String value;

}
