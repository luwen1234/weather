package com.weather.domain.assembler;

import com.weather.domain.entity.Resource;
import com.weather.domainApi.command.AddResourceCommand;
import com.weather.domainApi.command.UpdateResourceCommand;
import com.weather.web.vo.ResourceRes;
import org.mapstruct.factory.Mappers;

public interface ResourceAssembler {

    ResourceAssembler INSTANCE = Mappers.getMapper(ResourceAssembler.class);

    ResourceRes buildResourceRes(Resource resource);

    Resource buildResource(AddResourceCommand addResourceCommand);

    Resource buildResource(UpdateResourceCommand updateResourceCommand);
}
