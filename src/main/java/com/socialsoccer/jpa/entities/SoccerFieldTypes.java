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
 * @author adsi1261718
 */
@Entity
@Table(name = "soccer_field_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoccerFieldTypes.findAll", query = "SELECT s FROM SoccerFieldTypes s")
    , @NamedQuery(name = "SoccerFieldTypes.findByIdSoccerFieldTypes", query = "SELECT s FROM SoccerFieldTypes s WHERE s.idSoccerFieldTypes = :idSoccerFieldTypes")
    , @NamedQuery(name = "SoccerFieldTypes.findByDescription", query = "SELECT s FROM SoccerFieldTypes s WHERE s.description = :description")})
public class SoccerFieldTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_soccer_field_types")
    private Integer idSoccerFieldTypes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoccerFieldsTypes")
    private List<SoccerFields> soccerFieldsList;

    public SoccerFieldTypes() {
    }

    public SoccerFieldTypes(Integer idSoccerFieldTypes) {
        this.idSoccerFieldTypes = idSoccerFieldTypes;
    }

    public SoccerFieldTypes(Integer idSoccerFieldTypes, String description) {
        this.idSoccerFieldTypes = idSoccerFieldTypes;
        this.description = description;
    }

    public Integer getIdSoccerFieldTypes() {
        return idSoccerFieldTypes;
    }

    public void setIdSoccerFieldTypes(Integer idSoccerFieldTypes) {
        this.idSoccerFieldTypes = idSoccerFieldTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<SoccerFields> getSoccerFieldsList() {
        return soccerFieldsList;
    }

    public void setSoccerFieldsList(List<SoccerFields> soccerFieldsList) {
        this.soccerFieldsList = soccerFieldsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoccerFieldTypes != null ? idSoccerFieldTypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoccerFieldTypes)) {
            return false;
        }
        SoccerFieldTypes other = (SoccerFieldTypes) object;
        if ((this.idSoccerFieldTypes == null && other.idSoccerFieldTypes != null) || (this.idSoccerFieldTypes != null && !this.idSoccerFieldTypes.equals(other.idSoccerFieldTypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.SoccerFieldTypes[ idSoccerFieldTypes=" + idSoccerFieldTypes + " ]";
    }
    
}
