package com.sirtts.service.impl;

import com.sirtts.security.SecurityUtils;
import com.sirtts.service.VsHeartRateService;
import com.sirtts.domain.VsHeartRate;
import com.sirtts.repository.VsHeartRateRepository;
import com.sirtts.service.dto.VsHeartRateDTO;
import com.sirtts.service.mapper.VsHeartRateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing VsHeartRate.
 */
@Service
public class VsHeartRateServiceImpl implements VsHeartRateService {

    private final Logger log = LoggerFactory.getLogger(VsHeartRateServiceImpl.class);

    private final VsHeartRateRepository vsHeartRateRepository;

    private final VsHeartRateMapper vsHeartRateMapper;

    public VsHeartRateServiceImpl(VsHeartRateRepository vsHeartRateRepository, VsHeartRateMapper vsHeartRateMapper) {
        this.vsHeartRateRepository = vsHeartRateRepository;
        this.vsHeartRateMapper = vsHeartRateMapper;
    }

    /**
     * Save a vsHeartRate.
     *
     * @param vsHeartRateDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public VsHeartRateDTO save(VsHeartRateDTO vsHeartRateDTO) {
        log.debug("Request to save VsHeartRate : {}", vsHeartRateDTO);
        if(vsHeartRateDTO.getUserid() == null){
            vsHeartRateDTO.setUserid(SecurityUtils.getCurrentUserLogin().get().toString());
        }
        VsHeartRate vsHeartRate = vsHeartRateMapper.toEntity(vsHeartRateDTO);
        vsHeartRate = vsHeartRateRepository.save(vsHeartRate);
        return vsHeartRateMapper.toDto(vsHeartRate);
    }

    /**
     * Get all the vsHeartRates.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<VsHeartRateDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VsHeartRates");
        return vsHeartRateRepository.findAll(pageable)
            .map(vsHeartRateMapper::toDto);
    }

    /**
     * Get all the vsHeartRates by userid.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<VsHeartRateDTO> findAllByUserid(String[] userids, Pageable pageable) {
        log.debug("Request to get all VsHeartRates");
        if(userids == null) {
            userids = new String[1];
            userids[0] = SecurityUtils.getCurrentUserLogin().get();;
        }
        return vsHeartRateRepository.findAllByUseridIn(userids, pageable)
            .map(vsHeartRateMapper::toDto);
    }


    /**
     * Get one vsHeartRate by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public VsHeartRateDTO findOne(String id) {
        log.debug("Request to get VsHeartRate : {}", id);
        VsHeartRate vsHeartRate = vsHeartRateRepository.findOne(id);
        return vsHeartRateMapper.toDto(vsHeartRate);
    }

    /**
     * Delete the vsHeartRate by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete VsHeartRate : {}", id);
        vsHeartRateRepository.delete(id);
    }
}
