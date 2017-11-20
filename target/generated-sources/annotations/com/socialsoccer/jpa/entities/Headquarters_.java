package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Cities;
import com.socialsoccer.jpa.entities.Establishments;
import com.socialsoccer.jpa.entities.SoccerFields;
import com.socialsoccer.jpa.entities.Tournaments;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T08:16:18")
@StaticMetamodel(Headquarters.class)
public class Headquarters_ { 

    public static volatile SingularAttribute<Headquarters, String> numHeadquarters;
    public static volatile SingularAttribute<Headquarters, String> address;
    public static volatile ListAttribute<Headquarters, SoccerFields> soccerFieldsList;
    public static volatile SingularAttribute<Headquarters, Integer> idHeadquarters;
    public static volatile ListAttribute<Headquarters, Tournaments> tournamentsList;
    public static volatile SingularAttribute<Headquarters, Establishments> idEstablishments;
    public static volatile SingularAttribute<Headquarters, Cities> idCities;
    public static volatile SingularAttribute<Headquarters, String> telephone;
    public static volatile SingularAttribute<Headquarters, Integer> numSoccerFields;

}