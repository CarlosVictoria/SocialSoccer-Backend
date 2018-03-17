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
@Table(name = "teams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t")
    , @NamedQuery(name = "Teams.findByIdTeams", query = "SELECT t FROM Teams t WHERE t.idTeams = :idTeams")
    , @NamedQuery(name = "Teams.findByName", query = "SELECT t FROM Teams t WHERE t.name = :name")})
public class Teams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_teams")
    private Integer idTeams;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam1")
    private List<Matches> matchesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam2")
    private List<Matches> matchesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeams")
    private List<PlayersTeamsTournaments> playersTeamsTournamentsList;

    public Teams() {
    }

    public Teams(Integer idTeams) {
        this.idTeams = idTeams;
    }

    public Teams(Integer idTeams, String name) {
        this.idTeams = idTeams;
        this.name = name;
    }

    public Integer getIdTeams() {
        return idTeams;
    }

    public void setIdTeams(Integer idTeams) {
        this.idTeams = idTeams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Matches> getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List<Matches> matchesList) {
        this.matchesList = matchesList;
    }

    @XmlTransient
    public List<Matches> getMatchesList1() {
        return matchesList1;
    }

    public void setMatchesList1(List<Matches> matchesList1) {
        this.matchesList1 = matchesList1;
    }

    @XmlTransient
    public List<PlayersTeamsTournaments> getPlayersTeamsTournamentsList() {
        return playersTeamsTournamentsList;
    }

    public void setPlayersTeamsTournamentsList(List<PlayersTeamsTournaments> playersTeamsTournamentsList) {
        this.playersTeamsTournamentsList = playersTeamsTournamentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTeams != null ? idTeams.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.idTeams == null && other.idTeams != null) || (this.idTeams != null && !this.idTeams.equals(other.idTeams))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Teams[ idTeams=" + idTeams + " ]";
    }
    
}
