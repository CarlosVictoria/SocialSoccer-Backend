/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.entities;

import java.io.Serializable;
import java.util.List;
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
 * @author Johan
 */
@Entity
@Table(name = "cities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c")
    , @NamedQuery(name = "Cities.findByIdCities", query = "SELECT c FROM Cities c WHERE c.idCities = :idCities")
    , @NamedQuery(name = "Cities.findByCityCode", query = "SELECT c FROM Cities c WHERE c.cityCode = :cityCode")
    , @NamedQuery(name = "Cities.findByName", query = "SELECT c FROM Cities c WHERE c.name = :name")})
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cities")
    private Integer idCities;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "city_code")
    private String cityCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "id_department", referencedColumnName = "id_departments")
    @ManyToOne(optional = false)
    private Departments idDepartment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCities")
    private List<Users> usersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCities")
    private List<Headquarters> headquartersList;

    public Cities() {
    }

    public Cities(Integer idCities) {
        this.idCities = idCities;
    }

    public Cities(Integer idCities, String cityCode, String name) {
        this.idCities = idCities;
        this.cityCode = cityCode;
        this.name = name;
    }

    public Integer getIdCities() {
        return idCities;
    }

    public void setIdCities(Integer idCities) {
        this.idCities = idCities;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departments getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Departments idDepartment) {
        this.idDepartment = idDepartment;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<Headquarters> getHeadquartersList() {
        return headquartersList;
    }

    public void setHeadquartersList(List<Headquarters> headquartersList) {
        this.headquartersList = headquartersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCities != null ? idCities.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.idCities == null && other.idCities != null) || (this.idCities != null && !this.idCities.equals(other.idCities))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Cities[ idCities=" + idCities + " ]";
    }
    
}
