package com.polimi.meteocal.jsf;
 
import com.polimi.meteocal.entities.Event;
import com.polimi.meteocal.entities.Location;
import com.polimi.meteocal.session.EventFacade;
import com.polimi.meteocal.session.LocationFacade;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
 
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
 
@Named(value = "scheduleView")
@SessionScoped
public class ScheduleView implements Serializable {
 
    private ScheduleModel eventModel;
    
    private Event event2;
    private Location location;
    
    
    @EJB
    private EventFacade ef;
    
    @EJB
    private LocationFacade lf;
    
    @Inject
    private UserController uc;
     
    private ScheduleEvent event = new DefaultScheduleEvent();
    //private ScheduleEvent event = new MCEvent();
    
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        eventModel.addEvent(new DefaultScheduleEvent("Champions League Match",today().getTime(),today().getTime()));
                 
    }
     
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
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
        if(event.getId() == null){
            
            if( event2 == null)  event2 = new Event();
            
            if(location==null) location = new Location();
            
            event2.setDescription(event.getDescription());
            event2.setName(event.getTitle());
            event2.setEventTime(event.getStartDate());
            event2.setVisibility(true);
            event2.setUserEmail(uc.getName());
            event2.setCreatedAt(new Date());
            location.setCity("Milano");
            location.setStreetName("Via Golgi");
            event2.setLocationidLocation(location);
            eventModel.addEvent(event);
        }
        else{
            
            if( event2 == null)  event2 = new Event();
            
            if(location==null) location = new Location();
            
            event2.setDescription(event.getDescription());
            event2.setName(event.getTitle());
            event2.setEventTime(event.getStartDate());
            event2.setVisibility(true);
            event2.setUserEmail(uc.getName());
            event2.setCreatedAt(new Date());
            location.setCity("Milano");
            location.setStreetName("Via Golgi");
            event2.setLocationidLocation(location);
            eventModel.updateEvent(event);
        }
        
        event = new DefaultScheduleEvent();
        lf.save(location);
        ef.save(event2);
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