package com.example.demo.bean.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王晋
 * @Date 2021/7/27 16:59
 * @Description: 结果包装
 */
@Data
@Component
public class ResultWrapper<T> implements Serializable {
    final static Integer CODE_SUCCESS = 200;   //运行成功的状态码

    final static String MESSAGE_SUCCESS = "操作成功";

    final static Integer CODE_FAILURE = -1;   //运行失败的状态码

    final static String MESSAGE_FAILURE = "操作失败";

    private Integer code;

    //如果值为空的话就不进行序列化
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private String message;

    public ResultWrapper() {
    }

    public ResultWrapper(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    //返回code200 message操作成功 没有data
    public static<T> ResultWrapper<T> success() {
        return new ResultWrapper<>(CODE_SUCCESS, null, MESSAGE_SUCCESS);
    }

    //返回code200 message自定义 没有data
    public static<T> ResultWrapper success(String message) {

        return new ResultWrapper<>(CODE_SUCCESS, null, message);
    }

    //返回code200 data数据 message自定义

    public static <T> ResultWrapper<T> successWithData(T data)
    {
        return new ResultWrapper<>(CODE_SUCCESS, data, "请求成功");
    }

    /*
    方法中的泛型定义的是在修饰符后面的T
    而这里传入给ResultWrapper 和 successWithData（T data）
    的T也是方法泛型的值而不是在泛型类里面定义的值
     */
    //返回code200 data数据 message操作成功
    public static<T> ResultWrapper<T> successWithData(String key, Object value) {
        Map data = new HashMap(1);
        data.put(key, value);
        return new ResultWrapper(CODE_SUCCESS, data, MESSAGE_SUCCESS);
    }

    //返回code-1 message操作失败 没有data
    public static<T> ResultWrapper<T> failure() {
        return new ResultWrapper<>(CODE_FAILURE, null, MESSAGE_FAILURE);
    }

    //返回code-1 message自定义 没有data
    public static<T> ResultWrapper<T> failure(String message) {
        return new ResultWrapper<>(CODE_FAILURE, null, message);
    }

    //指定失效码，和操作失败数据，没有data
    public static<T> ResultWrapper<T> failure(Integer code, String message) {
        return new ResultWrapper<>(code, null, message);
    }

    @Override
    public String toString() {
        return "ResultWrapper{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code.equals(CODE_SUCCESS);
    }

}
