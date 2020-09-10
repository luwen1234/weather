package com.weather.web;

import com.weather.web.vo.ReportRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/report")
public class ReportController {



/*    @RequestMapping(value="/showById/method=func={func}&opr={opr}&token={token}")*/
    /**
     * 根据id获得天气信息
     * @param id
     * @return
     */
/*    @GetMapping("/{id}")
    public ReportRes getReportById(@PathVariable(value = "id") Long id){

        return findById(reportService,report.getId());
    }*/

  /*  *//**
     * 根据id获得天气信息
     * @param request
     * @param report
     * @return
     *//*
    @RequestMapping(value="/showByDaohang")
    @ResponseBody
    public AjaxResult getReportByDaohang(HttpServletRequest request,Report report){

        Report param = new Report();
        param.setReportTypeId(1L);
        param.setReportTime(new Date());
        return findByModel(reportService,param);
    }

    *//**
     * 获得天气信息
     * @param request
     * @param report
     * @return
     *//*
    @RequestMapping(value="/getPhoneReport/method=func={func}&iframe={iframe}&opr={opr}&token={token}")
    @ResponseBody
    public Report getPhoneReport(HttpServletRequest request,Long id,Long part){

        Report report = new Report();
        Date date = new Date();
        switch(part.intValue()){

            case 1:
                report.setReportTime(DateUtil.getLongDate(date, 0));
                break;
            case 2:
                report.setReportTime(DateUtil.getLongDate(date, 1));
                break;
            case 3:
                report.setReportTime(DateUtil.getLongDate(date, 2));
                break;
        }

        if(id == 13){

            //市区预报
            report.setReportTypeId(1L);

        }else if(id == 14){

            //海区预报
            report.setReportTypeId(2L);
        }else if(id == 15){

            //上下班预报
            report.setReportTypeId(6L);
        }else if(id == 17){

            //3~7日预报
            report.setReportTypeId(3L);
        }else if(id == 18){

            //中长期预报
            report.setReportTypeId(5L);
        }else if(id == 19){

            //省短期预报
            report.setReportTypeId(4L);
        }else if(id == 25){

            //威海指数预报
            report.setReportTypeId(7L);
        }else if(id ==27){
            //重要天气预报
            report.setReportTypeId(8L);
        }else if(id == 29){
            //短临预报
            report.setReportTypeId(9L);
        }
        Report result = new Report();
        List<Report> reports = this.reportService.findByModel(report);
        if(reports != null && reports.size() > 0){

            *//*			this.pretty(reports.get(0));*//*
            result = reports.get(0);
        }else{

            result = this.reportService.getReportByDate(report);
            *//*			this.pretty(result);*//*
        }
        return result;
    }

    *//**
     * 获得天气信息
     * @param request
     * @param report
     * @return
     *//*
    @RequestMapping(value="/getReportLatest/method={func}&iframe={iframe}&opr={opr}&token={token}")
    @ResponseBody
    public Report getReportLatest(HttpServletRequest request,Long id){

        Report report = new Report();
        Date date = new Date();
        report.setReportTime(DateUtil.getLongDate(date, 0));
        if(id == 13){

            //市区预报
            report.setReportTypeId(1L);

        }else if(id == 14){

            //海区预报
            report.setReportTypeId(2L);
        }else if(id == 15){

            //上下班预报
            report.setReportTypeId(6L);
        }else if(id == 17){

            //3~7日预报
            report.setReportTypeId(3L);
        }else if(id == 18){

            //中长期预报
            report.setReportTypeId(5L);
        }else if(id == 19){

            //省短期预报
            report.setReportTypeId(4L);
        }else if(id == 25){

            //威海指数预报
            report.setReportTypeId(7L);
        }else if(id ==27){
            //重要天气预报
            report.setReportTypeId(8L);
        }else if(id == 29){
            //短临预报
            report.setReportTypeId(9L);
        }
        Report result = new Report();
        List<Report> reports = this.reportService.findByModel(report);
        if(reports != null && reports.size() > 0){

            *//*			this.pretty(reports.get(0));*//*
            result = reports.get(0);
        }else{

            result = this.reportService.getReportByDate(report);
            *//*			this.pretty(result);*//*

        }
        return result;
    }

    *//**
     * 分页显示Report
     * @param request
     * @param report
     * @param pageVo
     * @return
     *//*
    @RequestMapping(value="/showList/method=func={func}&opr={opr}&token={token}")
    @ResponseBody
    public PageAjaxResult getReportByPage(HttpServletRequest request,Report report,PageVo pageVo){

        return findByPage(reportService,report,pageVo);

    }

    *//**
     * 分页显示Report
     * @param request
     * @param report
     * @param pageVo
     * @return
     *//*
    @RequestMapping(value="/showListByIframe/method=func={func}&iframe={iframe}&opr={opr}&token={token}")
    @ResponseBody
    public PageAjaxResult getReportByPageByIframe(HttpServletRequest request,Report report,PageVo pageVo){

        return findByPage(reportService,report,pageVo);

    }

    *//**
     * 删除
     * @param keys
     * @return
     *//*
    @RequestMapping(value="/del/method=func={func}&opr={opr}&token={token}")
    @ResponseBody
    public AjaxResult delete(String keys){

        String[] keyStrs = keys.split(",");
        List<Long> ids = new ArrayList<>();
        for(String key : keyStrs){

            ids.add(Long.parseLong(key));
        }
        return super.remove(reportService,ids);
    }

    *//**
     * 新增或者修改
     * @param report
     * @return
     *//*
    @RequestMapping(value="/addOrModify/method=func={func}&opr={opr}&token={token}")
    @ResponseBody
    public AjaxResult addOrModify(Report report){

        User user = (User) getSession().getAttribute("user");
        report.setReportorId(user.getId());
        if(report.getId() == null){

            return super.add(reportService,report,"新增");
        }else{

            return super.modify(reportService,report,"修改");
        }
    }

    *//**
     * 去添加界面
     * @param id
     * @param request
     * @return
     *//*
    @RequestMapping(value="/editForm")
    public String editForm(HttpServletRequest request,Long id){

        //获得天气预报类型
//		Dictionary dictionary = new Dictionary();
//		dictionary.setDicType(com.weihai.tool.Dictionary.WEATHER_REPORT);
//		List<Dictionary> dictionarys = this.dicionaryService.findByModel(dictionary);
//		request.setAttribute("dictionarys",dictionarys);
//		//如果id不为空，表示是编辑,返回编辑对象
//		if(id != null){
//
//			Report report = this.reportService.findById(id);
//			request.setAttribute("obj", report);
//		}
        return "";
    }


    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    public void setDicionaryService(DictionaryService dicionaryService) {
        this.dicionaryService = dicionaryService;
    }

    public void pretty(Report report){

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
        report.setReportContext(result.replaceAll("(<br />)+", "$1").replaceAll("\\n", "").replaceAll("\n", ""));
    }

    *//**
     * 新增或者修改
     * @param report
     * @return
     *//*
    @RequestMapping(value="/addReortInterface", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addReortInterface(@RequestBody Report report, HttpServletRequest request){

        report.setReportorId(12L);
        if(report.getReportContext() != null){
            report.setReportContext(report.getReportContext().replaceAll("(<br />)+", "$1"));
        }
        return super.add(reportService,report,"新增");
    }*/
}
