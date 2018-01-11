package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Departments;
import com.socialsoccer.jpa.entities.Headquarters;
import com.socialsoccer.jpa.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-09T19:19:58")
@StaticMetamodel(Cities.class)
public class Cities_ { 

    public static volatile ListAttribute<Cities, Users> usersList;
    public static volatile ListAttribute<Cities, Headquarters> headquartersList;
    public static volatile SingularAttribute<Cities, String> cityCode;
    public static volatile SingularAttribute<Cities, String> name;
    public static volatile SingularAttribute<Cities, Integer> idCities;
    public static volatile SingularAttribute<Cities, Departments> idDepartment;

}