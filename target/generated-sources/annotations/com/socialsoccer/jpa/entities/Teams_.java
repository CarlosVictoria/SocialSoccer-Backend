package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Matches;
import com.socialsoccer.jpa.entities.Tournaments;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T13:22:37")
@StaticMetamodel(Teams.class)
public class Teams_ { 

    public static volatile ListAttribute<Teams, Matches> matchesList;
    public static volatile ListAttribute<Teams, Matches> matchesList1;
    public static volatile ListAttribute<Teams, Tournaments> tournamentsList;
    public static volatile SingularAttribute<Teams, String> name;
    public static volatile SingularAttribute<Teams, Integer> idTeams;

}