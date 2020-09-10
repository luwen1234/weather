package com.weather.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("按钮出参")
@Getter @Setter
public class BtnRes {

    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;
}
