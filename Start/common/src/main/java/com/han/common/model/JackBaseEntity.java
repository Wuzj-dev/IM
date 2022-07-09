package com.han.common.model;

import com.han.common.utils.GsonUtil;

import java.io.Serializable;

/**
 * @ClassNAME JackBaseEntity
 * @Description
 * @Author wuj
 * @Date 2022/7/9 13:44
 */
public abstract class JackBaseEntity implements Serializable {

    /**
     * jsonStr
     *
     * @return the String
     */
    public String jsonStr() {
        return GsonUtil.toJson(this);
    }


}
