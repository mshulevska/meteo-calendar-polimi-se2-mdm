package com.polimi.meteocal.entities;

import com.polimi.meteocal.entities.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-12T23:20:24")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> streetName;
    public static volatile CollectionAttribute<Location, Event> eventCollection;
    public static volatile SingularAttribute<Location, Integer> idLocation;
    public static volatile SingularAttribute<Location, String> city;
    public static volatile SingularAttribute<Location, String> latitude;
    public static volatile SingularAttribute<Location, String> longitude;

}