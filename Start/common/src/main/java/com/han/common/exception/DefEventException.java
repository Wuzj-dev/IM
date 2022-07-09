package com.han.common.exception;

/**
 * @ClassNAME DefEventException
 * @Description
 * @Author wuj
 * @Date 2022/7/9 16:41
 */
public class DefEventException extends BaseException{
    private static final long serialVersionUID = 1L;

    public DefEventException(String errMessage) {
        this(errMessage, BasicErrorCode.DDE_EVENT_ERROR);
    }

    public DefEventException(String errMessage, ErrorCodeI errCode) {
        super(errMessage, errCode);
    }

    public DefEventException(String errMessage, Throwable e) {
        super(errMessage, BasicErrorCode.DDE_EVENT_ERROR, e);
    }
}
