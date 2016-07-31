package theater.cooltheater.pojo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-31T13:23:38")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Date> duration;
    public static volatile SingularAttribute<Movie, String> mpaa;
    public static volatile SingularAttribute<Movie, Integer> rating;
    public static volatile SingularAttribute<Movie, String> description;
    public static volatile SingularAttribute<Movie, Integer> id;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile SingularAttribute<Movie, Integer> releaseYear;

}