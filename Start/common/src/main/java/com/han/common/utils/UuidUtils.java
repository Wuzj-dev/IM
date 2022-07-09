package com.han.common.utils;

import java.util.UUID;

/**
 * @ClassNAME UuidUtils
 * @Description UUID 工具
 * @Author wuj
 * @Date 2022/7/9 12:59
 */
public class UuidUtils {

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

}
