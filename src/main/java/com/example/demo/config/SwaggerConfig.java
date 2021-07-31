package com.example.demo.config;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

/**
 * @author 王晋
 * @Date 2021/7/27 17:07
 * @Description:
 */
@EnableSwagger2//开启Swagger 注解
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        Profiles profiles = Profiles.of("wang");
        /*
        true 表示再
        false 表示不在
         */
        boolean open = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) //配置文档信息
                .enable(open)   //wang是我的开发环境，如果是这个环境的话就打开swagger，而是不是这个环境是再spring.profiles.active 配置的
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.ant("/**")) //允许访问所有映射下的接口
                .build();
    }

    private ApiInfo apiInfo() {
        /**
         * ApiInfo 对象并没有构造方法所以必须用构造器
         */
        //作者信息
        Contact contact = new Contact("王晋",
                "https://blog.csdn.net/Chongming_bird?spm=1000.2115.3001.5343",
                "951465476@qq.com");
        return new ApiInfo(
                "云启",   //Swagger APi文档标题
                "云启项目API文档",//Api 文档描述
                "1.1", //文档版本
                "云启项目组",
                DEFAULT_CONTACT,
                "Apache 2.0",//开源版本号
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

}


