package com.weather.web;

import com.weather.domain.assembler.ReportAssembler;
import com.weather.domain.entity.Report;
import com.weather.domain.model.Message;
import com.weather.domain.service.ReportService;
import com.weather.domainApi.command.AddReportCommand;
import com.weather.domainApi.query.ReportQuery;
import com.weather.domainApi.command.UpdateReportCommand;
import com.weather.web.vo.ReportRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "预报", value = "预报")
@RestController
@RequestMapping("/admin/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @ApiOperation("根据id获取预报")
    @GetMapping(value = "/getReportById/{id}")
    public Message<ReportRes> getReportById(@PathVariable(value = "id") Long id){

        return Message.success().wrap(ReportAssembler.INSTANCE.buildReportRes(reportService.getReportById(id)));
    }

    @ApiOperation("预报列表")
    @PostMapping(value = "/listQuery")
    public Message<ReportRes> listQuery(@RequestBody ReportQuery reportQuery){

        return Message.success().wrap( reportService.listQuery(reportQuery).stream().map(ReportAssembler.INSTANCE::buildReportRes).collect(Collectors.toList()));
    }

    @ApiOperation("预报分页")
    @PostMapping(value = "/pageQuery")
    public Message<ReportRes> pageQuery(@RequestBody ReportQuery reportQuery){

        return Message.success().wrap( reportService.pageQuery(reportQuery).stream().map(ReportAssembler.INSTANCE::buildReportRes).collect(Collectors.toList()));
    }

    @ApiOperation("新增")
    @PostMapping(value = "addReport")
    public Message<List<ReportRes>> addBtn(@RequestBody List<AddReportCommand> addReportCommands){

        return Message.success().wrap(reportService.addReport(addReportCommands).stream().map(ReportAssembler.INSTANCE::buildReportRes).collect(Collectors.toList()));
    }

    @ApiOperation("修改")
    @PostMapping(value = "updateReport")
    public Message<List<ReportRes>> updateBtn(@RequestBody List<UpdateReportCommand> updateReportCommands){

        return Message.success().wrap(reportService.updateReport(updateReportCommands).stream().map(ReportAssembler.INSTANCE::buildReportRes).collect(Collectors.toList()));
    }

    @ApiOperation("删除")
    @PostMapping(value = "deleteReport")
    public Message deleteReport(@RequestBody List<Long> ids){
        reportService.deleteReport(ids);
        return Message.success();
    }

    private void pretty(Report report){

        String result = "";
        String context = "";
        context = report.getReportContext();
        if("".equals(context)==false){
            //先用回车分割,没有就用空格分割
            String[] temps = context.split("\r\n");
            if(temps != null && temps.length == 1){

                context.replaceAll("\\W+", " ");
                temps = context.split(" ");
            }
            for(String temp : temps){
                result += temp+"<br />";
            }
        }
        report.setReportContext(result.replaceAll("(<br />)+", "$1")
                .replaceAll("\\n", "").replaceAll("\n", ""));
    }
}
