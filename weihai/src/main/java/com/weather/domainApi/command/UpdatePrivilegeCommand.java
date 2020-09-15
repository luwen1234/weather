package com.weather.domainApi.command;

import com.weather.domain.entity.Resource;
import com.weather.domainApi.enums.StatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApiModel("权限入参")
@Getter @Setter
public class UpdatePrivilegeCommand {


    private Long id;

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("启用状态")
    private StatusType status;

    @ApiModelProperty("对应资源")
    private List<Resource> resources = new ArrayList<>();
}
