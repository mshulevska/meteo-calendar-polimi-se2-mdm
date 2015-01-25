/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polimi.meteocal.jsf.util;
/**
 *
 * @author miter_000
 */
import com.polimi.meteocal.entities.Event;
import com.polimi.meteocal.entities.Location;
import com.polimi.meteocal.entities.User;
import com.polimi.meteocal.session.EventFacade;
import com.polimi.meteocal.session.LocationFacade;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import org.primefaces.model.ScheduleEvent;

public class MCEvent implements ScheduleEvent, Serializable {

    private String id;
    private String title;
    private Date startDate;
    private Date endDate;
    private boolean allDay;
    private String styleClass;
    private Object data;
    private boolean editable;
    private String description;
    private Location location;
    private Event event;
    
    public MCEvent(){
        event = new Event();
    }
    
    
    @EJB
    private EventFacade ef;
    
    @EJB
    private LocationFacade lf;
    
    
    public Location getLocation() {
        
        if(location == null) this.location = new Location();
        
        return this.location;
    }

    public void setLocation(Location location) {       
        
        this.location = location;
    }

    @Override
    public String getId() {
        return this.id; 
    }

    @Override
    public void setId(String string) {
        this.id = string;
    }

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title){        
        event.setName(title);
        this.title = title;
    }

    @Override
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date start){
        
        event.setCreatedAt(start);
        this.startDate = start;
    }

    @Override
    public Date getEndDate() {
       return this.endDate;
    }
    
    public void setEndDate(Date end){
        
        event.setUpdatedAt(end);
        this.endDate = end;
    }

    @Override
    public boolean isAllDay() {
        return this.allDay;
    }

    @Override
    public String getStyleClass() {
        return this.styleClass;
    }

    @Override
    public boolean isEditable() {
       return this.editable;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
    
    
    public void setUser(User u){
        
        event.setUserEmail(u);
    }
    
    public User getUser() {
        
      return event.getUserEmail();
    }
    
    public void save(){
        ef.save(event);
        lf.save(location);
    }

}