package com.han.common.model.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class OperaPermissions
        implements Serializable {

    /**
     * 权限内容
     */
    private String permissionStr;
}
