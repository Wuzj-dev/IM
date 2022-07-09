package com.han.common.dto;

import lombok.Data;

/**
 * @description: 通用返回类型
 * @author: Wuzj
 * @create: 2021-11-06 01:23
 **/
@Data
public class Response extends DTO {

    private static final long serialVersionUID = 1L;

    private boolean isSuccess;

    private String errCode;

    private String errMessage;

    public static Response buildFailure(String errMessage) {
        return buildFailure(null, errMessage);
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

}
