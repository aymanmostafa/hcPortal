package com.sirtts.repository;

import com.sirtts.domain.VsBloodPressure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * Spring Data MongoDB repository for the VsBloodPressure entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VsBloodPressureRepository extends MongoRepository<VsBloodPressure, String> {

    Page<VsBloodPressure> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate, LocalDateTime endDate,
                                                                       Pageable pageable);
}
