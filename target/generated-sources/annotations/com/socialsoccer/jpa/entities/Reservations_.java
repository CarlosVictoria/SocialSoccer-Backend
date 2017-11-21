package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.SoccerFields;
import com.socialsoccer.jpa.entities.Tournaments;
import com.socialsoccer.jpa.entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-21T12:42:38")
@StaticMetamodel(Reservations.class)
public class Reservations_ { 

    public static volatile SingularAttribute<Reservations, Date> date;
    public static volatile SingularAttribute<Reservations, SoccerFields> idSoccerFields;
    public static volatile SingularAttribute<Reservations, Integer> idReservations;
    public static volatile SingularAttribute<Reservations, Date> initialHour;
    public static volatile SingularAttribute<Reservations, Tournaments> idTournaments;
    public static volatile SingularAttribute<Reservations, Users> idUsers;
    public static volatile SingularAttribute<Reservations, Date> finalHour;

}