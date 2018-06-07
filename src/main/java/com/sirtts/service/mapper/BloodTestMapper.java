package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.BloodTestDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BloodTest and its DTO BloodTestDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BloodTestMapper extends EntityMapper<BloodTestDTO, BloodTest> {


}
