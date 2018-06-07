package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.DentistVisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity DentistVisit and its DTO DentistVisitDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DentistVisitMapper extends EntityMapper<DentistVisitDTO, DentistVisit> {


}
