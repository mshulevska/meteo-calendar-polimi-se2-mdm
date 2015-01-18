/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.session;

import com.polimi.meteocal.entities.Location;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miter_000
 */
@Stateless
public class LocationFacade extends AbstractFacade<Location> {
    @PersistenceContext(unitName = "com.polimi_MeteoCalendar_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void save(Location l){
        em.persist(l);
    }

    public LocationFacade() {
        super(Location.class);
    }
    
}
