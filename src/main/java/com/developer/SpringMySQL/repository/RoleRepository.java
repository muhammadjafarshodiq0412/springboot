/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.repository;

import com.developer.SpringMySQL.models.Role;
import com.developer.SpringMySQL.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ASUS
 */
public interface RoleRepository extends CrudRepository<Role, Integer>{
    
//    @Query(value = "select * from Role where name = :name", nativeQuery = true)
//    public User getByName(@Param("name") String username);
    
    /**
     * ambil semua role kecuali role candidate
     * @param id
     * @return 
     */
    @Query(value = "select * from Role where id != :id", nativeQuery = true)
    public List<Role> getAllRoleBackend(@Param("id") String id);
}
