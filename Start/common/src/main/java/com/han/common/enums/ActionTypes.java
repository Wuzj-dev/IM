package com.han.common.enums;

/**
 * @ClassNAME ActionTypes
 * @Description 操作类型
 * @Author wuj
 * @Date 2022/7/9 13:08
 */
public enum ActionTypes {

    /**
     * Read
     */
    READ("r"),
    /**
     * Write
     */
    WRITE("w");

    private String action;

    ActionTypes(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }

}
