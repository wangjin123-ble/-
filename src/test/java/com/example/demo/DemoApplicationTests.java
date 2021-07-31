package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.controller.ZhuanhuanController;
import com.example.demo.entity.Link;
import com.example.demo.form.ChangeForm;
import com.example.demo.mapper.ZhuanhuanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ZhuanhuanController zhuanhuanController;
    @Autowired
    private ZhuanhuanMapper zhuanhuanMapper;
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

         String url="https://www.cnblogs.com/uqing/p/10163094.html";
         changeForm.setUrl(url);
        zhuanhuanController.save(changeForm);
        System.out.println();

    }
    @Test
    void test2(){

    }

}
