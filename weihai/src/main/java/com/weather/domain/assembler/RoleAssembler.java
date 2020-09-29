package com.weather.domain.assembler;

import com.weather.domain.entity.Role;
import com.weather.domainApi.command.AddRoleCommand;
import com.weather.domainApi.command.UpdateRoleCommand;
import com.weather.web.vo.RoleRes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleAssembler {

    RoleAssembler INSTANCE = Mappers.getMapper(RoleAssembler.class);

    RoleRes buildRoleRes(Role role);

    Role buildRole(AddRoleCommand addRoleCommand);

    Role buildRole(UpdateRoleCommand updateRoleCommand);
}
