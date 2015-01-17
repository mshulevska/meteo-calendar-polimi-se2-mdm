package com.polimi.meteocal.entities;

import com.polimi.meteocal.entities.Event;
import com.polimi.meteocal.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-12T23:20:24")
@StaticMetamodel(Invitation.class)
public class Invitation_ { 

    public static volatile SingularAttribute<Invitation, User> toUser;
    public static volatile SingularAttribute<Invitation, Event> eventidEvent;
    public static volatile SingularAttribute<Invitation, User> fromUser;
    public static volatile SingularAttribute<Invitation, Integer> idInvitation;

}