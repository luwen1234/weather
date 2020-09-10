package com.weather.domain.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel("资源类型 菜单，API")
@Getter
public enum ResourceType {
    MENU,API
}
