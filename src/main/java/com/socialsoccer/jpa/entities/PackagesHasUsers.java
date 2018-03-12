/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "packages_has_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PackagesHasUsers.findAll", query = "SELECT p FROM PackagesHasUsers p")
    , @NamedQuery(name = "PackagesHasUsers.findByIdPackagesHasUsers", query = "SELECT p FROM PackagesHasUsers p WHERE p.idPackagesHasUsers = :idPackagesHasUsers")
    , @NamedQuery(name = "PackagesHasUsers.findByInitialDate", query = "SELECT p FROM PackagesHasUsers p WHERE p.initialDate = :initialDate")
    , @NamedQuery(name = "PackagesHasUsers.findByFinalDate", query = "SELECT p FROM PackagesHasUsers p WHERE p.finalDate = :finalDate")})
public class PackagesHasUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_packages_has_users")
    private Integer idPackagesHasUsers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "initial_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "final_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;
    @JoinColumn(name = "id_packages", referencedColumnName = "id_packages")
    @ManyToOne(optional = false)
    private Packages idPackages;
    @JoinColumn(name = "id_users", referencedColumnName = "id_users")
    @ManyToOne(optional = false)
    private Users idUsers;

    public PackagesHasUsers() {
    }

    public PackagesHasUsers(Integer idPackagesHasUsers) {
        this.idPackagesHasUsers = idPackagesHasUsers;
    }

    public PackagesHasUsers(Integer idPackagesHasUsers, Date initialDate, Date finalDate) {
        this.idPackagesHasUsers = idPackagesHasUsers;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    public Integer getIdPackagesHasUsers() {
        return idPackagesHasUsers;
    }

    public void setIdPackagesHasUsers(Integer idPackagesHasUsers) {
        this.idPackagesHasUsers = idPackagesHasUsers;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Packages getIdPackages() {
        return idPackages;
    }

    public void setIdPackages(Packages idPackages) {
        this.idPackages = idPackages;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPackagesHasUsers != null ? idPackagesHasUsers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackagesHasUsers)) {
            return false;
        }
        PackagesHasUsers other = (PackagesHasUsers) object;
        if ((this.idPackagesHasUsers == null && other.idPackagesHasUsers != null) || (this.idPackagesHasUsers != null && !this.idPackagesHasUsers.equals(other.idPackagesHasUsers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.PackagesHasUsers[ idPackagesHasUsers=" + idPackagesHasUsers + " ]";
    }
    
}
