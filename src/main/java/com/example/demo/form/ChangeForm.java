package com.example.demo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("长短转换接受实体")
@Data
public class ChangeForm {

    @ApiModelProperty(value = "有效时间")
    private String effectTime;
    @ApiModelProperty(value = "链接地址")
    private String url;

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChangeForm(String effectTime, String url){
        this.effectTime=effectTime;
        this.url=url;

    }
    public ChangeForm(){

    }



}
