package com.weather.config;

import com.weather.constant.exception.WeatherRuntimeException;
import com.weather.domain.model.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = WeatherRuntimeException.class)
    public Message exceptionHandler(WeatherRuntimeException e){
        return Message.error("500", e.getMessage());
    }
}
