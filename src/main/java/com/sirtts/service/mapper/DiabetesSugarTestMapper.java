package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.DiabetesSugarTestDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity DiabetesSugarTest and its DTO DiabetesSugarTestDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DiabetesSugarTestMapper extends EntityMapper<DiabetesSugarTestDTO, DiabetesSugarTest> {


}
