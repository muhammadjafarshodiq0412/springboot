/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "process_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessStatus.findAll", query = "SELECT p FROM ProcessStatus p")
    , @NamedQuery(name = "ProcessStatus.findById", query = "SELECT p FROM ProcessStatus p WHERE p.id = :id")
    , @NamedQuery(name = "ProcessStatus.findByStatus", query = "SELECT p FROM ProcessStatus p WHERE p.status = :status")})
public class ProcessStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "status")
    private int status;

//    @JoinColumn(name = "candidate", referencedColumnName = "id")
//    @ManyToOne(optional = false)
    @Column(name = "candidate")
    private int candidate;
    @Column(name = "vacancy")
    private int vacancy;

    public ProcessStatus() {
    }

    public ProcessStatus(Integer id) {
        this.id = id;
    }

    public ProcessStatus(int status, int candidate, int vacancy) {
        this.status = status;
        this.candidate = candidate;
        this.vacancy = vacancy;
    }

    public ProcessStatus(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCandidate() {
        return candidate;
    }

    public void setCandidate(int candidate) {
        this.candidate = candidate;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessStatus)) {
            return false;
        }
        ProcessStatus other = (ProcessStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.ProcessStatus[ id=" + id + " ]";
    }

}
