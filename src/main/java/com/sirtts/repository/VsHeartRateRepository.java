package com.sirtts.repository;

import com.sirtts.domain.VsHeartRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * Spring Data MongoDB repository for the VsHeartRate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VsHeartRateRepository extends MongoRepository<VsHeartRate, String> {

    Page<VsHeartRate> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate,
                                                                                         LocalDateTime
        endDate,
                                                                   Pageable pageable);

}
