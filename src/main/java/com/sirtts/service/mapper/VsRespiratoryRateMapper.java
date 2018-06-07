package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.VsRespiratoryRateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VsRespiratoryRate and its DTO VsRespiratoryRateDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VsRespiratoryRateMapper extends EntityMapper<VsRespiratoryRateDTO, VsRespiratoryRate> {


}
