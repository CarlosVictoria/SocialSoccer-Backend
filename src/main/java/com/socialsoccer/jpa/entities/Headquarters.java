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
 * @author ADMIN
 */
@Entity
@Table(name = "headquarters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Headquarters.findAll", query = "SELECT h FROM Headquarters h")})
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
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
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
    @Column(name = "main_headquarter")
    private Boolean mainHeadquarter;
    @JoinTable(name = "tournaments_has_headquarters", joinColumns = {
        @JoinColumn(name = "id_headquarters", referencedColumnName = "id_headquarters")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tournaments", referencedColumnName = "id_tournaments")})
    @ManyToMany
    private List<Tournaments> tournamentsList;
    @OneToMany(mappedBy = "idMainHeadquarter")
    private List<Headquarters> headquartersList;
    @JoinColumn(name = "id_main_headquarter", referencedColumnName = "id_headquarters")
    @ManyToOne
    private Headquarters idMainHeadquarter;
    @JoinColumn(name = "id_users", referencedColumnName = "id_users")
    @ManyToOne(optional = false)
    private Users idUsers;
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

    public Headquarters(Integer idHeadquarters, String nit, String name, String address, String telephone, int numSoccerFields) {
        this.idHeadquarters = idHeadquarters;
        this.nit = nit;
        this.name = name;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getMainHeadquarter() {
        return mainHeadquarter;
    }

    public void setMainHeadquarter(Boolean mainHeadquarter) {
        this.mainHeadquarter = mainHeadquarter;
    }

    @XmlTransient
    public List<Tournaments> getTournamentsList() {
        return tournamentsList;
    }

    public void setTournamentsList(List<Tournaments> tournamentsList) {
        this.tournamentsList = tournamentsList;
    }

    @XmlTransient
    public List<Headquarters> getHeadquartersList() {
        return headquartersList;
    }

    public void setHeadquartersList(List<Headquarters> headquartersList) {
        this.headquartersList = headquartersList;
    }

    public Headquarters getIdMainHeadquarter() {
        return idMainHeadquarter;
    }

    public void setIdMainHeadquarter(Headquarters idMainHeadquarter) {
        this.idMainHeadquarter = idMainHeadquarter;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
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
