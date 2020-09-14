package com.weather.domain.service;

import com.weather.domain.entity.Report;
import com.weather.dto.AddReportCommand;
import com.weather.dto.ReportQuery;
import com.weather.dto.UpdateReportCommand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReportService {

    Page<Report> pageQuery(ReportQuery reportQuery);

    List<Report> listQuery(ReportQuery reportQuery);

    List<Report> addReport(List<AddReportCommand> addReportCommands);

    List<Report> updateReport(List<UpdateReportCommand> updateReportCommands);

    Report getReportById(Long id);

    void deleteReport(List<Long> ids);
}
