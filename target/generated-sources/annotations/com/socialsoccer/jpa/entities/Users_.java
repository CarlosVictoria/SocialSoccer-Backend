package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Cities;
import com.socialsoccer.jpa.entities.DocumentTypes;
import com.socialsoccer.jpa.entities.Establishments;
import com.socialsoccer.jpa.entities.Matches;
import com.socialsoccer.jpa.entities.PackagesHasUsers;
import com.socialsoccer.jpa.entities.PlayersTeamsTournaments;
import com.socialsoccer.jpa.entities.Reservations;
import com.socialsoccer.jpa.entities.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-09T19:19:58")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> gender;
    public static volatile SingularAttribute<Users, Boolean> active;
    public static volatile SingularAttribute<Users, String> photo;
    public static volatile SingularAttribute<Users, String> imagen;
    public static volatile SingularAttribute<Users, DocumentTypes> idDocumentTypes;
    public static volatile SingularAttribute<Users, String> numDocument;
    public static volatile ListAttribute<Users, PlayersTeamsTournaments> playersTeamsTournamentsList;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile ListAttribute<Users, Establishments> establishmentsList;
    public static volatile SingularAttribute<Users, String> names;
    public static volatile ListAttribute<Users, Roles> rolesList;
    public static volatile ListAttribute<Users, Reservations> reservationsList;
    public static volatile ListAttribute<Users, Matches> matchesList;
    public static volatile SingularAttribute<Users, Cities> idCities;
    public static volatile SingularAttribute<Users, String> lastNames;
    public static volatile SingularAttribute<Users, Integer> idUsers;
    public static volatile ListAttribute<Users, PackagesHasUsers> packagesHasUsersList;
    public static volatile SingularAttribute<Users, String> email;

}