package com.weather.web;

import com.weather.assemble.BtnAssembler;
import com.weather.domain.model.Message;
import com.weather.domain.service.BtnService;
import com.weather.dto.AddBtnCommand;
import com.weather.dto.UpdateBtnCommand;
import com.weather.web.vo.BtnRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "按钮", value = "按钮")
@RestController
@RequestMapping("/admin/btn")
public class BtnController {

    @Resource
    private BtnService btnService;

    @ApiOperation("分页查询")
    @GetMapping(value = "pageQuery")
    public Message<Page<BtnRes>> pageQuery(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                           @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                           @RequestParam(value = "name", required = false) String name){
        return Message.success().wrap(btnService.pageQuery(name,pageNo,pageSize).map(BtnAssembler.INSTANCE::buildBtnRes));
    }

    @ApiOperation("列表查询")
    @GetMapping(value = "listQuery")
    public Message<List<BtnRes>> listQuery(@RequestParam(value = "name", required = false) String name){
        return Message.success().wrap(btnService.listQuery(name).stream().map(BtnAssembler.INSTANCE::buildBtnRes).collect(Collectors.toList()));
    }

    @ApiOperation("新增")
    @PostMapping(value = "addBtn")
    public Message<List<BtnRes>> addBtn(@RequestBody List<AddBtnCommand> addBtnCommands){

        return Message.success().wrap(btnService.addBtn(addBtnCommands).stream().map(BtnAssembler.INSTANCE::buildBtnRes).collect(Collectors.toList()));
    }

    @ApiOperation("修改")
    @PostMapping(value = "updateBtn")
    public Message<List<BtnRes>> updateBtn(@RequestBody List<UpdateBtnCommand> updateBtnCommands){

        return Message.success().wrap(btnService.updateBtn(updateBtnCommands).stream().map(BtnAssembler.INSTANCE::buildBtnRes).collect(Collectors.toList()));
    }

    @ApiOperation("删除")
    @PostMapping(value = "deleteBtn")
    public Message deleteBtn(@RequestBody List<Long> ids){
        btnService.deleteBtn(ids);
        return Message.success();
    }
}
