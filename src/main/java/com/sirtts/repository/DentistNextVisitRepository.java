package com.sirtts.repository;

import com.sirtts.domain.DentistNextVisit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * Spring Data MongoDB repository for the DentistNextVisit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DentistNextVisitRepository extends MongoRepository<DentistNextVisit, String> {

    Page<DentistNextVisit> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate, LocalDateTime endDate,
                                                                        Pageable pageable);

}
