package com.weather.web.vo;

import com.weather.domain.model.ResourceType;
import com.weather.domain.model.StatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@ApiModel("按钮出参")
@Getter @Setter
public class ResourceReq {

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("资源类型")
    @NotNull(message = "资源类型不能为空！")
    private ResourceType type;

    @ApiModelProperty("资源前台url")
    private String url;

    @ApiModelProperty("资源后台api")
    private String api;

    @ApiModelProperty("资源状态启用禁用")
    private StatusType status;

    @ApiModelProperty("资源包含按钮")
    private List<BtnReq> buttons = new ArrayList<>();
}
