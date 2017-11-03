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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johan
 */
@Entity
@Table(name = "users_au")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersAu.findAll", query = "SELECT u FROM UsersAu u")
    , @NamedQuery(name = "UsersAu.findByIdUsersOld", query = "SELECT u FROM UsersAu u WHERE u.idUsersOld = :idUsersOld")
    , @NamedQuery(name = "UsersAu.findByNumDocumentOld", query = "SELECT u FROM UsersAu u WHERE u.numDocumentOld = :numDocumentOld")
    , @NamedQuery(name = "UsersAu.findByNamesOld", query = "SELECT u FROM UsersAu u WHERE u.namesOld = :namesOld")
    , @NamedQuery(name = "UsersAu.findByLastNamesOld", query = "SELECT u FROM UsersAu u WHERE u.lastNamesOld = :lastNamesOld")
    , @NamedQuery(name = "UsersAu.findByGenderOld", query = "SELECT u FROM UsersAu u WHERE u.genderOld = :genderOld")
    , @NamedQuery(name = "UsersAu.findByEmailOld", query = "SELECT u FROM UsersAu u WHERE u.emailOld = :emailOld")
    , @NamedQuery(name = "UsersAu.findByPasswordOld", query = "SELECT u FROM UsersAu u WHERE u.passwordOld = :passwordOld")
    , @NamedQuery(name = "UsersAu.findByActiveOld", query = "SELECT u FROM UsersAu u WHERE u.activeOld = :activeOld")})
public class UsersAu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_users_old")
    private Integer idUsersOld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_document_old")
    private String numDocumentOld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "names_old")
    private String namesOld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_names_old")
    private String lastNamesOld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "gender_old")
    private String genderOld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_old")
    private String emailOld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password_old")
    private String passwordOld;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active_old")
    private boolean activeOld;

    public UsersAu() {
    }

    public UsersAu(Integer idUsersOld) {
        this.idUsersOld = idUsersOld;
    }

    public UsersAu(Integer idUsersOld, String numDocumentOld, String namesOld, String lastNamesOld, String genderOld, String emailOld, String passwordOld, boolean activeOld) {
        this.idUsersOld = idUsersOld;
        this.numDocumentOld = numDocumentOld;
        this.namesOld = namesOld;
        this.lastNamesOld = lastNamesOld;
        this.genderOld = genderOld;
        this.emailOld = emailOld;
        this.passwordOld = passwordOld;
        this.activeOld = activeOld;
    }

    public Integer getIdUsersOld() {
        return idUsersOld;
    }

    public void setIdUsersOld(Integer idUsersOld) {
        this.idUsersOld = idUsersOld;
    }

    public String getNumDocumentOld() {
        return numDocumentOld;
    }

    public void setNumDocumentOld(String numDocumentOld) {
        this.numDocumentOld = numDocumentOld;
    }

    public String getNamesOld() {
        return namesOld;
    }

    public void setNamesOld(String namesOld) {
        this.namesOld = namesOld;
    }

    public String getLastNamesOld() {
        return lastNamesOld;
    }

    public void setLastNamesOld(String lastNamesOld) {
        this.lastNamesOld = lastNamesOld;
    }

    public String getGenderOld() {
        return genderOld;
    }

    public void setGenderOld(String genderOld) {
        this.genderOld = genderOld;
    }

    public String getEmailOld() {
        return emailOld;
    }

    public void setEmailOld(String emailOld) {
        this.emailOld = emailOld;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public boolean getActiveOld() {
        return activeOld;
    }

    public void setActiveOld(boolean activeOld) {
        this.activeOld = activeOld;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsersOld != null ? idUsersOld.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersAu)) {
            return false;
        }
        UsersAu other = (UsersAu) object;
        if ((this.idUsersOld == null && other.idUsersOld != null) || (this.idUsersOld != null && !this.idUsersOld.equals(other.idUsersOld))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.UsersAu[ idUsersOld=" + idUsersOld + " ]";
    }
    
}
