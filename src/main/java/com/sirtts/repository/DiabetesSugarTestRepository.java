package com.sirtts.repository;

import com.sirtts.domain.DiabetesSugarTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

/**
 * Spring Data MongoDB repository for the DiabetesSugarTest entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DiabetesSugarTestRepository extends MongoRepository<DiabetesSugarTest, String> {

    Page<DiabetesSugarTest> findAllByUseridInAndAndMeasurmentdateBetweenOrderByMeasurmentdateDesc(String[] userids, LocalDateTime startDate, LocalDateTime endDate,
                                                                         Pageable pageable);
}
