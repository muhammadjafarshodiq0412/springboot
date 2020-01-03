/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.repository;

import com.developer.SpringMySQL.models.Vacancy;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP
 */
public interface VacancyRepository extends CrudRepository<Vacancy, Integer>{

    public void delete(int id);

    public Object findOne(int id);
    
}
