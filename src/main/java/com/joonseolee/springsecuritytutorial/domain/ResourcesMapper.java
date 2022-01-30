package com.joonseolee.springsecuritytutorial.domain;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = CommonMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ResourcesMapper {

    Resources toResources(ResourcesDto resourcesDto);
    ResourcesDto toResourcesDto(Resources resources);
}
