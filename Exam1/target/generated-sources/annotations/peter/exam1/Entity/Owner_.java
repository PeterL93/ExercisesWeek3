package peter.exam1.Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import peter.exam1.Entity.Pet;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-08T09:27:18")
@StaticMetamodel(Owner.class)
public class Owner_ { 

    public static volatile SingularAttribute<Owner, String> firstName;
    public static volatile SingularAttribute<Owner, String> lastName;
    public static volatile SingularAttribute<Owner, String> address;
    public static volatile SingularAttribute<Owner, Integer> id;
    public static volatile CollectionAttribute<Owner, Pet> petCollection;

}