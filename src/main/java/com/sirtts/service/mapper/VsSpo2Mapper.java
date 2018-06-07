package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.VsSpo2DTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VsSpo2 and its DTO VsSpo2DTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VsSpo2Mapper extends EntityMapper<VsSpo2DTO, VsSpo2> {


}
