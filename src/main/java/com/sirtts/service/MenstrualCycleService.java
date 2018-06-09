package com.sirtts.service;

import com.sirtts.service.dto.MenstrualCycleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing MenstrualCycle.
 */
public interface MenstrualCycleService {

    /**
     * Save a menstrualCycle.
     *
     * @param menstrualCycleDTO the entity to save
     * @return the persisted entity
     */
    MenstrualCycleDTO save(MenstrualCycleDTO menstrualCycleDTO);

    /**
     * Get all the menstrualCycles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MenstrualCycleDTO> findAll(Pageable pageable);

    /**
     * Get all the menstrualCycles by userid.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MenstrualCycleDTO> findAllByUserid(String[] userids, Pageable pageable);

    /**
     * Get the "id" menstrualCycle.
     *
     * @param id the id of the entity
     * @return the entity
     */
    MenstrualCycleDTO findOne(String id);

    /**
     * Delete the "id" menstrualCycle.
     *
     * @param id the id of the entity
     */
    void delete(String id);
}
