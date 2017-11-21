package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Establishments;
import com.socialsoccer.jpa.entities.Headquarters;
import com.socialsoccer.jpa.entities.Matches;
import com.socialsoccer.jpa.entities.PlayersTeamsTournaments;
import com.socialsoccer.jpa.entities.Reservations;
import com.socialsoccer.jpa.entities.TournamentsTypes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-21T11:57:59")
@StaticMetamodel(Tournaments.class)
public class Tournaments_ { 

    public static volatile SingularAttribute<Tournaments, Date> finalDate;
    public static volatile ListAttribute<Tournaments, Establishments> establishmentsList;
    public static volatile ListAttribute<Tournaments, Headquarters> headquartersList;
    public static volatile ListAttribute<Tournaments, Reservations> reservationsList;
    public static volatile ListAttribute<Tournaments, Matches> matchesList;
    public static volatile SingularAttribute<Tournaments, String> name;
    public static volatile SingularAttribute<Tournaments, Integer> idTournaments;
    public static volatile SingularAttribute<Tournaments, TournamentsTypes> idTournamentsTypes;
    public static volatile SingularAttribute<Tournaments, Date> initialDate;
    public static volatile ListAttribute<Tournaments, PlayersTeamsTournaments> playersTeamsTournamentsList;

}