package com.sirtts.repository;

import com.sirtts.domain.BloodTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the BloodTest entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BloodTestRepository extends MongoRepository<BloodTest, String> {

    Page<BloodTest> findAllByUseridIn(String[] userids, Pageable pageable);

}
