package com.sirtts.repository;

import com.sirtts.domain.UserDetails;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the UserDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

}
