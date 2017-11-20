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
 * @author Carlos Jose Victoria
 */
@Entity
@Table(name = "departments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d")
    , @NamedQuery(name = "Departments.findByIdDepartments", query = "SELECT d FROM Departments d WHERE d.idDepartments = :idDepartments")
    , @NamedQuery(name = "Departments.findByDepartmentCode", query = "SELECT d FROM Departments d WHERE d.departmentCode = :departmentCode")
    , @NamedQuery(name = "Departments.findByName", query = "SELECT d FROM Departments d WHERE d.name = :name")})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_departments")
    private Integer idDepartments;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "department_code")
    private String departmentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartment")
    private List<Cities> citiesList;

    public Departments() {
    }

    public Departments(Integer idDepartments) {
        this.idDepartments = idDepartments;
    }

    public Departments(Integer idDepartments, String departmentCode, String name) {
        this.idDepartments = idDepartments;
        this.departmentCode = departmentCode;
        this.name = name;
    }

    public Integer getIdDepartments() {
        return idDepartments;
    }

    public void setIdDepartments(Integer idDepartments) {
        this.idDepartments = idDepartments;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Cities> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(List<Cities> citiesList) {
        this.citiesList = citiesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartments != null ? idDepartments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.idDepartments == null && other.idDepartments != null) || (this.idDepartments != null && !this.idDepartments.equals(other.idDepartments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Departments[ idDepartments=" + idDepartments + " ]";
    }
    
}
