/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.repository;

import com.developer.SpringMySQL.models.RowAccess;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ASUS
 */
public interface RowAccessRepository extends CrudRepository<RowAccess, Integer> {

    @Query(value = "select * from row_access where user = :user AND role = :role", nativeQuery = true)
    public RowAccess getUserRole(@Param("user") String user, @Param("role") int role);
    
//    @Query(value = "select id from RowAccess where user = :user", nativeQuery = true)
//    public RowAccess getUserRoleAccess(@Param("user") String user);
    
//    @Query(value = "select * from row_access where user = :user", nativeQuery = true)
//    public RowAccess getUserTblRowAccess(@Param("user") String user);
}
