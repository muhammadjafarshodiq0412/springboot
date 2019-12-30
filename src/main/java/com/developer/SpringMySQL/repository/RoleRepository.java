/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.repository;

import com.developer.SpringMySQL.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ASUS
 */
public interface RoleRepository extends CrudRepository<Role, Integer>{
    
}
