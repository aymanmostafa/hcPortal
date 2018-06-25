package com.sirtts.repository;

import com.sirtts.domain.DentistVisit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * Spring Data MongoDB repository for the DentistVisit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DentistVisitRepository extends MongoRepository<DentistVisit, String> {

    Page<DentistVisit> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate, LocalDateTime endDate,
                                                                    Pageable pageable);

}
