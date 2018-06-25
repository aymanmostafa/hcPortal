package com.sirtts.service.impl;

import com.sirtts.security.SecurityUtils;
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

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;


/**
 * Service Implementation for managing DentistVisit.
 */
@Service
public class DentistVisitServiceImpl implements DentistVisitService {

    private final Logger log = LoggerFactory.getLogger(DentistVisitServiceImpl.class);

    private final DentistVisitRepository dentistVisitRepository;

    private final DentistVisitMapper dentistVisitMapper;

    private final DentistVisit dentistVisit;

    public DentistVisitServiceImpl(DentistVisitRepository dentistVisitRepository, DentistVisitMapper dentistVisitMapper) {
        this.dentistVisitRepository = dentistVisitRepository;
        this.dentistVisitMapper = dentistVisitMapper;
        dentistVisit = new DentistVisit();
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
        if(dentistVisitDTO.getUserid() == null){
            dentistVisitDTO.setUserid(SecurityUtils.getCurrentUserLogin().get().toString());
        }
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
     * Get all the dentistVisits by userid.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<DentistVisitDTO> findAllByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("Request to get all DentistVisits");
        if(userids == null) {
            userids = new String[1];
            userids[0] = SecurityUtils.getCurrentUserLogin().get();;
        }
        LocalDateTime start,end;
        if(startDate == null) start = LocalDateTime.ofEpochSecond(Integer.MIN_VALUE,0, ZoneOffset.UTC);
        else start = LocalDateTime.parse(startDate+"T00:00:00");
        if(endDate == null) end = LocalDateTime.ofEpochSecond(Integer.MAX_VALUE,0, ZoneOffset.UTC);
        else end  = LocalDateTime.parse(endDate+"T23:59:59");
        return dentistVisitRepository.findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(userids,start, end, pageable)
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

    /**
     * Get the dentistVisit columns.
     *
     * @return the entity
     */
    @Override
    public List findColumns() {
        Field[] fields =  dentistVisit.getClass().getDeclaredFields();
        List columns = new ArrayList<String>();
        for(int i = 0; i < fields.length; i++) {
            if(fields[i].getType() == java.lang.Boolean.class)
                columns.add(fields[i].getName());
        }
        return columns;
    }
}
