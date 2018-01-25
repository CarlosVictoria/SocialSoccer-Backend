package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Headquarters;
import com.socialsoccer.jpa.entities.Reservations;
import com.socialsoccer.jpa.entities.SoccerFieldTypes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-25T18:38:51")
@StaticMetamodel(SoccerFields.class)
public class SoccerFields_ { 

    public static volatile SingularAttribute<SoccerFields, Integer> idSoccerFields;
    public static volatile ListAttribute<SoccerFields, Reservations> reservationsList;
    public static volatile SingularAttribute<SoccerFields, SoccerFieldTypes> idSoccerFieldsTypes;
    public static volatile SingularAttribute<SoccerFields, Headquarters> idHeadquarters;
    public static volatile SingularAttribute<SoccerFields, Boolean> avaliable;
    public static volatile SingularAttribute<SoccerFields, String> name;

}