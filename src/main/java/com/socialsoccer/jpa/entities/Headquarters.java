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
 * @author adsi1261718
 */
@Entity
@Table(name = "headquarters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Headquarters.findAll", query = "SELECT h FROM Headquarters h")
    , @NamedQuery(name = "Headquarters.findByIdHeadquarters", query = "SELECT h FROM Headquarters h WHERE h.idHeadquarters = :idHeadquarters")
    , @NamedQuery(name = "Headquarters.findByNumHeadquarters", query = "SELECT h FROM Headquarters h WHERE h.numHeadquarters = :numHeadquarters")
    , @NamedQuery(name = "Headquarters.findByTelephone", query = "SELECT h FROM Headquarters h WHERE h.telephone = :telephone")})
public class Headquarters implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHeadquarters")
    private List<SoccerFields> soccerFieldsList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_headquarters")
    private Integer idHeadquarters;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_headquarters")
    private String numHeadquarters;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telephone")
    private String telephone;
    @JoinColumn(name = "id_establishments", referencedColumnName = "id_establishments")
    @ManyToOne(optional = false)
    private Establishments idEstablishments;
    @JoinColumn(name = "id_cities", referencedColumnName = "id_cities")
    @ManyToOne(optional = false)
    private Cities idCities;

    public Headquarters() {
    }

    public Headquarters(Integer idHeadquarters) {
        this.idHeadquarters = idHeadquarters;
    }

    public Headquarters(Integer idHeadquarters, String numHeadquarters, String telephone) {
        this.idHeadquarters = idHeadquarters;
        this.numHeadquarters = numHeadquarters;
        this.telephone = telephone;
    }

    public Integer getIdHeadquarters() {
        return idHeadquarters;
    }

    public void setIdHeadquarters(Integer idHeadquarters) {
        this.idHeadquarters = idHeadquarters;
    }

    public String getNumHeadquarters() {
        return numHeadquarters;
    }

    public void setNumHeadquarters(String numHeadquarters) {
        this.numHeadquarters = numHeadquarters;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Establishments getIdEstablishments() {
        return idEstablishments;
    }

    public void setIdEstablishments(Establishments idEstablishments) {
        this.idEstablishments = idEstablishments;
    }

    public Cities getIdCities() {
        return idCities;
    }

    public void setIdCities(Cities idCities) {
        this.idCities = idCities;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHeadquarters != null ? idHeadquarters.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Headquarters)) {
            return false;
        }
        Headquarters other = (Headquarters) object;
        if ((this.idHeadquarters == null && other.idHeadquarters != null) || (this.idHeadquarters != null && !this.idHeadquarters.equals(other.idHeadquarters))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Headquarters[ idHeadquarters=" + idHeadquarters + " ]";
    }

    @XmlTransient
    public List<SoccerFields> getSoccerFieldsList() {
        return soccerFieldsList;
    }

    public void setSoccerFieldsList(List<SoccerFields> soccerFieldsList) {
        this.soccerFieldsList = soccerFieldsList;
    }
    
}
