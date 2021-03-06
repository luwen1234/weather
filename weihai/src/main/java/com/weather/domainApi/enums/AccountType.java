package com.weather.domainApi.enums;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@Getter
@ApiModel("账号类型")
public enum AccountType {

    COMMON,
    MANAGER,
    ADMIN
}
