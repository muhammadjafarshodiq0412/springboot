/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.repository;

import com.developer.SpringMySQL.models.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ASUS
 */
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
    
    @Query(value = "select * from candidate where user = :user", nativeQuery = true)
    public Candidate getByUser(@Param("user") String user);
}
