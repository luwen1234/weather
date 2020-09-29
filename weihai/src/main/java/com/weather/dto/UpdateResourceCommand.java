package com.weather.dto;

import com.weather.domain.model.ResourceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@ApiModel("资源入参")
@Getter @Setter
public class UpdateResourceCommand {

    private Long id;

    @ApiModelProperty("资源名称")
    @NotNull(message = "资源名称不能为空！")
    private String name;

    @ApiModelProperty("资源类型")
    @NotNull(message = "资源类型不能为空！")
    private ResourceType type;

    @ApiModelProperty("前台资源url")
    private String url;

    @ApiModelProperty("后台资源api")
    private String api;
}
