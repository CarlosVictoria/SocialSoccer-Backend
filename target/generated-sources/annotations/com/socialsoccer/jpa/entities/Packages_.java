package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.PackagesHasUsers;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-15T19:36:58")
@StaticMetamodel(Packages.class)
public class Packages_ { 

    public static volatile SingularAttribute<Packages, Double> price;
    public static volatile SingularAttribute<Packages, String> description;
    public static volatile ListAttribute<Packages, PackagesHasUsers> packagesHasUsersList;
    public static volatile SingularAttribute<Packages, Integer> idPackages;

}