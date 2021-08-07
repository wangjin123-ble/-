package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.example.demo.controller.ZhuanhuanController;
import com.example.demo.entity.Link;
import com.example.demo.form.ChangeForm;
import com.example.demo.mapper.ZhuanhuanMapper;
import com.example.demo.service.ZhuanhuanService;
import com.example.demo.service.impl.ZhuanhuanServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ZhuanhuanController zhuanhuanController;
    @Autowired
    private ZhuanhuanMapper zhuanhuanMapper;
    @Autowired
    private ZhuanhuanServiceImpl zhuanhuanService;
    @Test
    void contextLoads() {
        Link link=new Link();
        link.setDuan("https://blog");
        link.setChang("https://blog.csdn.net/denghan9435/article/details/102398880");
        QueryWrapper<Link> wrapper = new QueryWrapper<>();
        wrapper.eq("chang",link.getChang());
        Link link1 =  zhuanhuanMapper.selectOne(wrapper);
        System.out.println(link1);

    }
    @Test
    void test1(){
        ChangeForm  changeForm =new ChangeForm();

         String url="https://tv.cctv.com/lm/index.shtml?spm=C28340.P9dhkRStLqPh.ENlPq2DiQc4R.29";
         changeForm.setUrl(url);
        zhuanhuanController.save(changeForm);
        System.out.println();

    }
    @Test
    void test2(){
        String curl="https://tv.cctv.com/lm/index.shtml?spm=C28340.P9dhkRStLqPh.ENlPq2DiQc4R.29";
        String durl="https://aefefesfefesfsefesf";
Link link=new Link();
link.setChang(curl);
link.setDuan(durl);

    }
    @SneakyThrows
    @Test
    void test3() {
    }


}



