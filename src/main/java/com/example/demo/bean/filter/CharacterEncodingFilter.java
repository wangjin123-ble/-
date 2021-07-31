package com.example.demo.bean.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王晋
 * @Date 2021/7/27 16:47
 * @Description: 解决中文乱码
 */
@WebFilter(urlPatterns = "/**",filterName = "CharacterEncodingFilter")   //作用于所有路径的Filter
public class CharacterEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("UTF-8");   //设置请求的字符编码为UTF-8

        response.setCharacterEncoding("UTF-8");  //设置响应的字符编码为UTF-8

        filterChain.doFilter(request , response); //添加到过滤链当中
    }
}
