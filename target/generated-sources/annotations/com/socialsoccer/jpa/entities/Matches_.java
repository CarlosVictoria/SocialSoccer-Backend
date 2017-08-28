package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Teams;
import com.socialsoccer.jpa.entities.Tournaments;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T13:22:37")
@StaticMetamodel(Matches.class)
public class Matches_ { 

    public static volatile SingularAttribute<Matches, Date> date;
    public static volatile SingularAttribute<Matches, Integer> idMatches;
    public static volatile SingularAttribute<Matches, String> judgeName;
    public static volatile SingularAttribute<Matches, Teams> idTeam2;
    public static volatile SingularAttribute<Matches, Teams> idTeam1;
    public static volatile SingularAttribute<Matches, Tournaments> idTournaments;
    public static volatile SingularAttribute<Matches, Integer> goalsTeam1;
    public static volatile SingularAttribute<Matches, Integer> goalsTeam2;

}