/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "matches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matches.findAll", query = "SELECT m FROM Matches m")
    , @NamedQuery(name = "Matches.findByIdMatches", query = "SELECT m FROM Matches m WHERE m.idMatches = :idMatches")
    , @NamedQuery(name = "Matches.findByDate", query = "SELECT m FROM Matches m WHERE m.date = :date")
    , @NamedQuery(name = "Matches.findByGoalsTeam1", query = "SELECT m FROM Matches m WHERE m.goalsTeam1 = :goalsTeam1")
    , @NamedQuery(name = "Matches.findByGoalsTeam2", query = "SELECT m FROM Matches m WHERE m.goalsTeam2 = :goalsTeam2")
    , @NamedQuery(name = "Matches.findByResults", query = "SELECT m FROM Matches m WHERE m.results = :results")})
public class Matches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matches")
    private Integer idMatches;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goals_team1")
    private int goalsTeam1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goals_team2")
    private int goalsTeam2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "results")
    private String results;
    @JoinTable(name = "matches_has_judges", joinColumns = {
        @JoinColumn(name = "id_matches", referencedColumnName = "id_matches")}, inverseJoinColumns = {
        @JoinColumn(name = "id_users", referencedColumnName = "id_users")})
    @ManyToMany
    private List<Users> usersList;
    @JoinColumn(name = "id_team1", referencedColumnName = "id_teams")
    @ManyToOne(optional = false)
    private Teams idTeam1;
    @JoinColumn(name = "id_team2", referencedColumnName = "id_teams")
    @ManyToOne(optional = false)
    private Teams idTeam2;
    @JoinColumn(name = "id_tournaments", referencedColumnName = "id_tournaments")
    @ManyToOne(optional = false)
    private Tournaments idTournaments;

    public Matches() {
    }

    public Matches(Integer idMatches) {
        this.idMatches = idMatches;
    }

    public Matches(Integer idMatches, Date date, int goalsTeam1, int goalsTeam2, String results) {
        this.idMatches = idMatches;
        this.date = date;
        this.goalsTeam1 = goalsTeam1;
        this.goalsTeam2 = goalsTeam2;
        this.results = results;
    }

    public Integer getIdMatches() {
        return idMatches;
    }

    public void setIdMatches(Integer idMatches) {
        this.idMatches = idMatches;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGoalsTeam1() {
        return goalsTeam1;
    }

    public void setGoalsTeam1(int goalsTeam1) {
        this.goalsTeam1 = goalsTeam1;
    }

    public int getGoalsTeam2() {
        return goalsTeam2;
    }

    public void setGoalsTeam2(int goalsTeam2) {
        this.goalsTeam2 = goalsTeam2;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Teams getIdTeam1() {
        return idTeam1;
    }

    public void setIdTeam1(Teams idTeam1) {
        this.idTeam1 = idTeam1;
    }

    public Teams getIdTeam2() {
        return idTeam2;
    }

    public void setIdTeam2(Teams idTeam2) {
        this.idTeam2 = idTeam2;
    }

    public Tournaments getIdTournaments() {
        return idTournaments;
    }

    public void setIdTournaments(Tournaments idTournaments) {
        this.idTournaments = idTournaments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatches != null ? idMatches.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matches)) {
            return false;
        }
        Matches other = (Matches) object;
        if ((this.idMatches == null && other.idMatches != null) || (this.idMatches != null && !this.idMatches.equals(other.idMatches))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Matches[ idMatches=" + idMatches + " ]";
    }
    
}
