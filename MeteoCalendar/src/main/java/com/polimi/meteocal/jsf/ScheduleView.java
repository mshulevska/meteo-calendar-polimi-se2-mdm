/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polimi.meteocal.jsf;

import com.polimi.meteocal.entities.Event;
import com.polimi.meteocal.entities.Location;
import com.polimi.meteocal.session.EventFacade;
import com.polimi.meteocal.session.LocationFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javafx.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author miter_000
 */
@Named(value = "scheduleView")
@SessionScoped
public class ScheduleView implements Serializable {
 
    @EJB
    private EventFacade ef;
    
    @EJB
    private LocationFacade lf;
    
    @Inject
    private UserController uc;
    
    private Location loc;
    
    
    

    public Location getLoc() {
        
        if(loc==null) loc = new Location();
        
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }
    
            
    private Event nevent;

    public Event getNevent() {
        
        if(nevent==null)
        {
            nevent = new Event();
        }
                
        return nevent;
    }

    public void setNevent(Event nevent) {
        this.nevent = nevent;
    }
    
    private ScheduleModel eventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        
    }     
    
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }
     
    
 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
         
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
        
        
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
