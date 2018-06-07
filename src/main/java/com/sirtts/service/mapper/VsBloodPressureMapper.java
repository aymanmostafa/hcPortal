package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.VsBloodPressureDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VsBloodPressure and its DTO VsBloodPressureDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VsBloodPressureMapper extends EntityMapper<VsBloodPressureDTO, VsBloodPressure> {


}
