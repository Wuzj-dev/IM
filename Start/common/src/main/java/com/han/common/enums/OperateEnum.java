package com.han.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassNAME OperateEnum
 * @Description 操作类型
 * @Author wuj
 * @Date 2022/7/10 10:49
 */
@AllArgsConstructor
@Getter
public enum OperateEnum {

    /**
     * DELETE
     */
    DELETE("d"),

    CHANGE("c"),

    ADD("a"),

    SELECT("s");


    private String operateType;

}
