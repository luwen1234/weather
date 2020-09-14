package com.weather.domain.service.Impl;

import com.weather.assemble.ReportAssembler;
import com.weather.domain.dao.ReportRepository;
import com.weather.domain.entity.Report;
import com.weather.domain.model.ActivityType;
import com.weather.domain.service.ReportService;
import com.weather.dto.AddReportCommand;
import com.weather.dto.ReportQuery;
import com.weather.dto.UpdateReportCommand;
import com.weather.utility.ValidatorUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportRepository reportRepository;

    @Override
    public Page<Report> pageQuery(ReportQuery reportQuery) {
        return reportRepository.pageQuery(reportQuery.getReportTypeId(),
                reportQuery.getReportStartDate(),
                reportQuery.getReportEndDate(),
                reportQuery.getReportContext(),
                reportQuery.getReportId(),
                PageRequest.of(reportQuery.getPageNo(), reportQuery.getPageSize()));
    }

    @Override
    public List<Report> listQuery(ReportQuery reportQuery) {
        return reportRepository.listQuery(reportQuery.getReportTypeId(),
                reportQuery.getReportStartDate(),
                reportQuery.getReportEndDate(),
                reportQuery.getReportContext(),
                reportQuery.getReportId());
    }

    @Override
    public List<Report> addReport(List<AddReportCommand> addReportCommands) {

        Assert.notEmpty(addReportCommands, "保存的预报信息不能为空！");
        addReportCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Report> reports = addReportCommands.stream().map(addReportCommand -> {
            return ReportAssembler.INSTANCE.buildReport(addReportCommand).createBy(1L);
        }).collect(Collectors.toList());
        reportRepository.saveAll(reports);
        return reports;
    }

    @Override
    public List<Report> updateReport(List<UpdateReportCommand> updateReportCommands) {

        Assert.notEmpty(updateReportCommands, "保存的预报信息不能为空！");
        updateReportCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Long> updateIds = updateReportCommands.stream().map(UpdateReportCommand::getId).collect(Collectors.toList());
        Map<Long, UpdateReportCommand> updateCache = updateReportCommands.stream().collect(Collectors.toMap(v -> v.getId(), v->v));

        List<Report> exists = reportRepository.findByIds(updateIds);
        Assert.notEmpty(exists, "保存的预报信息不能为空！");
        reportRepository.saveAll(exists.stream().filter(item -> Objects.nonNull(updateCache.get(item.getId())))
                .map(item -> {
                    Report report = ReportAssembler.INSTANCE.buildReport(updateCache.get(item.getId())).modifyBy(1L);
                    report.setCreateBy(item.getCreateBy());
                    report.setCreateOn(item.getCreateOn());
                    return report;
                }).collect(Collectors.toList()));
        return exists;
    }

    @Override
    public Report getReportById(Long id) {

        return reportRepository.findByIds(Arrays.asList(id)).stream().findFirst().orElse(null);
    }

    @Override
    public void deleteReport(List<Long> ids) {

        List<Report> exists = reportRepository.findByIds(ids);
        Assert.notEmpty(exists, "删除的预报不能为空！");
        reportRepository.deleteAll(exists.stream().map(item -> {
            item.setActivity(ActivityType.DELETE);
            return item;
        }).collect(Collectors.toList()));
    }
}
