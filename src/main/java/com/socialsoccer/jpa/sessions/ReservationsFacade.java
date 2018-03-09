/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.sessions;

import com.socialsoccer.jpa.entities.Reservations;
import com.socialsoccer.jpa.entities.Reservations_;
import static com.socialsoccer.jpa.entities.Reservations_.idUsers;
import com.socialsoccer.jpa.entities.Users;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
     public List<Reservations> findReservations(Integer idUser){
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Reservations> cq = cb.createQuery(Reservations.class);
        Root<Reservations> reservations = cq.from(Reservations.class);
        
        Predicate data = cb.conjunction();
        
        
        
        if(idUsers != null){
            data = cb.and(data, cb.equal(reservations.get(Reservations_.idUsers), new Users(idUser)));
        }
        
        
        
        cq.where(data);
        cq.orderBy(cb.asc(reservations.get(Reservations_.idUsers)));
        TypedQuery<Reservations> tq = em.createQuery(cq);
        
        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
