package com.weather.domain.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@Getter
@ApiModel("数据库记录删除类型")
public enum  ActivityType {
    DELETE,
    LIVING
}
