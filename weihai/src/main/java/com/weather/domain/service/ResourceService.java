package com.weather.domain.service;

import com.weather.domain.entity.Resource;
import com.weather.dto.AddResourceCommand;
import com.weather.dto.UpdateResourceCommand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ResourceService {

    Page<Resource> pageQuery(String name, Integer pageNo, Integer pageSize);

    List<Resource> listQuery(String name);

    List<Resource> addResource(List<AddResourceCommand> addResourceCommands);

    List<Resource> updateResource(List<UpdateResourceCommand> updateResourceCommands);

    void deleteResource(List<Long> ids);
}
