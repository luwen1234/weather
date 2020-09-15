package com.weather.domain.assembler;

import com.weather.domain.entity.Btn;
import com.weather.domainApi.command.AddBtnCommand;
import com.weather.domainApi.command.UpdateBtnCommand;
import com.weather.dto.BtnDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface BtnAssembler {

    BtnAssembler INSTANCE = Mappers.getMapper(BtnAssembler.class);

    BtnDto buildBtnRes(Btn btn);

    Btn buildBtn(AddBtnCommand addBtnCommand);

    Btn buildBtn(UpdateBtnCommand updateBtnCommand);
}
