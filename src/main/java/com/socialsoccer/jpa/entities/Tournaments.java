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
 * @author ADMIN
 */
@Entity
@Table(name = "tournaments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tournaments.findAll", query = "SELECT t FROM Tournaments t")})
public class Tournaments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tournaments")
    private Integer idTournaments;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "tournamentsList")
    private List<Teams> teamsList;
    @ManyToMany(mappedBy = "tournamentsList")
    private List<Headquarters> headquartersList;
    @JoinColumn(name = "id_tournaments_types", referencedColumnName = "id_tournaments_types")
    @ManyToOne(optional = false)
    private TournamentsTypes idTournamentsTypes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTournaments")
    private List<Matches> matchesList;
    @OneToMany(mappedBy = "idTournaments")
    private List<Reservations> reservationsList;

    public Tournaments() {
    }

    public Tournaments(Integer idTournaments) {
        this.idTournaments = idTournaments;
    }

    public Tournaments(Integer idTournaments, String name) {
        this.idTournaments = idTournaments;
        this.name = name;
    }

    public Integer getIdTournaments() {
        return idTournaments;
    }

    public void setIdTournaments(Integer idTournaments) {
        this.idTournaments = idTournaments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Teams> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Teams> teamsList) {
        this.teamsList = teamsList;
    }

    @XmlTransient
    public List<Headquarters> getHeadquartersList() {
        return headquartersList;
    }

    public void setHeadquartersList(List<Headquarters> headquartersList) {
        this.headquartersList = headquartersList;
    }

    public TournamentsTypes getIdTournamentsTypes() {
        return idTournamentsTypes;
    }

    public void setIdTournamentsTypes(TournamentsTypes idTournamentsTypes) {
        this.idTournamentsTypes = idTournamentsTypes;
    }

    @XmlTransient
    public List<Matches> getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List<Matches> matchesList) {
        this.matchesList = matchesList;
    }

    @XmlTransient
    public List<Reservations> getReservationsList() {
        return reservationsList;
    }

    public void setReservationsList(List<Reservations> reservationsList) {
        this.reservationsList = reservationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTournaments != null ? idTournaments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournaments)) {
            return false;
        }
        Tournaments other = (Tournaments) object;
        if ((this.idTournaments == null && other.idTournaments != null) || (this.idTournaments != null && !this.idTournaments.equals(other.idTournaments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Tournaments[ idTournaments=" + idTournaments + " ]";
    }
    
}
