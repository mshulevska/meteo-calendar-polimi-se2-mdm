/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.session;

import com.polimi.meteocal.entities.Event;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miter_000
 */
@Stateless
public class EventFacade extends AbstractFacade<Event> {
    @PersistenceContext(unitName = "com.polimi_MeteoCalendar_war_1.0PU")
    private EntityManager em;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void save(Event e){
        em.persist(e);
    }

    public EventFacade() {
        super(Event.class);
    }
    
}
