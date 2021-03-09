package com.damai.dto.res;

/**
 * @param <T>
 * @author narvik.su decision-center返回的数据格式
 */
public class CenterResultDto<T> {
    private boolean status;
    private int code;
    private String message;
    private T data;

    public CenterResultDto() {

    }

    public CenterResultDto(T data) {
        this(true, "", data);
    }

    public CenterResultDto(boolean status, T data) {
        this(status, "", data);
    }

    public CenterResultDto(boolean status, Integer code, String msg) {
        this(status, code, msg, null);
    }

    public CenterResultDto(boolean status, String message, T data) {
        this(status, 0, message, data);
    }

    public CenterResultDto(boolean status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CenterResultDto(boolean status, String message) {
        this(status, message, null);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CenterResultDto{" +
                "status=" + status +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
