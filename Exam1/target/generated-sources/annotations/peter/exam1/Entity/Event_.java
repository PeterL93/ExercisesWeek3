package peter.exam1.Entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import peter.exam1.Entity.Pet;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-08T09:27:18")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Date> date;
    public static volatile SingularAttribute<Event, Pet> petId;
    public static volatile SingularAttribute<Event, String> remark;
    public static volatile SingularAttribute<Event, Integer> id;
    public static volatile SingularAttribute<Event, String> event;

}