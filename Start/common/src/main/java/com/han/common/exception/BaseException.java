package com.han.common.exception;

/**
 * @ClassNAME BaseException
 * @Description
 * @Author wuj
 * @Date 2022/7/9 16:40
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    private final ErrorCodeI errCode;

    public BaseException(String errMessage, ErrorCodeI errCode) {
        super(errMessage);
        this.errCode = errCode;
    }

    public BaseException(String errMessage, final ErrorCodeI errCode, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
    }

    public ErrorCodeI getErrCode() {
        return errCode;
    }
}
