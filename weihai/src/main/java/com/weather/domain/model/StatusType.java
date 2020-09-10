package com.weather.domain.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel("启用状态")
@Getter
public enum  StatusType {
    ALLOW,
    FORBID
}
