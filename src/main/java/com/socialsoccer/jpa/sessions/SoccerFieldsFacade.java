/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.sessions;

import com.socialsoccer.jpa.entities.Establishments;
import com.socialsoccer.jpa.entities.Headquarters;
import com.socialsoccer.jpa.entities.Headquarters_;
import com.socialsoccer.jpa.entities.SoccerFields;
import com.socialsoccer.jpa.entities.SoccerFields_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ADMIN
 */
@Stateless
public class SoccerFieldsFacade extends AbstractFacade<SoccerFields> {

    @PersistenceContext(unitName = "com.socialsoccer_SocialSoccer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoccerFieldsFacade() {
        super(SoccerFields.class);
    }
    
    public List<SoccerFields> findByEstablecimiento(Integer idEstablecimiento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<SoccerFields> cq = cb.createQuery(SoccerFields.class);
        Root<SoccerFields> soccerfields = cq.from(SoccerFields.class);
        
        Predicate restrictions = cb.conjunction();
        
        if (idEstablecimiento != null) {
            Join<SoccerFields, Headquarters> joinheadquerters = soccerfields.join(SoccerFields_.idHeadquarters);
            restrictions = cb.and(restrictions, cb.equal(joinheadquerters.get(Headquarters_.idEstablishments), new Establishments(idEstablecimiento)));
        }
        
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(soccerfields.get(SoccerFields_.name)));
        TypedQuery<SoccerFields> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
       /*public List<SoccerFields> findByHeardquarters(Integer idHeadquarters){
       public List<SoccerFields> findById(Integer idSoccerFields) {


        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<SoccerFields> cq = cb.createQuery(SoccerFields.class);
        Root<SoccerFields> soccerfields = cq.from(SoccerFields.class);

        cq.where(cb.equal(soccerfields.get(SoccerFields_.idHeadquarters)));

        
        Predicate restrictions = cb.conjunction();
        
        if (idSoccerFields != null) {
            restrictions = cb.and(restrictions, cb.equal(soccerfields.get(SoccerFields_.idSoccerFields), new SoccerFields(idSoccerFields)));
        }
        
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(soccerfields.get(SoccerFields_.name)));

        TypedQuery<SoccerFields> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }

    }*/

    }

    

