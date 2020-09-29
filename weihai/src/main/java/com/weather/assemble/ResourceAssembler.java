package com.weather.assemble;

import com.weather.domain.entity.Resource;
import com.weather.dto.AddResourceCommand;
import com.weather.dto.UpdateResourceCommand;
import com.weather.web.vo.ResourceRes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceAssembler {

    ResourceAssembler INSTANCE = Mappers.getMapper(ResourceAssembler.class);

    ResourceRes buildResourceRes(Resource resource);

    Resource buildResource(AddResourceCommand addResourceCommand);

    Resource buildResource(UpdateResourceCommand updateResourceCommand);
}
