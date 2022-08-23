package com.han.userinfrastructrue.premission;

/**
 * 基础权限校验
 */
public interface PremissionService {

    /**
     * 权限校验
     * @param key the key
     * @return the return
     */
    Boolean havePremission(String key);



}
