package com.sirtts.repository;

import com.sirtts.domain.VsSpo2;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the VsSpo2 entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VsSpo2Repository extends MongoRepository<VsSpo2, String> {

}
