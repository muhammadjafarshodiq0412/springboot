/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.repository;

import com.developer.SpringMySQL.models.ProcessStatus;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP
 */
public interface ProccessStatusRepository extends CrudRepository<ProcessStatus, Integer> {
     
    @Query(value = "Select p.id, p.status,c.first_name, c.last_name, j.job_title, co.name "
             + "FROM "
             + "process_status p "
             + "LEFT JOIN "
             + "candidate c "
             + "ON "
             + "p.candidate = c.id "
             + "LEFT JOIN "
             + "vacancy v"
             + "ON"
             + "p.vacancy = v.id "
             + "LEFT JOIN "
             + "company co "
             + "ON "
             + "v.company = co.id"
             + "LEFT JOIN "
             + "jobs j "
             + "ON "
             + "v.jobs = j.id",nativeQuery = true)
    public List<ProcessStatus> getProcessStatus();
    
}
