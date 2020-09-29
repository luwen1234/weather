package com.weather.domain.service;

import com.weather.domain.entity.Privilege;
import com.weather.dto.AddPrivilegeCommand;
import com.weather.dto.UpdatePrivilegeCommand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PrivilegeService {

    Page<Privilege> pageQuery(String name, Integer pageNo, Integer pageSize);

    List<Privilege> listQuery(String name);

    List<Privilege> addPrivilege(List<AddPrivilegeCommand> addPrivilegeCommands);

    List<Privilege> updatePrivilege(List<UpdatePrivilegeCommand> updatePrivilegeCommands);

    void deletePrivilege(List<Long> ids);
}
