package com.polimi.meteocal.entities;

import com.polimi.meteocal.entities.Calendar;
import com.polimi.meteocal.entities.Invitation;
import com.polimi.meteocal.entities.Location;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-12T23:20:24")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile CollectionAttribute<Event, Calendar> calendarCollection;
    public static volatile SingularAttribute<Event, Date> createdAt;
    public static volatile SingularAttribute<Event, Calendar> creator;
    public static volatile SingularAttribute<Event, Boolean> visibility;
    public static volatile SingularAttribute<Event, String> name;
    public static volatile SingularAttribute<Event, Integer> idEvent;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, Location> locationidLocation;
    public static volatile SingularAttribute<Event, Date> eventOccDate;
    public static volatile CollectionAttribute<Event, Invitation> invitationCollection;
    public static volatile SingularAttribute<Event, Date> updatedAt;

}