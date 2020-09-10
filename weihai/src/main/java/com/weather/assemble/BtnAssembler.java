package com.weather.assemble;

import com.weather.domain.entity.Btn;
import com.weather.web.vo.BtnRes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BtnAssembler {

    BtnAssembler INSTANCE = Mappers.getMapper(BtnAssembler.class);

    BtnRes buildBtnRes(Btn btn);
}
