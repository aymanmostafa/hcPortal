package com.sirtts.service.impl;

import com.sirtts.service.MenstrualCycleService;
import com.sirtts.domain.MenstrualCycle;
import com.sirtts.repository.MenstrualCycleRepository;
import com.sirtts.service.dto.MenstrualCycleDTO;
import com.sirtts.service.mapper.MenstrualCycleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing MenstrualCycle.
 */
@Service
public class MenstrualCycleServiceImpl implements MenstrualCycleService {

    private final Logger log = LoggerFactory.getLogger(MenstrualCycleServiceImpl.class);

    private final MenstrualCycleRepository menstrualCycleRepository;

    private final MenstrualCycleMapper menstrualCycleMapper;

    public MenstrualCycleServiceImpl(MenstrualCycleRepository menstrualCycleRepository, MenstrualCycleMapper menstrualCycleMapper) {
        this.menstrualCycleRepository = menstrualCycleRepository;
        this.menstrualCycleMapper = menstrualCycleMapper;
    }

    /**
     * Save a menstrualCycle.
     *
     * @param menstrualCycleDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MenstrualCycleDTO save(MenstrualCycleDTO menstrualCycleDTO) {
        log.debug("Request to save MenstrualCycle : {}", menstrualCycleDTO);
        MenstrualCycle menstrualCycle = menstrualCycleMapper.toEntity(menstrualCycleDTO);
        menstrualCycle = menstrualCycleRepository.save(menstrualCycle);
        return menstrualCycleMapper.toDto(menstrualCycle);
    }

    /**
     * Get all the menstrualCycles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<MenstrualCycleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MenstrualCycles");
        return menstrualCycleRepository.findAll(pageable)
            .map(menstrualCycleMapper::toDto);
    }

    /**
     * Get one menstrualCycle by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public MenstrualCycleDTO findOne(String id) {
        log.debug("Request to get MenstrualCycle : {}", id);
        MenstrualCycle menstrualCycle = menstrualCycleRepository.findOne(id);
        return menstrualCycleMapper.toDto(menstrualCycle);
    }

    /**
     * Delete the menstrualCycle by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete MenstrualCycle : {}", id);
        menstrualCycleRepository.delete(id);
    }
}
