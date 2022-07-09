package com.han.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 通用返回类型
 * @author: Wuzj
 * @create: 2021-11-06 01:23
 **/
@Data
@Accessors(chain = true)
public class Response1 extends DTO {

    private static final long serialVersionUID = 1L;

    private boolean isSuccess;

    private String errCode;

    private String errMessage;

    public static Response1 buildFailure(String errMessage) {
        return buildFailure(null, errMessage);
    }

    public static Response1 buildFailure(String errCode, String errMessage) {
        Response1 response = new Response1();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static Response1 buildSuccess() {
        Response1 response = new Response1();
        response.setSuccess(true);
        return response;
    }

}
