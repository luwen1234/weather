package com.weather.domain.assembler;

import com.weather.domain.entity.Report;
import com.weather.domainApi.command.AddReportCommand;
import com.weather.domainApi.command.UpdateReportCommand;
import com.weather.web.vo.ReportRes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportAssembler {

    ReportAssembler INSTANCE = Mappers.getMapper(ReportAssembler.class);

    ReportRes buildReportRes(Report report);

    Report buildReport(AddReportCommand addReportCommand);

    Report buildReport(UpdateReportCommand updateReportCommand);
}
