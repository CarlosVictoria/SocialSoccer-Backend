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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Carlos Jose Victoria
 */
@Entity
@Table(name = "headquarters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Headquarters.findAll", query = "SELECT h FROM Headquarters h")
    , @NamedQuery(name = "Headquarters.findByIdHeadquarters", query = "SELECT h FROM Headquarters h WHERE h.idHeadquarters = :idHeadquarters")
    , @NamedQuery(name = "Headquarters.findByNumHeadquarters", query = "SELECT h FROM Headquarters h WHERE h.numHeadquarters = :numHeadquarters")
    , @NamedQuery(name = "Headquarters.findByAddress", query = "SELECT h FROM Headquarters h WHERE h.address = :address")
    , @NamedQuery(name = "Headquarters.findByTelephone", query = "SELECT h FROM Headquarters h WHERE h.telephone = :telephone")
    , @NamedQuery(name = "Headquarters.findByNumSoccerFields", query = "SELECT h FROM Headquarters h WHERE h.numSoccerFields = :numSoccerFields")})
public class Headquarters implements Serializable {

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
    @Size(min = 1, max = 30)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_soccer_fields")
    private int numSoccerFields;
    @JoinTable(name = "tournaments_has_headquarters", joinColumns = {
        @JoinColumn(name = "id_headquarters", referencedColumnName = "id_headquarters")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tournaments", referencedColumnName = "id_tournaments")})
    @ManyToMany
    private List<Tournaments> tournamentsList;
    @JoinColumn(name = "id_establishments", referencedColumnName = "id_establishments")
    @ManyToOne(optional = false)
    private Establishments idEstablishments;
    @JoinColumn(name = "id_cities", referencedColumnName = "id_cities")
    @ManyToOne(optional = false)
    private Cities idCities;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHeadquarters")
    private List<SoccerFields> soccerFieldsList;

    public Headquarters() {
    }

    public Headquarters(Integer idHeadquarters) {
        this.idHeadquarters = idHeadquarters;
    }

    public Headquarters(Integer idHeadquarters, String numHeadquarters, String address, String telephone, int numSoccerFields) {
        this.idHeadquarters = idHeadquarters;
        this.numHeadquarters = numHeadquarters;
        this.address = address;
        this.telephone = telephone;
        this.numSoccerFields = numSoccerFields;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNumSoccerFields() {
        return numSoccerFields;
    }

    public void setNumSoccerFields(int numSoccerFields) {
        this.numSoccerFields = numSoccerFields;
    }

    @XmlTransient
    public List<Tournaments> getTournamentsList() {
        return tournamentsList;
    }

    public void setTournamentsList(List<Tournaments> tournamentsList) {
        this.tournamentsList = tournamentsList;
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
    
}
