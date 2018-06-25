package com.sirtts.repository;

import com.sirtts.domain.VsRespiratoryRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * Spring Data MongoDB repository for the VsRespiratoryRate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VsRespiratoryRateRepository extends MongoRepository<VsRespiratoryRate, String> {

    Page<VsRespiratoryRate> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate, LocalDateTime endDate,
                                                                         Pageable pageable);
}
