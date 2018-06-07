package com.sirtts.service.impl;

import com.sirtts.service.BloodTestService;
import com.sirtts.domain.BloodTest;
import com.sirtts.repository.BloodTestRepository;
import com.sirtts.service.dto.BloodTestDTO;
import com.sirtts.service.mapper.BloodTestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Service Implementation for managing BloodTest.
 */
@Service
public class BloodTestServiceImpl implements BloodTestService {

    private final Logger log = LoggerFactory.getLogger(BloodTestServiceImpl.class);

    private final BloodTestRepository bloodTestRepository;

    private final BloodTestMapper bloodTestMapper;

    public BloodTestServiceImpl(BloodTestRepository bloodTestRepository, BloodTestMapper bloodTestMapper) {
        this.bloodTestRepository = bloodTestRepository;
        this.bloodTestMapper = bloodTestMapper;
    }

    /**
     * Save a bloodTest.
     *
     * @param bloodTestDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BloodTestDTO save(BloodTestDTO bloodTestDTO) {
        log.debug("Request to save BloodTest : {}", bloodTestDTO);
        BloodTest bloodTest = bloodTestMapper.toEntity(bloodTestDTO);
        bloodTest = bloodTestRepository.save(bloodTest);
        return bloodTestMapper.toDto(bloodTest);
    }

    /**
     * Get all the bloodTests.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<BloodTestDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BloodTests");
        return bloodTestRepository.findAll(pageable)
            .map(bloodTestMapper::toDto);
    }

    /**
     * Get one bloodTest by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public BloodTestDTO findOne(String id) {
        log.debug("Request to get BloodTest : {}", id);
        BloodTest bloodTest = bloodTestRepository.findOne(id);
        return bloodTestMapper.toDto(bloodTest);
    }

    /**
     * Delete the bloodTest by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete BloodTest : {}", id);
        bloodTestRepository.delete(id);
    }
}
