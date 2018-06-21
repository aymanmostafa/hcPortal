package com.sirtts.service.impl;

import com.sirtts.security.SecurityUtils;
import com.sirtts.service.DentistNextVisitService;
import com.sirtts.domain.DentistNextVisit;
import com.sirtts.repository.DentistNextVisitRepository;
import com.sirtts.service.dto.DentistNextVisitDTO;
import com.sirtts.service.mapper.DentistNextVisitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing DentistNextVisit.
 */
@Service
public class DentistNextVisitServiceImpl implements DentistNextVisitService {

    private final Logger log = LoggerFactory.getLogger(DentistNextVisitServiceImpl.class);

    private final DentistNextVisitRepository dentistNextVisitRepository;

    private final DentistNextVisitMapper dentistNextVisitMapper;

    public DentistNextVisitServiceImpl(DentistNextVisitRepository dentistNextVisitRepository, DentistNextVisitMapper dentistNextVisitMapper) {
        this.dentistNextVisitRepository = dentistNextVisitRepository;
        this.dentistNextVisitMapper = dentistNextVisitMapper;
    }

    /**
     * Save a dentistNextVisit.
     *
     * @param dentistNextVisitDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DentistNextVisitDTO save(DentistNextVisitDTO dentistNextVisitDTO) {
        log.debug("Request to save DentistNextVisit : {}", dentistNextVisitDTO);
        if(dentistNextVisitDTO.getUserid() == null){
            dentistNextVisitDTO.setUserid(SecurityUtils.getCurrentUserLogin().get().toString());
        }
        DentistNextVisit dentistNextVisit = dentistNextVisitMapper.toEntity(dentistNextVisitDTO);
        dentistNextVisit = dentistNextVisitRepository.save(dentistNextVisit);
        return dentistNextVisitMapper.toDto(dentistNextVisit);
    }

    /**
     * Get all the dentistNextVisits.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<DentistNextVisitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DentistNextVisits");
        return dentistNextVisitRepository.findAll(pageable)
            .map(dentistNextVisitMapper::toDto);
    }

    /**
     * Get all the dentistNextVisits by userid.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<DentistNextVisitDTO> findAllByUserid(String[] userids, Pageable pageable) {
        if(userids == null) {
            userids = new String[1];
            userids[0] = SecurityUtils.getCurrentUserLogin().get();;
        }
        log.debug("Request to get all DentistNextVisits");
        return dentistNextVisitRepository.findAllByUseridIn(userids, pageable)
            .map(dentistNextVisitMapper::toDto);
    }

    /**
     * Get one dentistNextVisit by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public DentistNextVisitDTO findOne(String id) {
        log.debug("Request to get DentistNextVisit : {}", id);
        DentistNextVisit dentistNextVisit = dentistNextVisitRepository.findOne(id);
        return dentistNextVisitMapper.toDto(dentistNextVisit);
    }

    /**
     * Delete the dentistNextVisit by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete DentistNextVisit : {}", id);
        dentistNextVisitRepository.delete(id);
    }
}
