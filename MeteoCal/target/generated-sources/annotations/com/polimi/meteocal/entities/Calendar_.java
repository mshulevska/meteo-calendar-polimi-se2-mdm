package com.polimi.meteocal.entities;

import com.polimi.meteocal.entities.Event;
import com.polimi.meteocal.entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-12T23:20:24")
@StaticMetamodel(Calendar.class)
public class Calendar_ { 

    public static volatile SingularAttribute<Calendar, Date> createdAt;
    public static volatile CollectionAttribute<Calendar, Event> eventCollection;
    public static volatile SingularAttribute<Calendar, User> useridUser;
    public static volatile SingularAttribute<Calendar, Boolean> visibility;
    public static volatile SingularAttribute<Calendar, String> name;
    public static volatile CollectionAttribute<Calendar, Event> eventCollection1;
    public static volatile SingularAttribute<Calendar, Integer> idCalendar;
    public static volatile SingularAttribute<Calendar, Date> updatedAt;

}