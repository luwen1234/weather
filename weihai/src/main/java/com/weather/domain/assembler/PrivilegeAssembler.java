package com.weather.domain.assembler;

import com.weather.domain.entity.Privilege;
import com.weather.domainApi.command.AddPrivilegeCommand;
import com.weather.domainApi.command.UpdatePrivilegeCommand;
import com.weather.web.vo.PrivilegeRes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrivilegeAssembler {

    PrivilegeAssembler INSTANCE = Mappers.getMapper(PrivilegeAssembler.class);

    PrivilegeRes buildPrivilegeRes(Privilege btn);

    Privilege buildPrivilege(AddPrivilegeCommand addPrivilegeCommand);

    Privilege buildPrivilege(UpdatePrivilegeCommand updatePrivilegeCommand);
}
