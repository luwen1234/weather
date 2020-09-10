package com.weather.domain.service;

import com.weather.domain.entity.Btn;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BtnService {

    Page<Btn> pageQuery(String name, Integer pageNo, Integer pageSize);

    List<Btn> listQuery(String name);
}