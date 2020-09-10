package com.weather.domain.service.Impl;

import com.weather.domain.dao.BtnRepository;
import com.weather.domain.entity.Btn;
import com.weather.domain.service.BtnService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BtnServiceImpl implements BtnService {

    @Resource
    private BtnRepository btnRepository;

    @Override
    public Page<Btn> pageQuery(String name, Integer pageNo, Integer pageSize) {
        return btnRepository.findByName(name, PageRequest.of(pageNo, pageSize));
    }

    @Override
    public List<Btn> listQuery(String name) {
        return btnRepository.findByName(name);
    }
}
