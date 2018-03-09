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
@Table(name = "reservations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservations.findAll", query = "SELECT r FROM Reservations r")
    , @NamedQuery(name = "Reservations.findByIdReservations", query = "SELECT r FROM Reservations r WHERE r.idReservations = :idReservations")
    , @NamedQuery(name = "Reservations.findByDate", query = "SELECT r FROM Reservations r WHERE r.date = :date")
    , @NamedQuery(name = "Reservations.findByInitialHour", query = "SELECT r FROM Reservations r WHERE r.initialHour = :initialHour")
    , @NamedQuery(name = "Reservations.findByFinalHour", query = "SELECT r FROM Reservations r WHERE r.finalHour = :finalHour")
    , @NamedQuery(name = "Reservations.findByEstado", query = "SELECT r FROM Reservations r WHERE r.estado = :estado")
    , @NamedQuery(name = "Reservations.findByCheck", query = "SELECT r FROM Reservations r WHERE r.check = :check")})
public class Reservations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reservations")
    private Integer idReservations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "initial_hour")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "final_hour")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalHour;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "check")
    private Boolean check;
    @JoinColumn(name = "id_soccer_fields", referencedColumnName = "id_soccer_fields")
    @ManyToOne(optional = false)
    private SoccerFields idSoccerFields;
    @JoinColumn(name = "id_tournaments", referencedColumnName = "id_tournaments")
    @ManyToOne
    private Tournaments idTournaments;
    @JoinColumn(name = "id_users", referencedColumnName = "id_users")
    @ManyToOne(optional = false)
    private Users idUsers;

    public Reservations() {
    }

    public Reservations(Integer idReservations) {
        this.idReservations = idReservations;
    }

    public Reservations(Integer idReservations, Date date, Date initialHour, Date finalHour) {
        this.idReservations = idReservations;
        this.date = date;
        this.initialHour = initialHour;
        this.finalHour = finalHour;
    }

    public Integer getIdReservations() {
        return idReservations;
    }

    public void setIdReservations(Integer idReservations) {
        this.idReservations = idReservations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getInitialHour() {
        return initialHour;
    }

    public void setInitialHour(Date initialHour) {
        this.initialHour = initialHour;
    }

    public Date getFinalHour() {
        return finalHour;
    }

    public void setFinalHour(Date finalHour) {
        this.finalHour = finalHour;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public SoccerFields getIdSoccerFields() {
        return idSoccerFields;
    }

    public void setIdSoccerFields(SoccerFields idSoccerFields) {
        this.idSoccerFields = idSoccerFields;
    }

    public Tournaments getIdTournaments() {
        return idTournaments;
    }

    public void setIdTournaments(Tournaments idTournaments) {
        this.idTournaments = idTournaments;
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
        hash += (idReservations != null ? idReservations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservations)) {
            return false;
        }
        Reservations other = (Reservations) object;
        if ((this.idReservations == null && other.idReservations != null) || (this.idReservations != null && !this.idReservations.equals(other.idReservations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.socialsoccer.jpa.entities.Reservations[ idReservations=" + idReservations + " ]";
    }
    
}
