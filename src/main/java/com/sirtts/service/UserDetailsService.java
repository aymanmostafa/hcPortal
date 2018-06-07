package com.sirtts.service;

import com.sirtts.service.dto.UserDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing UserDetails.
 */
public interface UserDetailsService {

    /**
     * Save a userDetails.
     *
     * @param userDetailsDTO the entity to save
     * @return the persisted entity
     */
    UserDetailsDTO save(UserDetailsDTO userDetailsDTO);

    /**
     * Get all the userDetails.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<UserDetailsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" userDetails.
     *
     * @param id the id of the entity
     * @return the entity
     */
    UserDetailsDTO findOne(String id);

    /**
     * Delete the "id" userDetails.
     *
     * @param id the id of the entity
     */
    void delete(String id);
}
