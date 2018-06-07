package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.VsHeartRateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VsHeartRate and its DTO VsHeartRateDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VsHeartRateMapper extends EntityMapper<VsHeartRateDTO, VsHeartRate> {


}
