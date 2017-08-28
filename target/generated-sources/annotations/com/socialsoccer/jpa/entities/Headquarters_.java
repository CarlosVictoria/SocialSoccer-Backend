package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Cities;
import com.socialsoccer.jpa.entities.Headquarters;
import com.socialsoccer.jpa.entities.SoccerFields;
import com.socialsoccer.jpa.entities.Tournaments;
import com.socialsoccer.jpa.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T13:22:37")
@StaticMetamodel(Headquarters.class)
public class Headquarters_ { 

    public static volatile SingularAttribute<Headquarters, String> address;
    public static volatile ListAttribute<Headquarters, Headquarters> headquartersList;
    public static volatile ListAttribute<Headquarters, SoccerFields> soccerFieldsList;
    public static volatile SingularAttribute<Headquarters, Integer> idHeadquarters;
    public static volatile SingularAttribute<Headquarters, String> telephone;
    public static volatile ListAttribute<Headquarters, Tournaments> tournamentsList;
    public static volatile SingularAttribute<Headquarters, String> nit;
    public static volatile SingularAttribute<Headquarters, String> name;
    public static volatile SingularAttribute<Headquarters, Boolean> mainHeadquarter;
    public static volatile SingularAttribute<Headquarters, Cities> idCities;
    public static volatile SingularAttribute<Headquarters, Users> idUsers;
    public static volatile SingularAttribute<Headquarters, Headquarters> idMainHeadquarter;
    public static volatile SingularAttribute<Headquarters, Integer> numSoccerFields;

}