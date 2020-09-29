package com.weather.domain.service.Impl;

import com.weather.assemble.BtnAssembler;
import com.weather.assemble.ResourceAssembler;
import com.weather.domain.dao.ResourceRepository;
import com.weather.domain.entity.Btn;
import com.weather.domain.entity.Resource;
import com.weather.domain.service.ResourceService;
import com.weather.dto.AddResourceCommand;
import com.weather.dto.UpdateResourceCommand;
import com.weather.utility.ValidatorUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    private ResourceRepository resourceRepository;

    @Override
    public Page<Resource> pageQuery(String name, Integer pageNo, Integer pageSize) {
        return resourceRepository.findByName(name, PageRequest.of(pageNo, pageSize));
    }

    @Override
    public List<Resource> listQuery(String name) {
        return resourceRepository.findByName(name);
    }

    @Override
    public List<Resource> addResource(List<AddResourceCommand> addResourceCommands) {

        Assert.notEmpty(addResourceCommands, "保存的资源信息不能为空！");
        addResourceCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Resource> resources = addResourceCommands.stream().map(addResourceCommand -> {
            return ResourceAssembler.INSTANCE.buildResource(addResourceCommand).createBy(1L);
        }).collect(Collectors.toList());
        resourceRepository.saveAll(resources);
        return resources;
    }

    @Override
    public List<Resource> updateResource(List<UpdateResourceCommand> updateResourceCommands) {

        Assert.notEmpty(updateResourceCommands, "保存的资源信息不能为空！");
        updateResourceCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Long> updateIds = updateResourceCommands.stream().map(UpdateResourceCommand::getId).collect(Collectors.toList());
        Map<Long, UpdateResourceCommand> updateCache = updateResourceCommands.stream().collect(Collectors.toMap(v -> v.getId(), v->v));

        List<Resource> exists = resourceRepository.findAllById(updateIds);
        Assert.notEmpty(exists, "保存的资源信息不能为空！");
        resourceRepository.saveAll(exists.stream().filter(item -> Objects.nonNull(updateCache.get(item.getId())))
                .map(item -> {
                    return ResourceAssembler.INSTANCE.buildResource(updateCache.get(item.getId())).modifyBy(1L);
                }).collect(Collectors.toList()));
        return exists;
    }

    @Override
    public void deleteResource(List<Long> ids) {
        List<Resource> exists = resourceRepository.findAllById(ids);
        Assert.notEmpty(exists, "删除的资源不能为空！");
        resourceRepository.deleteAll(exists);
    }
}
