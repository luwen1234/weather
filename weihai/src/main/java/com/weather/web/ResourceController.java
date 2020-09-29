package com.weather.web;

import com.weather.assemble.BtnAssembler;
import com.weather.assemble.ResourceAssembler;
import com.weather.domain.model.Message;
import com.weather.domain.service.ResourceService;
import com.weather.dto.AddBtnCommand;
import com.weather.dto.AddResourceCommand;
import com.weather.dto.UpdateBtnCommand;
import com.weather.dto.UpdateResourceCommand;
import com.weather.web.vo.BtnRes;
import com.weather.web.vo.ResourceRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "资源", value = "资源")
@RestController
@RequestMapping("/admin/resource")
public class ResourceController {

    @Resource
    private ResourceService resourceService;

    @ApiOperation("分页查询")
    @GetMapping(value = "pageQuery")
    public Message<Page<ResourceRes>> pageQuery(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                                                @RequestParam(value = "name", required = false) String name){
        return Message.success().wrap(resourceService.pageQuery(name,pageNo,pageSize).map(ResourceAssembler.INSTANCE::buildResourceRes));
    }

    @ApiOperation("列表查询")
    @GetMapping(value = "listQuery")
    public Message<List<ResourceRes>> listQuery(@RequestParam(value = "name", required = false) String name){
        return Message.success().wrap(resourceService.listQuery(name).stream()
                .map(ResourceAssembler.INSTANCE::buildResourceRes).collect(Collectors.toList()));
    }

    @ApiOperation("新增")
    @PostMapping(value = "addResource")
    public Message<List<ResourceRes>> addBtn(@RequestBody List<AddResourceCommand> addResourceCommands){

        return Message.success().wrap(resourceService.addResource(addResourceCommands).stream()
                .map(ResourceAssembler.INSTANCE::buildResourceRes).collect(Collectors.toList()));
    }

    @ApiOperation("修改")
    @PostMapping(value = "updateResource")
    public Message<List<ResourceRes>> updateBtn(@RequestBody List<UpdateResourceCommand> updateResourceCommands){

        return Message.success().wrap(resourceService.updateResource(updateResourceCommands).stream()
                .map(ResourceAssembler.INSTANCE::buildResourceRes).collect(Collectors.toList()));
    }

    @ApiOperation("删除")
    @PostMapping(value = "deleteBtn")
    public Message deleteBtn(@RequestBody List<Long> ids){
        resourceService.deleteResource(ids);
        return Message.success();
    }
}
