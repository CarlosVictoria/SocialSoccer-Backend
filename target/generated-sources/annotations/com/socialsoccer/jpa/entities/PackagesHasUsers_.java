package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Packages;
import com.socialsoccer.jpa.entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-23T19:45:31")
@StaticMetamodel(PackagesHasUsers.class)
public class PackagesHasUsers_ { 

    public static volatile SingularAttribute<PackagesHasUsers, Date> finalDate;
    public static volatile SingularAttribute<PackagesHasUsers, Integer> idPackagesHasUsers;
    public static volatile SingularAttribute<PackagesHasUsers, Users> idUsers;
    public static volatile SingularAttribute<PackagesHasUsers, Date> initialDate;
    public static volatile SingularAttribute<PackagesHasUsers, Packages> idPackages;

}