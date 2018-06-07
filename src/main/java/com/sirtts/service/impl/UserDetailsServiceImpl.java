package com.sirtts.service.impl;

import com.sirtts.service.UserDetailsService;
import com.sirtts.domain.UserDetails;
import com.sirtts.repository.UserDetailsRepository;
import com.sirtts.service.dto.UserDetailsDTO;
import com.sirtts.service.mapper.UserDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing UserDetails.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private final UserDetailsRepository userDetailsRepository;

    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository, UserDetailsMapper userDetailsMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.userDetailsMapper = userDetailsMapper;
    }

    /**
     * Save a userDetails.
     *
     * @param userDetailsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UserDetailsDTO save(UserDetailsDTO userDetailsDTO) {
        log.debug("Request to save UserDetails : {}", userDetailsDTO);
        UserDetails userDetails = userDetailsMapper.toEntity(userDetailsDTO);
        userDetails = userDetailsRepository.save(userDetails);
        return userDetailsMapper.toDto(userDetails);
    }

    /**
     * Get all the userDetails.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<UserDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserDetails");
        return userDetailsRepository.findAll(pageable)
            .map(userDetailsMapper::toDto);
    }

    /**
     * Get one userDetails by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public UserDetailsDTO findOne(String id) {
        log.debug("Request to get UserDetails : {}", id);
        UserDetails userDetails = userDetailsRepository.findOne(id);
        return userDetailsMapper.toDto(userDetails);
    }

    /**
     * Delete the userDetails by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete UserDetails : {}", id);
        userDetailsRepository.delete(id);
    }
}
