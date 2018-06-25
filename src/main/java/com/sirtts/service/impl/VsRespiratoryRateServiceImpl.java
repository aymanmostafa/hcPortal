package com.sirtts.service.impl;

import com.sirtts.security.SecurityUtils;
import com.sirtts.service.VsRespiratoryRateService;
import com.sirtts.domain.VsRespiratoryRate;
import com.sirtts.repository.VsRespiratoryRateRepository;
import com.sirtts.service.dto.VsRespiratoryRateDTO;
import com.sirtts.service.mapper.VsRespiratoryRateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


/**
 * Service Implementation for managing VsRespiratoryRate.
 */
@Service
public class VsRespiratoryRateServiceImpl implements VsRespiratoryRateService {

    private final Logger log = LoggerFactory.getLogger(VsRespiratoryRateServiceImpl.class);

    private final VsRespiratoryRateRepository vsRespiratoryRateRepository;

    private final VsRespiratoryRateMapper vsRespiratoryRateMapper;

    public VsRespiratoryRateServiceImpl(VsRespiratoryRateRepository vsRespiratoryRateRepository, VsRespiratoryRateMapper vsRespiratoryRateMapper) {
        this.vsRespiratoryRateRepository = vsRespiratoryRateRepository;
        this.vsRespiratoryRateMapper = vsRespiratoryRateMapper;
    }

    /**
     * Save a vsRespiratoryRate.
     *
     * @param vsRespiratoryRateDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public VsRespiratoryRateDTO save(VsRespiratoryRateDTO vsRespiratoryRateDTO) {
        log.debug("Request to save VsRespiratoryRate : {}", vsRespiratoryRateDTO);
        if(vsRespiratoryRateDTO.getUserid() == null){
            vsRespiratoryRateDTO.setUserid(SecurityUtils.getCurrentUserLogin().get().toString());
        }
        VsRespiratoryRate vsRespiratoryRate = vsRespiratoryRateMapper.toEntity(vsRespiratoryRateDTO);
        vsRespiratoryRate = vsRespiratoryRateRepository.save(vsRespiratoryRate);
        return vsRespiratoryRateMapper.toDto(vsRespiratoryRate);
    }

    /**
     * Get all the vsRespiratoryRates.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<VsRespiratoryRateDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VsRespiratoryRates");
        return vsRespiratoryRateRepository.findAll(pageable)
            .map(vsRespiratoryRateMapper::toDto);
    }

    /**
     * Get all the vsRespiratoryRates by userid.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<VsRespiratoryRateDTO> findAllByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("Request to get all VsRespiratoryRates");
        if(userids == null) {
            userids = new String[1];
            userids[0] = SecurityUtils.getCurrentUserLogin().get();;
        }
        LocalDateTime start,end;
        if(startDate == null) start = LocalDateTime.ofEpochSecond(Integer.MIN_VALUE,0, ZoneOffset.UTC);
        else start = LocalDateTime.parse(startDate+"T00:00:00");
        if(endDate == null) end = LocalDateTime.ofEpochSecond(Integer.MAX_VALUE,0, ZoneOffset.UTC);
        else end  = LocalDateTime.parse(endDate+"T23:59:59");
        return vsRespiratoryRateRepository.findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(userids,start, end, pageable)
            .map(vsRespiratoryRateMapper::toDto);
    }

    /**
     * Get one vsRespiratoryRate by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public VsRespiratoryRateDTO findOne(String id) {
        log.debug("Request to get VsRespiratoryRate : {}", id);
        VsRespiratoryRate vsRespiratoryRate = vsRespiratoryRateRepository.findOne(id);
        return vsRespiratoryRateMapper.toDto(vsRespiratoryRate);
    }

    /**
     * Delete the vsRespiratoryRate by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete VsRespiratoryRate : {}", id);
        vsRespiratoryRateRepository.delete(id);
    }
}
