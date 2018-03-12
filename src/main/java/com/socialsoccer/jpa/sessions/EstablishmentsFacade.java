/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.sessions;

import com.socialsoccer.jpa.entities.Establishments;
import com.socialsoccer.jpa.entities.Establishments_;
import com.socialsoccer.jpa.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Carlos Jose Victoria
 */
@Stateless
public class EstablishmentsFacade extends AbstractFacade<Establishments> {

    @PersistenceContext(unitName = "com.socialsoccer_SocialSoccer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstablishmentsFacade() {
        super(Establishments.class);
    }
    
    /*public List<Establishments> findEstablishmentByIdUser(Integer idUser) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Establishments> cq = cb.createQuery(Establishments.class);
        Root<Establishments> city = cq.from(Establishments.class);
        
        Predicate restrictions = cb.conjunction();
        
        if (idUser != null) {
            restrictions = cb.and(restrictions, cb.equal(city.get(Establishments_.idUsers), new Users(idUser)));
        }
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(city.get(Establishments_.name)));
        TypedQuery<Establishments> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }*/
}
