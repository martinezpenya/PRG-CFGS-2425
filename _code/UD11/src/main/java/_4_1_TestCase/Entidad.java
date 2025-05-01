package _0_TestCase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Entidad {

    // Date Only:
    java.sql.Date date1;
    @Temporal(TemporalType.DATE) java.util.Date date2;
    @Temporal(TemporalType.DATE) java.util.Calendar date3;

    // Time Only:
    java.sql.Time time1;
    @Temporal(TemporalType.TIME) java.util.Date time2;
    @Temporal(TemporalType.TIME) java.util.Calendar time3;

    // Date and Time:
    java.sql.Timestamp dateAndTime1;
    @Temporal(TemporalType.TIMESTAMP) java.util.Date dateAndTime2;
    @Temporal(TemporalType.TIMESTAMP) java.util.Calendar dateAndTime3;
    java.util.Date dateAndTime4; // date and time, not JPA portable
    java.util.Calendar dateAndTime5; // date and time, not JPA portable

    private List<String> words = Arrays.asList("not", "ArrayList");

    static int transient1; // no persistente por ser estático
    final int transient2 = 0; // no persistente por ser final
    transient int transient3; // no persistente por ser transient
    @Transient int transient4; // no persistente por el uso de la etiqueta @Transient

    @Basic(optional=false) Integer campo1;
    @OneToOne(cascade=CascadeType.ALL) Entidad campo2;
    @OneToMany(fetch=FetchType.EAGER) ArrayList<Entidad> campo3;

    @Version long version; //

    @Id @GeneratedValue long id; // Es generado por ObjectDB
    private String name;

    public Entidad(String name, Integer campo1) {
        this.name = name;
        this.campo1=campo1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + campo1;
    }
}