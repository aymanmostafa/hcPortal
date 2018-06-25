package com.sirtts.repository;

import com.sirtts.domain.VsBodyTemperature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * Spring Data MongoDB repository for the VsBodyTemperature entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VsBodyTemperatureRepository extends MongoRepository<VsBodyTemperature, String> {

    Page<VsBodyTemperature> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate, LocalDateTime endDate,
                                                                         Pageable pageable);

}
