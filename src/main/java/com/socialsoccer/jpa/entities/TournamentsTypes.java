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
 * @author ADMIN
 */
@Entity
@Table(name = "tournaments_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TournamentsTypes.findAll", query = "SELECT t FROM TournamentsTypes t")})
public class TournamentsTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tournaments_types")
    private Integer idTournamentsTypes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTournamentsTypes")
    private List<Tournaments> tournamentsList;

    public TournamentsTypes() {
    }

    public TournamentsTypes(Integer idTournamentsTypes) {
        this.idTournamentsTypes = idTournamentsTypes;
    }

    public TournamentsTypes(Integer idTournamentsTypes, String description) {
        this.idTournamentsTypes = idTournamentsTypes;
        this.description = description;
    }

    public Integer getIdTournamentsTypes() {
        return idTournamentsTypes;
    }

    public void setIdTournamentsTypes(Integer idTournamentsTypes) {
        this.idTournamentsTypes = idTournamentsTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Tournaments> getTournamentsList() {
        return tournamentsList;
    }

    public void setTournamentsList(List<Tournaments> tournamentsList) {
        this.tournamentsList = tournamentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTournamentsTypes != null ? idTournamentsTypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TournamentsTypes)) {
            return false;
        }
        TournamentsTypes other = (TournamentsTypes) object;
        if ((this.idTournamentsTypes == null && other.idTournamentsTypes != null) || (this.idTournamentsTypes != null && !this.idTournamentsTypes.equals(other.idTournamentsTypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.TournamentsTypes[ idTournamentsTypes=" + idTournamentsTypes + " ]";
    }
    
}
