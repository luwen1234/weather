package com.weather.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@ApiModel("按钮入参")
@Getter @Setter
public class AddBtnCommand {

    @ApiModelProperty("名称")
    @NotNull(message = "按钮名称不能为空！")
    private String name;

    @ApiModelProperty("备注")
    private String remark;
}
