package com.weather.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "WH_ROLE")
@Getter
@Setter
public class Role extends BaseEntity<Long>{

    @ApiModelProperty("角色名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty("备注")
    @Column(name = "remark")
    private String remark;

    public Role createBy(Long createBy){
        this.setCreateBy(createBy);
        this.setCreateOn(new Date());
        return this;
    }

    public Role modifyBy(Long modifyBy){
        this.setModifyBy(modifyBy);
        this.setModifyOn(new Date());
        return this;
    }
}
