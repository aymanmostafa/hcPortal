package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.DentistNextVisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity DentistNextVisit and its DTO DentistNextVisitDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DentistNextVisitMapper extends EntityMapper<DentistNextVisitDTO, DentistNextVisit> {


}
