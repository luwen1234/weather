package com.weather.utility;

import com.weather.constant.exception.WeatherRuntimeException;

import javax.validation.Validation;

public class ValidatorUtil {

    public static void validator(Object object, Class<?>... groups){
        Validation.buildDefaultValidatorFactory().getValidator().validate(object, groups).forEach(item -> {
            throw new WeatherRuntimeException(item.getMessage());
        });
    }
}
