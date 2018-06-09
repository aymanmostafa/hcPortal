package com.sirtts.repository;

import com.sirtts.domain.MenstrualCycle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the MenstrualCycle entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MenstrualCycleRepository extends MongoRepository<MenstrualCycle, String> {

    Page<MenstrualCycle> findAllByUseridIn(String[] userids, Pageable pageable);
}
