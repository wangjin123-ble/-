package com.example.demo.bean.exception;

import com.example.demo.bean.wrapper.ResultWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王晋
 * @Date 2021/7/王晋 16:45
 * @Description: 全局异常
 */
@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResultWrapper exceptionHandle(RuntimeException e){
        e.printStackTrace();
        return ResultWrapper.failure("系统错误");
    }

    @ExceptionHandler
    @ResponseBody
    public ResultWrapper exceptionHandle(SysException e){
        return ResultWrapper.failure(e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public ResultWrapper exceptionHandle(GlobalException e){
        return ResultWrapper.failure(e.getMessage());
    }

}
