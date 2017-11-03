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
 * @author Johan
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIdUsers", query = "SELECT u FROM Users u WHERE u.idUsers = :idUsers")
    , @NamedQuery(name = "Users.findByNumDocument", query = "SELECT u FROM Users u WHERE u.numDocument = :numDocument")
    , @NamedQuery(name = "Users.findByNames", query = "SELECT u FROM Users u WHERE u.names = :names")
    , @NamedQuery(name = "Users.findByLastNames", query = "SELECT u FROM Users u WHERE u.lastNames = :lastNames")
    , @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByActive", query = "SELECT u FROM Users u WHERE u.active = :active")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_users")
    private Integer idUsers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_document")
    private String numDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "names")
    private String names;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_names")
    private String lastNames;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "gender")
    private String gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @ManyToMany(mappedBy = "usersList")
    private List<Roles> rolesList;
    @ManyToMany(mappedBy = "usersList")
    private List<Matches> matchesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<PackagesHasUsers> packagesHasUsersList;
    @JoinColumn(name = "id_cities", referencedColumnName = "id_cities")
    @ManyToOne(optional = false)
    private Cities idCities;
    @JoinColumn(name = "id_document_types", referencedColumnName = "id_document_types")
    @ManyToOne(optional = false)
    private DocumentTypes idDocumentTypes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<Establishments> establishmentsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<Reservations> reservationsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<PlayersTeamsTournaments> playersTeamsTournamentsList;

    public Users() {
    }

    public Users(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public Users(Integer idUsers, String numDocument, String names, String lastNames, String gender, String email, String password, boolean active) {
        this.idUsers = idUsers;
        this.numDocument = numDocument;
        this.names = names;
        this.lastNames = lastNames;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(String numDocument) {
        this.numDocument = numDocument;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<Matches> getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List<Matches> matchesList) {
        this.matchesList = matchesList;
    }

    @XmlTransient
    public List<PackagesHasUsers> getPackagesHasUsersList() {
        return packagesHasUsersList;
    }

    public void setPackagesHasUsersList(List<PackagesHasUsers> packagesHasUsersList) {
        this.packagesHasUsersList = packagesHasUsersList;
    }

    public Cities getIdCities() {
        return idCities;
    }

    public void setIdCities(Cities idCities) {
        this.idCities = idCities;
    }

    public DocumentTypes getIdDocumentTypes() {
        return idDocumentTypes;
    }

    public void setIdDocumentTypes(DocumentTypes idDocumentTypes) {
        this.idDocumentTypes = idDocumentTypes;
    }

    @XmlTransient
    public List<Establishments> getEstablishmentsList() {
        return establishmentsList;
    }

    public void setEstablishmentsList(List<Establishments> establishmentsList) {
        this.establishmentsList = establishmentsList;
    }

    @XmlTransient
    public List<Reservations> getReservationsList() {
        return reservationsList;
    }

    public void setReservationsList(List<Reservations> reservationsList) {
        this.reservationsList = reservationsList;
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
        hash += (idUsers != null ? idUsers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUsers == null && other.idUsers != null) || (this.idUsers != null && !this.idUsers.equals(other.idUsers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Users[ idUsers=" + idUsers + " ]";
    }
    
}
