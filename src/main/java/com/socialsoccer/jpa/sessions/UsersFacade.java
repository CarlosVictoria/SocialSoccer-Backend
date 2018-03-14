/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.jpa.sessions;

import com.socialsoccer.jpa.entities.Users;
import com.socialsoccer.jpa.entities.Users_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "com.socialsoccer_SocialSoccer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users findUserByEmail(String email){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> usuario = cq.from(Users.class);
        cq.where(cb.equal(usuario.get(Users_.email), email));
        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        try {
            return q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public Users findUserByNumDocument(String numDocument) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> usuario = cq.from(Users.class);
        cq.where(cb.equal(usuario.get(Users_.numDocument), numDocument));
        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        try {
            return q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<Users> findUsers(Integer idUsers, Boolean active) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> user = cq.from(Users.class);
        
        Predicate data = cb.conjunction();
        
        if (idUsers != null) {
            data = cb.and(data, cb.equal(user.get(Users_.idUsers), new Users(idUsers)));
        }
        if(active != null){
            data = cb.and(data, cb.equal(user.get(Users_.active), active));
        }
        
        cq.where(data);
        cq.orderBy(cb.asc(user.get(Users_.names)));
        TypedQuery<Users> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
