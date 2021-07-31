package com.example.demo.bean.exception;

import lombok.Data;

/**
 * @author 王晋
 * @Date 2021/7/27 16:44
 * @Description： 通用异常类
 */
@Data
public class GlobalException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public GlobalException(String message) {
        this.message = message;
    }
}
