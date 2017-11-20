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
 * @author Carlos Jose Victoria
 */
@Entity
@Table(name = "packages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p")
    , @NamedQuery(name = "Packages.findByIdPackages", query = "SELECT p FROM Packages p WHERE p.idPackages = :idPackages")
    , @NamedQuery(name = "Packages.findByPrice", query = "SELECT p FROM Packages p WHERE p.price = :price")
    , @NamedQuery(name = "Packages.findByDescription", query = "SELECT p FROM Packages p WHERE p.description = :description")})
public class Packages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_packages")
    private Integer idPackages;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPackages")
    private List<PackagesHasUsers> packagesHasUsersList;

    public Packages() {
    }

    public Packages(Integer idPackages) {
        this.idPackages = idPackages;
    }

    public Packages(Integer idPackages, double price, String description) {
        this.idPackages = idPackages;
        this.price = price;
        this.description = description;
    }

    public Integer getIdPackages() {
        return idPackages;
    }

    public void setIdPackages(Integer idPackages) {
        this.idPackages = idPackages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<PackagesHasUsers> getPackagesHasUsersList() {
        return packagesHasUsersList;
    }

    public void setPackagesHasUsersList(List<PackagesHasUsers> packagesHasUsersList) {
        this.packagesHasUsersList = packagesHasUsersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPackages != null ? idPackages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.idPackages == null && other.idPackages != null) || (this.idPackages != null && !this.idPackages.equals(other.idPackages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Packages[ idPackages=" + idPackages + " ]";
    }
    
}
