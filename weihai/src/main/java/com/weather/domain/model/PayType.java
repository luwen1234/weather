package com.weather.domain.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@Getter
@ApiModel("缴费状态")
public enum PayType {

    PAY, UNPAY
}
