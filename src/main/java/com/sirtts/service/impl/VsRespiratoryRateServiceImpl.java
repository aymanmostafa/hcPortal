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
    public Page<VsRespiratoryRateDTO> findAllByUserid(String[] userids, Pageable pageable) {
        log.debug("Request to get all VsRespiratoryRates");
        return vsRespiratoryRateRepository.findAllByUseridIn(userids, pageable)
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
