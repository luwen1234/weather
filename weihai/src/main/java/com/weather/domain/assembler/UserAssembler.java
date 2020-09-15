package com.weather.domain.assembler;

import com.weather.domain.entity.User;
import com.weather.domainApi.command.AddUserCommand;
import com.weather.domainApi.command.UpdateUserCommand;
import com.weather.web.vo.UserRes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAssembler {

    UserAssembler INSTANCE = Mappers.getMapper(UserAssembler.class);

    UserRes buildUserRes(User btn);

    User buildUser(AddUserCommand addUserCommand);

    User buildUser(UpdateUserCommand updateUserCommand);
}
