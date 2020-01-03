/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "candidate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c")
    , @NamedQuery(name = "Candidate.findById", query = "SELECT c FROM Candidate c WHERE c.id = :id")
    , @NamedQuery(name = "Candidate.findByFirstName", query = "SELECT c FROM Candidate c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Candidate.findByLastName", query = "SELECT c FROM Candidate c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "Candidate.findByDateOfBirth", query = "SELECT c FROM Candidate c WHERE c.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Candidate.findByPlaceOfBirth", query = "SELECT c FROM Candidate c WHERE c.placeOfBirth = :placeOfBirth")
    , @NamedQuery(name = "Candidate.findByNationality", query = "SELECT c FROM Candidate c WHERE c.nationality = :nationality")
    , @NamedQuery(name = "Candidate.findByMaritalStatus", query = "SELECT c FROM Candidate c WHERE c.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Candidate.findByGender", query = "SELECT c FROM Candidate c WHERE c.gender = :gender")
    , @NamedQuery(name = "Candidate.findByReligion", query = "SELECT c FROM Candidate c WHERE c.religion = :religion")
    , @NamedQuery(name = "Candidate.findByPhone", query = "SELECT c FROM Candidate c WHERE c.phone = :phone")
    , @NamedQuery(name = "Candidate.findByEmail", query = "SELECT c FROM Candidate c WHERE c.email = :email")
    , @NamedQuery(name = "Candidate.findByPhoneFamily", query = "SELECT c FROM Candidate c WHERE c.phoneFamily = :phoneFamily")
    , @NamedQuery(name = "Candidate.findByNameFamily", query = "SELECT c FROM Candidate c WHERE c.nameFamily = :nameFamily")
    , @NamedQuery(name = "Candidate.findByKtp", query = "SELECT c FROM Candidate c WHERE c.ktp = :ktp")
    , @NamedQuery(name = "Candidate.findByNpwp", query = "SELECT c FROM Candidate c WHERE c.npwp = :npwp")
    , @NamedQuery(name = "Candidate.findBySim", query = "SELECT c FROM Candidate c WHERE c.sim = :sim")
    , @NamedQuery(name = "Candidate.findByLastEducation", query = "SELECT c FROM Candidate c WHERE c.lastEducation = :lastEducation")
    , @NamedQuery(name = "Candidate.findByPhoto", query = "SELECT c FROM Candidate c WHERE c.photo = :photo")
    , @NamedQuery(name = "Candidate.findByExpectedSalary", query = "SELECT c FROM Candidate c WHERE c.expectedSalary = :expectedSalary")
    , @NamedQuery(name = "Candidate.findByCv", query = "SELECT c FROM Candidate c WHERE c.cv = :cv")})
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marital_status")
    private String maritalStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "religion")
    private String religion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone_family")
    private String phoneFamily;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name_family")
    private String nameFamily;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "current_address")
    private String currentAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ktp")
    private String ktp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "npwp")
    private String npwp;
    @Size(max = 10)
    @Column(name = "sim")
    private String sim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "last_education")
    private String lastEducation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expected_salary")
    private int expectedSalary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cv")
    private String cv;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;
    @Column(name = "village")
    private int village;

    public Candidate() {
    }

    public Candidate(Integer id) {
        this.id = id;
    }

    public Candidate(Integer id, String firstName, String lastName, Date dateOfBirth, String placeOfBirth, String nationality, String maritalStatus, String gender, String religion, String address, String phone, String email, String phoneFamily, String nameFamily, String currentAddress, String ktp, String npwp, String lastEducation, String photo, int expectedSalary, String cv) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.religion = religion;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.phoneFamily = phoneFamily;
        this.nameFamily = nameFamily;
        this.currentAddress = currentAddress;
        this.ktp = ktp;
        this.npwp = npwp;
        this.lastEducation = lastEducation;
        this.photo = photo;
        this.expectedSalary = expectedSalary;
        this.cv = cv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneFamily() {
        return phoneFamily;
    }

    public void setPhoneFamily(String phoneFamily) {
        this.phoneFamily = phoneFamily;
    }

    public String getNameFamily() {
        return nameFamily;
    }

    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getLastEducation() {
        return lastEducation;
    }

    public void setLastEducation(String lastEducation) {
        this.lastEducation = lastEducation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(int expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getVillage() {
        return village;
    }

    public void setVillage(int village) {
        this.village = village;
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
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.Candidate[ id=" + id + " ]";
    }

}
