package com.weather.dto;

import com.weather.domain.model.StatusType;
import com.weather.web.vo.ResourceReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApiModel("权限入参")
@Getter @Setter
public class AddPrivilegeCommand {

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("启用状态")
    private StatusType status;

    @ApiModelProperty("资源列表")
    private List<ResourceReq> resources = new ArrayList<>();
}
