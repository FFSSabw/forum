package com.ffssabcloud.myblog.modal.bo;

import javax.swing.SpringLayout.Constraints;

import com.ffssabcloud.myblog.constant.Constrants;


/**
 * Restful返回对象
 *
 */
public class RestResponseBo<T> {
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 服务器响应时间
     */
    private long timestamp;
    
    /**
     * 响应信息
     */
    private String msg;
    
    /**
     * 请求是否成功
     */
    private boolean isSuccess;
    
    /**
     * 状态码
     */
    private int code = Constrants.RestResponse.SUCCESS;
    
    public RestResponseBo() {
        this.timestamp = System.currentTimeMillis();
    }
    
    public RestResponseBo(boolean isSuccess) {
        this();
        this.isSuccess = isSuccess;
    }
    
    public RestResponseBo(String msg) {
        this();
        this.msg = msg;
    }
    
    public RestResponseBo(T data) {
        this();
        this.data = data;
    }
    
    public RestResponseBo(boolean isSuccess, String msg) {
        this(isSuccess);
        this.msg = msg;
    }
    
    public RestResponseBo(boolean isSuccess, int code) {
        this(isSuccess);
        this.code = code;
    }
    
    public RestResponseBo(boolean isSuccess, String msg, T data) {
        this(isSuccess, msg);
        this.data = data;
    }
    
    public RestResponseBo(boolean isSuccess, String msg, int code) {
        this(isSuccess, msg);
        this.code = code;
    }
    
    public RestResponseBo(boolean isSuccess, String msg, T data, int code) {
        this(isSuccess, msg, data);
        this.code = code;
    }
    
    public static RestResponseBo ok() {
        return new RestResponseBo(true);
    }
    
    public static RestResponseBo ok(String msg) {
        return new RestResponseBo(true, msg);
    }
    
    public static <T> RestResponseBo ok(String msg, T data) {
        return new RestResponseBo(true, msg, data);
    }
    
    public static RestResponseBo fail() {
        return new RestResponseBo(false, Constrants.RestResponse.FAIL);
    }
    
    public static RestResponseBo fail(String msg) {
        return new RestResponseBo(false, msg, Constrants.RestResponse.FAIL);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
}