package com.weather.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WH_BTN")
@Getter @Setter
@ApiModel("页面按钮")
public class Btn extends BaseEntity<Long>{

    @ApiModelProperty("按钮名称")
    @NotNull(message = "按钮名称不能为空！")
    @Column(name = "name")
    private String name;

    @ApiModelProperty("按钮备注")
    @Column(name = "remark")
    private String remark;
}
