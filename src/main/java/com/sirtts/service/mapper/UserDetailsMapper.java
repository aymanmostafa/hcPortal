package com.sirtts.service.mapper;

import com.sirtts.domain.*;
import com.sirtts.service.dto.UserDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity UserDetails and its DTO UserDetailsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserDetailsMapper extends EntityMapper<UserDetailsDTO, UserDetails> {


}
