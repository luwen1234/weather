package com.weather.domain.service.Impl;

import com.weather.domain.dao.ReportRepository;
import com.weather.domain.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportRepository reportRepository;
}
