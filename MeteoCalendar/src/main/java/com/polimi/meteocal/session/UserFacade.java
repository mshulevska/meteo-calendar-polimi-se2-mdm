/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.session;

import com.polimi.meteocal.entities.User;
import java.security.Principal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miter_000
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
   
    @PersistenceContext(unitName = "com.polimi_MeteoCalendar_war_1.0PU")
    private EntityManager em;
    
    @Inject
    Principal principal;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public void save(User user) {
        user.setGroupname("USER"); //according to the GF descriptor
        em.persist(user);
    }
    
    
    public void unregister() {
        em.remove(getLoggedUser());
    }

    public User getLoggedUser() {
        return em.find(User.class, principal.getName());
    }
    
}
