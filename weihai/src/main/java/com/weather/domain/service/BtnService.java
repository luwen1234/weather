package com.weather.domain.service;

import com.weather.domain.entity.Btn;
import com.weather.dto.AddBtnCommand;
import com.weather.dto.UpdateBtnCommand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BtnService {

    Page<Btn> pageQuery(String name, Integer pageNo, Integer pageSize);

    List<Btn> listQuery(String name);

    List<Btn> addBtn(List<AddBtnCommand> addBtnCommands);

    List<Btn> updateBtn(List<UpdateBtnCommand> updateBtnCommands);

    void deleteBtn(List<Long> ids);
}
