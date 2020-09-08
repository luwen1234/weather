package com.weather.domain.entity;

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


    @Column(name = "report_type_id")
    private Long reportTypeId;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "report_time")
    private Date reportTime;

    @Column(name = "report_context")
    private String reportContext;

    @Column(name = "reportor_id")
    private Long reportorId;

    @Column(name = "reportor")
    private String reportor;

    @Column(name = "report_status")
    private String reportStatus;

    @Transient
    private Date startTime;
}
