package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.VsBodyTemperatureDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VsBodyTemperature and its DTO VsBodyTemperatureDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VsBodyTemperatureMapper extends EntityMapper<VsBodyTemperatureDTO, VsBodyTemperature> {


}
