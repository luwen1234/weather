package com.weather.domain.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel("性别类型")
@Getter
public enum GenderType {
    MALE,
    FEMALE
}
