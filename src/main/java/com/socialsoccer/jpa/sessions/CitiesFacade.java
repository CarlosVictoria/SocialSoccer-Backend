/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.sessions;

import com.socialsoccer.jpa.entities.Cities;
import com.socialsoccer.jpa.entities.Cities_;
import com.socialsoccer.jpa.entities.Departments;
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
 * @author ADMIN
 */
@Stateless
public class CitiesFacade extends AbstractFacade<Cities> {

    @PersistenceContext(unitName = "com.socialsoccer_SocialSoccer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitiesFacade() {
        super(Cities.class);
    }
    
    public List<Cities> findCityByName(String query, Integer idDepartamento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Cities> cq = cb.createQuery(Cities.class);
        Root<Cities> city = cq.from(Cities.class);
        
        Predicate restrictions = cb.conjunction();
        
        if (idDepartamento != null) {
            restrictions = cb.and(restrictions, cb.equal(city.get(Cities_.idDepartments), new Departments(idDepartamento)));
        }
        
        if (query != null) {
            restrictions = cb.and(restrictions,cb.like(city.get(Cities_.name), "%" + query + "%"));
        }
        
        cq.where(restrictions);
        cq.orderBy(cb.asc(city.get(Cities_.name)));
        TypedQuery<Cities> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
