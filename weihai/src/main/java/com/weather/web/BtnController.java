package com.weather.web;

import com.weather.assemble.BtnAssembler;
import com.weather.domain.entity.Btn;
import com.weather.domain.model.Message;
import com.weather.domain.service.BtnService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/btn")
public class BtnController {

    @Resource
    private BtnService btnService;

    @GetMapping(value = "pageQuery")
    public Message<Page<Btn>> pageQuery(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                       @RequestParam(value = "name", required = false) String name){
        return Message.success().wrap(btnService.pageQuery(name,pageNo,pageSize).map(BtnAssembler.INSTANCE::buildBtnRes));
    }

    @GetMapping(value = "listQuery")
    public Message<List<Btn>> listQuery(@RequestParam(value = "name", required = false) String name){
        return Message.success().wrap(btnService.listQuery(name).stream().map(BtnAssembler.INSTANCE::buildBtnRes).collect(Collectors.toList()));
    }
}
