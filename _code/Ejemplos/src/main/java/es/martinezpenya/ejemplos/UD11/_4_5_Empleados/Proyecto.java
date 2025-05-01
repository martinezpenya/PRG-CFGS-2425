package es.martinezpenya.ejemplos.UD11._4_5_Empleados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String descripcion;
    private int horasEstimadas;
    private int horasReales;


    public Proyecto(String nombre, String descripcion, int horasEstimadas, int horasReales) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasEstimadas = horasEstimadas;
        this.horasReales = horasReales;
    }

    public Proyecto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public int getHorasReales() {
        return horasReales;
    }

    public void setHorasReales(int horasReales) {
        this.horasReales = horasReales;
    }
}
