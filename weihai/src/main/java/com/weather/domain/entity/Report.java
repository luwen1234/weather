package com.weather.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "WH_REPORT")
@Getter @Setter
public class Report extends BaseEntity<Long>{

    @ApiModelProperty("预报类型id")
    @Column(name = "report_type_id")
    private Long reportTypeId;

    @ApiModelProperty("预报时间")
    @Column(name = "report_time")
    private Date reportTime;

    @ApiModelProperty("预报内容")
    @Column(name = "report_context")
    private String reportContext;

    @ApiModelProperty("预报状态")
    @Column(name = "report_status")
    private String reportStatus;

    @Transient
    private Date startTime;
}
