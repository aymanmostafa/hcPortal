package com.sirtts.service.impl;

import com.sirtts.service.DentistVisitService;
import com.sirtts.domain.DentistVisit;
import com.sirtts.repository.DentistVisitRepository;
import com.sirtts.service.dto.DentistVisitDTO;
import com.sirtts.service.mapper.DentistVisitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing DentistVisit.
 */
@Service
public class DentistVisitServiceImpl implements DentistVisitService {

    private final Logger log = LoggerFactory.getLogger(DentistVisitServiceImpl.class);

    private final DentistVisitRepository dentistVisitRepository;

    private final DentistVisitMapper dentistVisitMapper;

    public DentistVisitServiceImpl(DentistVisitRepository dentistVisitRepository, DentistVisitMapper dentistVisitMapper) {
        this.dentistVisitRepository = dentistVisitRepository;
        this.dentistVisitMapper = dentistVisitMapper;
    }

    /**
     * Save a dentistVisit.
     *
     * @param dentistVisitDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DentistVisitDTO save(DentistVisitDTO dentistVisitDTO) {
        log.debug("Request to save DentistVisit : {}", dentistVisitDTO);
        DentistVisit dentistVisit = dentistVisitMapper.toEntity(dentistVisitDTO);
        dentistVisit = dentistVisitRepository.save(dentistVisit);
        return dentistVisitMapper.toDto(dentistVisit);
    }

    /**
     * Get all the dentistVisits.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<DentistVisitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DentistVisits");
        return dentistVisitRepository.findAll(pageable)
            .map(dentistVisitMapper::toDto);
    }

    /**
     * Get one dentistVisit by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public DentistVisitDTO findOne(String id) {
        log.debug("Request to get DentistVisit : {}", id);
        DentistVisit dentistVisit = dentistVisitRepository.findOne(id);
        return dentistVisitMapper.toDto(dentistVisit);
    }

    /**
     * Delete the dentistVisit by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete DentistVisit : {}", id);
        dentistVisitRepository.delete(id);
    }
}
