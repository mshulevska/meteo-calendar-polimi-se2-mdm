/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.session;

import com.polimi.meteocal.entities.User;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miter_000
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "com.polimi_MeteoCal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    
    @Resource
    private SessionContext ctx;
    
    
    public String getLoggedUser(){
        return ctx.getCallerPrincipal().getName();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
}
