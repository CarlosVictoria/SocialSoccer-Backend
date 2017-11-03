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
@Table(name = "soccer_fields")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoccerFields.findAll", query = "SELECT s FROM SoccerFields s")
    , @NamedQuery(name = "SoccerFields.findByIdSoccerFields", query = "SELECT s FROM SoccerFields s WHERE s.idSoccerFields = :idSoccerFields")
    , @NamedQuery(name = "SoccerFields.findByName", query = "SELECT s FROM SoccerFields s WHERE s.name = :name")
    , @NamedQuery(name = "SoccerFields.findByAvaliable", query = "SELECT s FROM SoccerFields s WHERE s.avaliable = :avaliable")})
public class SoccerFields implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_soccer_fields")
    private Integer idSoccerFields;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "avaliable")
    private boolean avaliable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoccerFields")
    private List<Reservations> reservationsList;
    @JoinColumn(name = "id_headquarters", referencedColumnName = "id_headquarters")
    @ManyToOne(optional = false)
    private Headquarters idHeadquarters;
    @JoinColumn(name = "id_soccer_fields_types", referencedColumnName = "id_soccer_field_types")
    @ManyToOne(optional = false)
    private SoccerFieldTypes idSoccerFieldsTypes;

    public SoccerFields() {
    }

    public SoccerFields(Integer idSoccerFields) {
        this.idSoccerFields = idSoccerFields;
    }

    public SoccerFields(Integer idSoccerFields, String name, boolean avaliable) {
        this.idSoccerFields = idSoccerFields;
        this.name = name;
        this.avaliable = avaliable;
    }

    public Integer getIdSoccerFields() {
        return idSoccerFields;
    }

    public void setIdSoccerFields(Integer idSoccerFields) {
        this.idSoccerFields = idSoccerFields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    @XmlTransient
    public List<Reservations> getReservationsList() {
        return reservationsList;
    }

    public void setReservationsList(List<Reservations> reservationsList) {
        this.reservationsList = reservationsList;
    }

    public Headquarters getIdHeadquarters() {
        return idHeadquarters;
    }

    public void setIdHeadquarters(Headquarters idHeadquarters) {
        this.idHeadquarters = idHeadquarters;
    }

    public SoccerFieldTypes getIdSoccerFieldsTypes() {
        return idSoccerFieldsTypes;
    }

    public void setIdSoccerFieldsTypes(SoccerFieldTypes idSoccerFieldsTypes) {
        this.idSoccerFieldsTypes = idSoccerFieldsTypes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoccerFields != null ? idSoccerFields.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoccerFields)) {
            return false;
        }
        SoccerFields other = (SoccerFields) object;
        if ((this.idSoccerFields == null && other.idSoccerFields != null) || (this.idSoccerFields != null && !this.idSoccerFields.equals(other.idSoccerFields))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.SoccerFields[ idSoccerFields=" + idSoccerFields + " ]";
    }
    
}
