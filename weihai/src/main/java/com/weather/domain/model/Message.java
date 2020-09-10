package com.weather.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Message<T> {

    private String code;

    private String msg;

    private T data;

    public static Message success(){
        Message message = new Message();
        message.setCode("1");
        message.setMsg("success");
        return message;
    }

    public static Message error(String code, String msg){
        Message message = new Message();
        message.setCode(code);
        message.setMsg(msg);
        return message;
    }

    public Message wrap(T data){
        this.data = data;
        return this;
    }
}
