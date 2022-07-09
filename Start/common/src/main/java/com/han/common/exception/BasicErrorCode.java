package com.han.common.exception;

/**
 * @ClassNAME BasicErrorCode
 * @Description
 * @Author wuj
 * @Date 2022/7/9 16:41
 */
public enum BasicErrorCode implements ErrorCodeI {
    BIZ_ERROR("BIZ_ERROR", "通用的业务逻辑错误"),
    DDE_EVENT_ERROR("COLA_FRAMEWORK_ERROR", "事件发布 错误"),
    SYS_ERROR("SYS_ERROR", "未知的系统错误");

    private String errCode;
    private String errDesc;

    private BasicErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrDesc() {
        return this.errDesc;
    }
}
