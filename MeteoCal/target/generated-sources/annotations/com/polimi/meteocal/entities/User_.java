package com.polimi.meteocal.entities;

import com.polimi.meteocal.entities.Calendar;
import com.polimi.meteocal.entities.Invitation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-12T23:20:24")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile CollectionAttribute<User, Calendar> calendarCollection;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, Date> createdAt;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> name;
    public static volatile CollectionAttribute<User, Invitation> invitationCollection;
    public static volatile SingularAttribute<User, String> groupname;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Date> updatedAt;
    public static volatile CollectionAttribute<User, Invitation> invitationCollection1;

}