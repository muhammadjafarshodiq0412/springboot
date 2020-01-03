/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.repository;

import com.developer.SpringMySQL.models.Company;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP
 */
public interface CompanyRepository extends CrudRepository<Company, Integer>{
    
}
