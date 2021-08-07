package com.example.demo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("长短转换接受实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeForm {

    @ApiModelProperty(value = "有效时间")
    private Long effectTime;
    @ApiModelProperty(value = "链接地址")
    private String url;
}
