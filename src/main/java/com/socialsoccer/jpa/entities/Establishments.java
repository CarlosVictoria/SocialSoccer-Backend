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
 * @author Johan
 */
@Entity
@Table(name = "establishments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Establishments.findAll", query = "SELECT e FROM Establishments e")
    , @NamedQuery(name = "Establishments.findByIdEstablishments", query = "SELECT e FROM Establishments e WHERE e.idEstablishments = :idEstablishments")
    , @NamedQuery(name = "Establishments.findByName", query = "SELECT e FROM Establishments e WHERE e.name = :name")})
public class Establishments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_establishments")
    private Integer idEstablishments;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "tournaments_has_establishments", joinColumns = {
        @JoinColumn(name = "id_establishments", referencedColumnName = "id_establishments")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tournaments", referencedColumnName = "id_tournaments")})
    @ManyToMany
    private List<Tournaments> tournamentsList;
    @JoinColumn(name = "id_users", referencedColumnName = "id_users")
    @ManyToOne(optional = false)
    private Users idUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstablishments")
    private List<Headquarters> headquartersList;

    public Establishments() {
    }

    public Establishments(Integer idEstablishments) {
        this.idEstablishments = idEstablishments;
    }

    public Establishments(Integer idEstablishments, String name) {
        this.idEstablishments = idEstablishments;
        this.name = name;
    }

    public Integer getIdEstablishments() {
        return idEstablishments;
    }

    public void setIdEstablishments(Integer idEstablishments) {
        this.idEstablishments = idEstablishments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Tournaments> getTournamentsList() {
        return tournamentsList;
    }

    public void setTournamentsList(List<Tournaments> tournamentsList) {
        this.tournamentsList = tournamentsList;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
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
        hash += (idEstablishments != null ? idEstablishments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Establishments)) {
            return false;
        }
        Establishments other = (Establishments) object;
        if ((this.idEstablishments == null && other.idEstablishments != null) || (this.idEstablishments != null && !this.idEstablishments.equals(other.idEstablishments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Establishments[ idEstablishments=" + idEstablishments + " ]";
    }
    
}
