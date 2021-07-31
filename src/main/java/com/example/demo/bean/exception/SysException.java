package com.example.demo.bean.exception;

import com.example.demo.bean.exception.BaseError;

/**
 * @author 王晋
 * @Date 2021/7/27 16:46
 * @Description: 系统异常
 */
public class SysException extends RuntimeException{

    protected int code;

    public SysException() {
    }

    public SysException(Throwable cause) {
        super(cause);
    }

    public SysException(String message) {
        super(message);
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysException(int code, String message) {
        super(message);
        this.code = code;
    }

    public SysException(int code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
    }

    public SysException(BaseError codeEnum, Object... args) {
        super(String.format(codeEnum.getMessage(), args));
        this.code = codeEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ",\"message\":\"" + getMessage() +
                "\"}";
    }
}
