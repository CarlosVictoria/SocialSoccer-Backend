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
@Table(name = "document_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentTypes.findAll", query = "SELECT d FROM DocumentTypes d")
    , @NamedQuery(name = "DocumentTypes.findByIdDocumentTypes", query = "SELECT d FROM DocumentTypes d WHERE d.idDocumentTypes = :idDocumentTypes")
    , @NamedQuery(name = "DocumentTypes.findByDescription", query = "SELECT d FROM DocumentTypes d WHERE d.description = :description")})
public class DocumentTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_document_types")
    private Integer idDocumentTypes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumentTypes")
    private List<Users> usersList;

    public DocumentTypes() {
    }

    public DocumentTypes(Integer idDocumentTypes) {
        this.idDocumentTypes = idDocumentTypes;
    }

    public DocumentTypes(Integer idDocumentTypes, String description) {
        this.idDocumentTypes = idDocumentTypes;
        this.description = description;
    }

    public Integer getIdDocumentTypes() {
        return idDocumentTypes;
    }

    public void setIdDocumentTypes(Integer idDocumentTypes) {
        this.idDocumentTypes = idDocumentTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentTypes != null ? idDocumentTypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentTypes)) {
            return false;
        }
        DocumentTypes other = (DocumentTypes) object;
        if ((this.idDocumentTypes == null && other.idDocumentTypes != null) || (this.idDocumentTypes != null && !this.idDocumentTypes.equals(other.idDocumentTypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.DocumentTypes[ idDocumentTypes=" + idDocumentTypes + " ]";
    }
    
}
