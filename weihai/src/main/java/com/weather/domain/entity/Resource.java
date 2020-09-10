package com.weather.domain.entity;

import com.weather.domain.model.ResourceType;
import com.weather.domain.model.StatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WH_RESOURCE")
@Getter @Setter
@ApiModel("资源，包括菜单和后台api,每个资源只对应一个api或者菜单")
public class Resource extends BaseEntity<Long>{

    @ApiModelProperty("资源名称")
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated
    @NotNull(message = "资源类型不能为空！")
    private ResourceType type;

    @Column(name = "url", length = 500)
    private String url;

    @Column(name = "api", length = 500)
    private String api;

    @Column(name = "status")
    @Enumerated
    private StatusType status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "WH_RESOURCE_BTN",
            joinColumns = @JoinColumn(name = "resource_id"),
            inverseJoinColumns = @JoinColumn(name = "btn_id")
    )
    private List<Btn> buttons = new ArrayList<>();
}
