package com.py.common.protocol;

import java.io.Serializable;

import com.py.common.utils.Code;

/**
 * @author jzl
 */
public class Response<T> implements Serializable {

    /**  */
    private static final long serialVersionUID = 2481130403933319421L;
    private String            status;                                 //请求状态 1 成功 0失败
    private String            msg;                                    //请求信息
    private T                 data;

    private Response(T data, String status, String msg) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }

    /**
     * 返回成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> successResponse(T data) {
        return new Response<T>(data, Code.codeData.REQUESTSUCCESS.code,
            Code.msg.REQUESTSUCCESS.desc);
    }

    /**
     * 返回成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> successResponse(String msg, T data) {
        return new Response<T>(data, Code.codeData.REQUESTSUCCESS.code,
            String.format(msg, Code.msg.USER_DEFINED.desc));
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T> Response<T> successResponse() {
        return new Response<T>(null, Code.codeData.REQUESTSUCCESS.code,
            Code.msg.REQUESTSUCCESS.desc);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> Response<T> failedResponse() {
        return new Response<T>(null, Code.codeData.REQUESTFAILED.code, Code.msg.REQUESTFAILED.desc);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> Response<T> failedResponse(Code.codeData codeData, Code.msg msg) {
        return new Response<T>(null, codeData.code, msg.desc);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> Response<T> failedResponse(String msg) {
        return new Response<T>(null, Code.codeData.USER_DEFINED.code,
            String.format(msg, Code.msg.USER_DEFINED.desc));
    }

    /**
     * 返回失败结果
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Response<T> failedResponse(String code, String msg) {
        return new Response<T>(null, code, msg);
    }

    /**
     * 返回异常结果
     * @param <T>
     * @return
     */
    public static <T> Response<T> systemErrorResponse() {
        return new Response<T>(null, Code.codeData.SYSTEMERROR.code, Code.msg.SYSTEMERROR.desc);
    }

    /**
     * 返回异常结果
     * @param <T>
     * @return
     */
    public static <T> Response<T> systemErrorResponse(String msg) {
        return new Response<T>(null, Code.codeData.USER_DEFINED.code,
            String.format(msg, Code.msg.USER_DEFINED.desc));
    }

    /**
     * 返回失败结果
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> failedDataResponse(T data, String code, String msg) {
        return new Response<T>(data, code, msg);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
