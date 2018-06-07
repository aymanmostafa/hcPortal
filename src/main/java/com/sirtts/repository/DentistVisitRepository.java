package com.sirtts.repository;

import com.sirtts.domain.DentistVisit;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the DentistVisit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DentistVisitRepository extends MongoRepository<DentistVisit, String> {

}
