package com.weather.domainApi.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel("预报入参")
@Getter
@Setter
public class AddReportCommand {

    @ApiModelProperty("预报类型id")
    @NotNull(message = "预报类型id不能为空！")
    private Long reportTypeId;

    @ApiModelProperty("预报时间")
    @NotNull(message = "预报时间不能为空！")
    private Date reportDate;

    @ApiModelProperty("预报内容")
    private String reportContext;
}
