package com.sirtts.repository;

import com.sirtts.domain.VsSpo2;
import com.sirtts.service.dto.VsSpo2DTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Spring Data MongoDB repository for the VsSpo2 entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VsSpo2Repository extends MongoRepository<VsSpo2, String> {

    Page<VsSpo2> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate, LocalDateTime endDate,
                                                              Pageable pageable);
}
