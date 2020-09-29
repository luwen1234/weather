/*
package com.weather.domain.service.Impl;

import com.weather.domain.assembler.BtnAssembler;
import com.weather.domain.assembler.PrivilegeAssembler;
import com.weather.domain.dao.PrivilegeRepository;
import com.weather.domain.entity.Btn;
import com.weather.domain.entity.Privilege;
import com.weather.domain.service.PrivilegeService;
import com.weather.domainApi.command.AddPrivilegeCommand;
import com.weather.domainApi.command.UpdateBtnCommand;
import com.weather.domainApi.command.UpdatePrivilegeCommand;
import com.weather.utility.ValidatorUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Resource
    private PrivilegeRepository privilegeRepository;

    @Override
    public Page<Privilege> pageQuery(String name, Integer pageNo, Integer pageSize) {
        return privilegeRepository.pageQuery(name, PageRequest.of(pageNo, pageSize));
    }

    @Override
    public List<Privilege> listQuery(String name) {
        return privilegeRepository.listQuery(name);
    }

    @Override
    public List<Privilege> addPrivilege(List<AddPrivilegeCommand> addPrivilegeCommands) {

        Assert.notEmpty(addPrivilegeCommands, "保存的权限信息不能为空！");
        addPrivilegeCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Privilege> adds = addPrivilegeCommands.stream().map(addPrivilegeCommand -> {
            return PrivilegeAssembler.INSTANCE.buildPrivilege(addPrivilegeCommand).createBy(1L);
        }).collect(Collectors.toList());
        privilegeRepository.saveAll(adds);
        return adds;
    }

    @Override
    public List<Privilege> updatePrivilege(List<UpdatePrivilegeCommand> updatePrivilegeCommands) {

        Assert.notEmpty(updatePrivilegeCommands, "保存的权限信息不能为空！");
        updatePrivilegeCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Long> updateIds = updatePrivilegeCommands.stream().map(UpdatePrivilegeCommand::getId).collect(Collectors.toList());
        Map<Long, UpdateBtnCommand> updateCache = updatePrivilegeCommands.stream().collect(Collectors.toMap(v -> v.getId(), v->v));

        List<Privilege> exists = privilegeRepository.findAllById(updateIds);
        Assert.notEmpty(exists, "保存的按钮信息不能为空！");
        privilegeRepository.saveAll(exists.stream().filter(item -> Objects.nonNull(updateCache.get(item.getId())))
                .map(item -> {
                    Privilege privilege = PrivilegeAssembler.INSTANCE.buildPrivilege(updateCache.get(item.getId())).modifyBy(1L);
                    privilege.setCreateOn(item.getCreateOn());
                    privilege.setCreateBy(item.getCreateBy());
                    return privilege;
                }).collect(Collectors.toList()));
        return exists;
    }

    @Override
    public void deleteBtn(List<Long> ids) {

        List<Privilege> exists = privilegeRepository.findAllById(ids);
        Assert.notEmpty(exists, "删除的按钮不能为空！");
        privilegeRepository.deleteAll(exists);
    }
}
*/
