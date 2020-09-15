package com.weather.domainApi.enums;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel("启用状态")
@Getter
public enum  StatusType {
    ALLOW,
    FORBID
}
