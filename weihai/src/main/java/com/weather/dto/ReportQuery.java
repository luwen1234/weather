package com.weather.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel("预报分页查询参数")
@Getter @Setter
public class ReportQuery {

    @ApiModelProperty("分页页码")
    private Integer pageNo = 1;

    @ApiModelProperty("分页记录数")
    private Integer pageSize = 20;

    @ApiModelProperty("预报人ID")
    private Long reportId;

    @ApiModelProperty("预报开始时间")
    private Date reportStartDate;

    @ApiModelProperty("预报结束时间")
    private Date reportEndDate;

    @ApiModelProperty("预报类型ID")
    private Long reportTypeId;

    @ApiModelProperty("预报内容")
    private String reportContext;
}
