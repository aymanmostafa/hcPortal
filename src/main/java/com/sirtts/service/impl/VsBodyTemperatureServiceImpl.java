package com.sirtts.service.impl;

import com.sirtts.security.SecurityUtils;
import com.sirtts.service.VsBodyTemperatureService;
import com.sirtts.domain.VsBodyTemperature;
import com.sirtts.repository.VsBodyTemperatureRepository;
import com.sirtts.service.dto.VsBodyTemperatureDTO;
import com.sirtts.service.mapper.VsBodyTemperatureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


/**
 * Service Implementation for managing VsBodyTemperature.
 */
@Service
public class VsBodyTemperatureServiceImpl implements VsBodyTemperatureService {

    private final Logger log = LoggerFactory.getLogger(VsBodyTemperatureServiceImpl.class);

    private final VsBodyTemperatureRepository vsBodyTemperatureRepository;

    private final VsBodyTemperatureMapper vsBodyTemperatureMapper;

    public VsBodyTemperatureServiceImpl(VsBodyTemperatureRepository vsBodyTemperatureRepository, VsBodyTemperatureMapper vsBodyTemperatureMapper) {
        this.vsBodyTemperatureRepository = vsBodyTemperatureRepository;
        this.vsBodyTemperatureMapper = vsBodyTemperatureMapper;
    }

    /**
     * Save a vsBodyTemperature.
     *
     * @param vsBodyTemperatureDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public VsBodyTemperatureDTO save(VsBodyTemperatureDTO vsBodyTemperatureDTO) {
        log.debug("Request to save VsBodyTemperature : {}", vsBodyTemperatureDTO);
        if(vsBodyTemperatureDTO.getUserid() == null){
            vsBodyTemperatureDTO.setUserid(SecurityUtils.getCurrentUserLogin().get().toString());
        }
        VsBodyTemperature vsBodyTemperature = vsBodyTemperatureMapper.toEntity(vsBodyTemperatureDTO);
        vsBodyTemperature = vsBodyTemperatureRepository.save(vsBodyTemperature);
        return vsBodyTemperatureMapper.toDto(vsBodyTemperature);
    }

    /**
     * Get all the vsBodyTemperatures.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<VsBodyTemperatureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VsBodyTemperatures");
        return vsBodyTemperatureRepository.findAll(pageable)
            .map(vsBodyTemperatureMapper::toDto);
    }

    /**
     * Get all the vsBodyTemperatures by userid.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<VsBodyTemperatureDTO> findAllByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("Request to get all VsBodyTemperatures");
        if(userids == null) {
            userids = new String[1];
            userids[0] = SecurityUtils.getCurrentUserLogin().get();;
        }
        LocalDateTime start,end;
        if(startDate == null) start = LocalDateTime.ofEpochSecond(Integer.MIN_VALUE,0, ZoneOffset.UTC);
        else start = LocalDateTime.parse(startDate+"T00:00:00");
        if(endDate == null) end = LocalDateTime.ofEpochSecond(Integer.MAX_VALUE,0, ZoneOffset.UTC);
        else end  = LocalDateTime.parse(endDate+"T23:59:59");
        return vsBodyTemperatureRepository.findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(userids, start, end, pageable)
            .map(vsBodyTemperatureMapper::toDto);
    }

    /**
     * Get one vsBodyTemperature by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public VsBodyTemperatureDTO findOne(String id) {
        log.debug("Request to get VsBodyTemperature : {}", id);
        VsBodyTemperature vsBodyTemperature = vsBodyTemperatureRepository.findOne(id);
        return vsBodyTemperatureMapper.toDto(vsBodyTemperature);
    }

    /**
     * Delete the vsBodyTemperature by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete VsBodyTemperature : {}", id);
        vsBodyTemperatureRepository.delete(id);
    }
}
