package com.han.common.dto;

/**
 * @description: 通用返回
 * @author: Wuzj
 * @create: 2021-11-06 01:25
 **/
public class SingleResponse<T> extends Response {

    private T data;

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> singleResponse = new SingleResponse<>();
        singleResponse.setSuccess(true);
        singleResponse.setData(data);
        return singleResponse;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse buildFailure(String errCode, String errMessage) {
        SingleResponse response = new SingleResponse<>();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static SingleResponse buildFailure() {
        return buildFailure("","");
    }

    public static SingleResponse buildSuccess(){
        SingleResponse response = new SingleResponse();
        response.setSuccess(true);
        return response;
    }

}
