package com.sirtts.service.impl;

import com.sirtts.security.SecurityUtils;
import com.sirtts.service.VsBloodPressureService;
import com.sirtts.domain.VsBloodPressure;
import com.sirtts.repository.VsBloodPressureRepository;
import com.sirtts.service.dto.VsBloodPressureDTO;
import com.sirtts.service.mapper.VsBloodPressureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing VsBloodPressure.
 */
@Service
public class VsBloodPressureServiceImpl implements VsBloodPressureService {

    private final Logger log = LoggerFactory.getLogger(VsBloodPressureServiceImpl.class);

    private final VsBloodPressureRepository vsBloodPressureRepository;

    private final VsBloodPressureMapper vsBloodPressureMapper;

    public VsBloodPressureServiceImpl(VsBloodPressureRepository vsBloodPressureRepository, VsBloodPressureMapper vsBloodPressureMapper) {
        this.vsBloodPressureRepository = vsBloodPressureRepository;
        this.vsBloodPressureMapper = vsBloodPressureMapper;
    }

    /**
     * Save a vsBloodPressure.
     *
     * @param vsBloodPressureDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public VsBloodPressureDTO save(VsBloodPressureDTO vsBloodPressureDTO) {
        log.debug("Request to save VsBloodPressure : {}", vsBloodPressureDTO);
        if(vsBloodPressureDTO.getUserid() == null){
            vsBloodPressureDTO.setUserid(SecurityUtils.getCurrentUserLogin().get().toString());
        }
        VsBloodPressure vsBloodPressure = vsBloodPressureMapper.toEntity(vsBloodPressureDTO);
        vsBloodPressure = vsBloodPressureRepository.save(vsBloodPressure);
        return vsBloodPressureMapper.toDto(vsBloodPressure);
    }

    /**
     * Get all the vsBloodPressures.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<VsBloodPressureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VsBloodPressures");
        return vsBloodPressureRepository.findAll(pageable)
            .map(vsBloodPressureMapper::toDto);
    }

    /**
     * Get one vsBloodPressure by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public VsBloodPressureDTO findOne(String id) {
        log.debug("Request to get VsBloodPressure : {}", id);
        VsBloodPressure vsBloodPressure = vsBloodPressureRepository.findOne(id);
        return vsBloodPressureMapper.toDto(vsBloodPressure);
    }

    /**
     * Delete the vsBloodPressure by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete VsBloodPressure : {}", id);
        vsBloodPressureRepository.delete(id);
    }
}
