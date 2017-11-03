package com.socialsoccer.jpa.entities;

import com.socialsoccer.jpa.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-02T18:02:14")
@StaticMetamodel(DocumentTypes.class)
public class DocumentTypes_ { 

    public static volatile ListAttribute<DocumentTypes, Users> usersList;
    public static volatile SingularAttribute<DocumentTypes, String> description;
    public static volatile SingularAttribute<DocumentTypes, Integer> idDocumentTypes;

}