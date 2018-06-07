package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.MenstrualCycleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MenstrualCycle and its DTO MenstrualCycleDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MenstrualCycleMapper extends EntityMapper<MenstrualCycleDTO, MenstrualCycle> {


}
