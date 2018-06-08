package com.sirtts.service.impl;

import com.sirtts.security.SecurityUtils;
import com.sirtts.service.DiabetesSugarTestService;
import com.sirtts.domain.DiabetesSugarTest;
import com.sirtts.repository.DiabetesSugarTestRepository;
import com.sirtts.service.dto.DiabetesSugarTestDTO;
import com.sirtts.service.mapper.DiabetesSugarTestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Service Implementation for managing DiabetesSugarTest.
 */
@Service
public class DiabetesSugarTestServiceImpl implements DiabetesSugarTestService {

    private final Logger log = LoggerFactory.getLogger(DiabetesSugarTestServiceImpl.class);

    private final DiabetesSugarTestRepository diabetesSugarTestRepository;

    private final DiabetesSugarTestMapper diabetesSugarTestMapper;

    public DiabetesSugarTestServiceImpl(DiabetesSugarTestRepository diabetesSugarTestRepository, DiabetesSugarTestMapper diabetesSugarTestMapper) {
        this.diabetesSugarTestRepository = diabetesSugarTestRepository;
        this.diabetesSugarTestMapper = diabetesSugarTestMapper;
    }

    /**
     * Save a diabetesSugarTest.
     *
     * @param diabetesSugarTestDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DiabetesSugarTestDTO save(DiabetesSugarTestDTO diabetesSugarTestDTO) {
        log.debug("Request to save DiabetesSugarTest : {}", diabetesSugarTestDTO);
        if(diabetesSugarTestDTO.getUserid() == null){
            diabetesSugarTestDTO.setUserid(SecurityUtils.getCurrentUserLogin().get().toString());
        }
        DiabetesSugarTest diabetesSugarTest = diabetesSugarTestMapper.toEntity(diabetesSugarTestDTO);
        diabetesSugarTest = diabetesSugarTestRepository.save(diabetesSugarTest);
        return diabetesSugarTestMapper.toDto(diabetesSugarTest);
    }

    /**
     * Get all the diabetesSugarTests.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<DiabetesSugarTestDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DiabetesSugarTests");
        return diabetesSugarTestRepository.findAll(pageable)
            .map(diabetesSugarTestMapper::toDto);
    }

    /**
     * Get one diabetesSugarTest by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public DiabetesSugarTestDTO findOne(String id) {
        log.debug("Request to get DiabetesSugarTest : {}", id);
        DiabetesSugarTest diabetesSugarTest = diabetesSugarTestRepository.findOne(id);
        return diabetesSugarTestMapper.toDto(diabetesSugarTest);
    }

    /**
     * Delete the diabetesSugarTest by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete DiabetesSugarTest : {}", id);
        diabetesSugarTestRepository.delete(id);
    }
}
