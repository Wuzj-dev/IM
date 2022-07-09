package com.han.common.utils;

import java.util.Collection;

/**
 * @ClassNAME ListUtil
 * @Description
 * @Author wuj
 * @Date 2022/7/9 13:25
 */
public class ListUtil {

    /**
     * 判断 集合是否为空
     *
     * @param collection the collection
     * @return the Boolean
     */
    public static Boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }


}
