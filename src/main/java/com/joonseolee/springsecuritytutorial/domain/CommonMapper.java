package com.joonseolee.springsecuritytutorial.domain;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN
)
public interface CommonMapper {
}
