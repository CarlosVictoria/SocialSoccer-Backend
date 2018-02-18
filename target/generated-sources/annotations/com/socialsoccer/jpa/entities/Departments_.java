package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Cities;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-15T19:36:58")
@StaticMetamodel(Departments.class)
public class Departments_ { 

    public static volatile SingularAttribute<Departments, Integer> idDepartments;
    public static volatile ListAttribute<Departments, Cities> citiesList;
    public static volatile SingularAttribute<Departments, String> departmentCode;
    public static volatile SingularAttribute<Departments, String> name;

}