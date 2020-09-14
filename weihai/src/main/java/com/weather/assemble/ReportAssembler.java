package com.weather.assemble;

import com.weather.domain.entity.Report;
import com.weather.dto.AddReportCommand;
import com.weather.dto.UpdateReportCommand;
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
