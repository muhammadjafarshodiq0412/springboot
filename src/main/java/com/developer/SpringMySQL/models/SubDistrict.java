/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "sub_district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubDistrict.findAll", query = "SELECT s FROM SubDistrict s")
    , @NamedQuery(name = "SubDistrict.findById", query = "SELECT s FROM SubDistrict s WHERE s.id = :id")
    , @NamedQuery(name = "SubDistrict.findByName", query = "SELECT s FROM SubDistrict s WHERE s.name = :name")
    , @NamedQuery(name = "SubDistrict.findByPostalCode", query = "SELECT s FROM SubDistrict s WHERE s.postalCode = :postalCode")})
public class SubDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "postal_code")
    private String postalCode;
    @JoinColumn(name = "district", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private District district;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subDistrict")
    private Collection<Village> villageCollection;

    public SubDistrict() {
    }

    public SubDistrict(Integer id) {
        this.id = id;
    }

    public SubDistrict(Integer id, String name, String postalCode) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @XmlTransient
    public Collection<Village> getVillageCollection() {
        return villageCollection;
    }

    public void setVillageCollection(Collection<Village> villageCollection) {
        this.villageCollection = villageCollection;
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
        if (!(object instanceof SubDistrict)) {
            return false;
        }
        SubDistrict other = (SubDistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.SubDistrict[ id=" + id + " ]";
    }
    
}
