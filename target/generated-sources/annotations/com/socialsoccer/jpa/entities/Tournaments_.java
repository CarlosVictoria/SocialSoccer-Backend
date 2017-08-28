package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Headquarters;
import com.socialsoccer.jpa.entities.Matches;
import com.socialsoccer.jpa.entities.Reservations;
import com.socialsoccer.jpa.entities.Teams;
import com.socialsoccer.jpa.entities.TournamentsTypes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T13:22:37")
@StaticMetamodel(Tournaments.class)
public class Tournaments_ { 

    public static volatile ListAttribute<Tournaments, Headquarters> headquartersList;
    public static volatile ListAttribute<Tournaments, Reservations> reservationsList;
    public static volatile ListAttribute<Tournaments, Matches> matchesList;
    public static volatile SingularAttribute<Tournaments, String> name;
    public static volatile ListAttribute<Tournaments, Teams> teamsList;
    public static volatile SingularAttribute<Tournaments, Integer> idTournaments;
    public static volatile SingularAttribute<Tournaments, TournamentsTypes> idTournamentsTypes;

}