package com.sirtts.repository;

import com.sirtts.domain.DiabetesSugarTest;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the DiabetesSugarTest entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DiabetesSugarTestRepository extends MongoRepository<DiabetesSugarTest, String> {

}
