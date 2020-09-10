package com.weather.domain.entity;

import com.weather.domain.model.StatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WH_PRIVILEGE")
@Getter
@Setter
@ApiModel("权限")
public class Privilege extends BaseEntity<Long>{

    @ApiModelProperty("权限名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty("启用状态")
    @Column(name = "status")
    @Enumerated
    private StatusType status;

    @ApiModelProperty("对应资源")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "WH_PRIVILEGE_RESOURCE",
            joinColumns = @JoinColumn(name = "privilege_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<Resource> resources = new ArrayList<>();
}
