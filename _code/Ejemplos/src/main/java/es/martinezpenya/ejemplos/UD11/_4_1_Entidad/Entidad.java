package es.martinezpenya.ejemplos.UD11._4_1_Entidad;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Entidad {

    // Fecha:
    java.sql.Date date1;
    @Temporal(TemporalType.DATE) java.util.Date date2;
    @Temporal(TemporalType.DATE) java.util.Calendar date3;

    // Hora:
    java.sql.Time time1;
    @Temporal(TemporalType.TIME) java.util.Date time2;
    @Temporal(TemporalType.TIME) java.util.Calendar time3;

    // Fecha y hora:
    java.sql.Timestamp dateAndTime1;
    @Temporal(TemporalType.TIMESTAMP) java.util.Date dateAndTime2;
    @Temporal(TemporalType.TIMESTAMP) java.util.Calendar dateAndTime3;
    java.util.Date dateAndTime4; // fecha y hora, no compatible con JPA
    java.util.Calendar dateAndTime5; // fecha y hora, no compatible con JPA

    private List<String> palabras = Arrays.asList("casa", "manzana", "perro", "gato");

    static int transient1; // no persistente por ser estático
    final int transient2 = 0; // no persistente por ser final
    transient int transient3; // no persistente por ser transient
    @Transient int transient4; // no persistente por el uso de la etiqueta @Transient

    @Basic(optional=false) Integer campo1;
    @OneToOne(cascade=CascadeType.ALL) Entidad campo2;
    @OneToMany(fetch=FetchType.EAGER) ArrayList<Entidad> campo3;

    @Embedded Direccion direccion;

    @Version long version;

    @Id @GeneratedValue long id; // Es generado por ObjectDB

    @Id long id2; // Es generado por la aplicación

    private String name;

    public Entidad(String name, Integer campo1) {
        this.name = name;
        this.campo1=campo1;
        //....
    }

    public Entidad() {
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