package com.han.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassNAME GsonUtil
 * @Description Gson工具
 * @Author wuj
 * @Date 2022/7/9 12:11
 */
public class GsonUtil {

    private static final Gson gson = new GsonBuilder().create();

    private final static Gson getGson() {
        return gson;
    }

    private static final String EMPTY = StringUtil.EMPTY;

    /**
     * 对象转 String 类型
     *
     * @param obj the Obj
     * @return the String
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return EMPTY;
        }
        return getGson().toJson(obj);
    }

    /**
     * String 类型 转 对象
     *
     * @param jsonStr the jsonStr
     * @param tClass  the tClass
     * @return the T
     */
    public static <T> T fromJson(String jsonStr, Class<T> tClass) {
        return getGson().fromJson(jsonStr, tClass);
    }
}
