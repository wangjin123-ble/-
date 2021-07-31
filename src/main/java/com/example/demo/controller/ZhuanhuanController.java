package com.example.demo.controller;


import com.example.demo.entity.Link;
import com.example.demo.form.ChangeForm;
import com.example.demo.service.ZhuanhuanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangjin
 * @since 2021-07-26
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/zhuanhuan")
@Api(value = "ZhuanhuanController", tags = "转换接口")
public class ZhuanhuanController {

    private final ZhuanhuanService zhuanhuanService;

    public ZhuanhuanController(ZhuanhuanService zhuanhuanService) {
        this.zhuanhuanService = zhuanhuanService;
    }

    /**
     * 生成短链接
     * @param changeForm
     * @return Caron
     */
    @ResponseBody
    @ApiOperation(value = "save", notes = "长转短")
    @PostMapping ("/api")
    public Object save(@RequestBody ChangeForm changeForm){
        System.out.println(changeForm);

        if (changeForm.getUrl() == null || "".equals(changeForm.getUrl())){
            return null;
        }
        if(changeForm.getUrl().startsWith("http://") || changeForm.getUrl().startsWith("https://")){
            Link zhuanhuan = new Link();
            zhuanhuan.setChang(changeForm.getUrl());
            return  zhuanhuanService.save(zhuanhuan);
        }else{
            return "网址必须以http或https开头";
        }
    }

    /**
     * 301跳转
     * @param url
     * @return
     */
    @PostMapping  ("/{url}")
    public String restoreUrl(@PathVariable("url") String url) {

        Link restoreUrl = zhuanhuanService.restoreUrl("http://cni.tips/" + url);

        if (restoreUrl != null && !"".equals(restoreUrl)) {
            return "redirect:" + restoreUrl;
        } else {
            return "redirect:http://www.cnilink.com";
//            return  "forward:/404.html";    //如果要访问本地html，@RequestMapping("/{url}")前面必须加一层路径/aa/{url}
        }

    }





}

