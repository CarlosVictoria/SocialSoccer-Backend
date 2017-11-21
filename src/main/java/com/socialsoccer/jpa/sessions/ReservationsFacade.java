/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.sessions;

import com.socialsoccer.jpa.entities.Reservations;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ADMIN
 */
@Stateless
public class ReservationsFacade extends AbstractFacade<Reservations> {

    @PersistenceContext(unitName = "com.socialsoccer_SocialSoccer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationsFacade() {
        super(Reservations.class);
    }

    public Boolean checarDisponibilidad(Integer idCancha, Date fecha, Date horaInicial, Date horaFinal){
       Query checarDisponibilidad = em.createNativeQuery("select checarDisponibilidad(?,?,?,?)");
       checarDisponibilidad.setParameter(1,idCancha);
       checarDisponibilidad.setParameter(2,fecha);
       checarDisponibilidad.setParameter(3,horaInicial);
       checarDisponibilidad.setParameter(4,horaFinal);

        Boolean disponibilidad = (Boolean) checarDisponibilidad.getSingleResult();
        return disponibilidad;
    }
    
}
