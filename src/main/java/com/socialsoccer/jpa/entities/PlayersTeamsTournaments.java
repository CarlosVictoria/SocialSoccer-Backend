/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "players_teams_tournaments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayersTeamsTournaments.findAll", query = "SELECT p FROM PlayersTeamsTournaments p")
    , @NamedQuery(name = "PlayersTeamsTournaments.findByIdPlayersTeamsTournaments", query = "SELECT p FROM PlayersTeamsTournaments p WHERE p.idPlayersTeamsTournaments = :idPlayersTeamsTournaments")})
public class PlayersTeamsTournaments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_players_teams_tournaments")
    private Integer idPlayersTeamsTournaments;
    @JoinColumn(name = "id_users", referencedColumnName = "id_users")
    @ManyToOne(optional = false)
    private Users idUsers;
    @JoinColumn(name = "id_teams", referencedColumnName = "id_teams")
    @ManyToOne(optional = false)
    private Teams idTeams;
    @JoinColumn(name = "id_tournaments", referencedColumnName = "id_tournaments")
    @ManyToOne(optional = false)
    private Tournaments idTournaments;

    public PlayersTeamsTournaments() {
    }

    public PlayersTeamsTournaments(Integer idPlayersTeamsTournaments) {
        this.idPlayersTeamsTournaments = idPlayersTeamsTournaments;
    }

    public Integer getIdPlayersTeamsTournaments() {
        return idPlayersTeamsTournaments;
    }

    public void setIdPlayersTeamsTournaments(Integer idPlayersTeamsTournaments) {
        this.idPlayersTeamsTournaments = idPlayersTeamsTournaments;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
    }

    public Teams getIdTeams() {
        return idTeams;
    }

    public void setIdTeams(Teams idTeams) {
        this.idTeams = idTeams;
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
        hash += (idPlayersTeamsTournaments != null ? idPlayersTeamsTournaments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayersTeamsTournaments)) {
            return false;
        }
        PlayersTeamsTournaments other = (PlayersTeamsTournaments) object;
        if ((this.idPlayersTeamsTournaments == null && other.idPlayersTeamsTournaments != null) || (this.idPlayersTeamsTournaments != null && !this.idPlayersTeamsTournaments.equals(other.idPlayersTeamsTournaments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.PlayersTeamsTournaments[ idPlayersTeamsTournaments=" + idPlayersTeamsTournaments + " ]";
    }
    
}
