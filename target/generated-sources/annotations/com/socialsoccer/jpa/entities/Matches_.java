package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Teams;
import com.socialsoccer.jpa.entities.Tournaments;
import com.socialsoccer.jpa.entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T08:16:18")
@StaticMetamodel(Matches.class)
public class Matches_ { 

    public static volatile SingularAttribute<Matches, Date> date;
    public static volatile ListAttribute<Matches, Users> usersList;
    public static volatile SingularAttribute<Matches, Integer> idMatches;
    public static volatile SingularAttribute<Matches, Teams> idTeam2;
    public static volatile SingularAttribute<Matches, Teams> idTeam1;
    public static volatile SingularAttribute<Matches, Tournaments> idTournaments;
    public static volatile SingularAttribute<Matches, Integer> goalsTeam1;
    public static volatile SingularAttribute<Matches, Integer> goalsTeam2;
    public static volatile SingularAttribute<Matches, String> results;

}