package com.weather.domain.entity;

import com.weather.domainApi.enums.ActivityType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "WH_REPORT")
@Getter @Setter
public class Report extends BaseEntity<Long>{

    @ApiModelProperty("预报类型id")
    @Column(name = "report_type_id")
    @NotNull(message = "预报类型id不能为空！")
    private Long reportTypeId;

    @ApiModelProperty("预报时间")
    @Column(name = "report_date")
    @NotNull(message = "预报时间不能为空！")
    private Date reportDate;

    @ApiModelProperty("预报内容")
    @Column(name = "report_context")
    private String reportContext;

    @ApiModelProperty("预报状态")
    @Column(name = "activity")
    @Enumerated(value = EnumType.ORDINAL)
    private ActivityType activity;

    public Report(){
        this.activity = ActivityType.LIVING;
    }

    public Report createBy(Long createBy){
        this.setCreateBy(createBy);
        this.setCreateOn(new Date());
        return this;
    }

    public Report modifyBy(Long modifyBy){
        this.setModifyBy(modifyBy);
        this.setModifyOn(new Date());
        return this;
    }
}
