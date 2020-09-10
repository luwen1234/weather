package com.weather.domain.service.Impl;

import com.weather.assemble.BtnAssembler;
import com.weather.domain.dao.BtnRepository;
import com.weather.domain.entity.Btn;
import com.weather.domain.service.BtnService;
import com.weather.dto.AddBtnCommand;
import com.weather.dto.UpdateBtnCommand;
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
public class BtnServiceImpl implements BtnService {

    @Resource
    private BtnRepository btnRepository;

    @Override
    public Page<Btn> pageQuery(String name, Integer pageNo, Integer pageSize) {
        return btnRepository.findByName(name, PageRequest.of(pageNo, pageSize));
    }

    @Override
    public List<Btn> listQuery(String name) {
        return btnRepository.findByName(name);
    }

    @Override
    public List<Btn> addBtn(List<AddBtnCommand> addBtnCommands) {

        Assert.notEmpty(addBtnCommands, "保存的按钮信息不能为空！");
        addBtnCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Btn> adds = addBtnCommands.stream().map(addBtnCommand -> {
            return BtnAssembler.INSTANCE.buildBtn(addBtnCommand).createBy(1L);
        }).collect(Collectors.toList());
        btnRepository.saveAll(adds);
        return adds;
    }

    @Override
    public List<Btn> updateBtn(List<UpdateBtnCommand> updateBtnCommands) {

        Assert.notEmpty(updateBtnCommands, "保存的按钮信息不能为空！");
        updateBtnCommands.forEach(item -> {
            ValidatorUtil.validator(item);
        });

        List<Long> updateIds = updateBtnCommands.stream().map(UpdateBtnCommand::getId).collect(Collectors.toList());
        Map<Long, UpdateBtnCommand> updateCache = updateBtnCommands.stream().collect(Collectors.toMap(v -> v.getId(), v->v));

        List<Btn> exists = btnRepository.findAllById(updateIds);
        Assert.notEmpty(exists, "保存的按钮信息不能为空！");
        btnRepository.saveAll(exists.stream().filter(item -> Objects.nonNull(updateCache.get(item.getId())))
                .map(item -> {
                    return BtnAssembler.INSTANCE.buildBtn(updateCache.get(item.getId())).modifyBy(1L);
                }).collect(Collectors.toList()));
        return exists;
    }

    @Override
    public void deleteBtn(List<Long> ids) {

        List<Btn> exists = btnRepository.findAllById(ids);
        Assert.notEmpty(exists, "删除的按钮不能为空！");
        btnRepository.deleteAll(exists);
    }
}
