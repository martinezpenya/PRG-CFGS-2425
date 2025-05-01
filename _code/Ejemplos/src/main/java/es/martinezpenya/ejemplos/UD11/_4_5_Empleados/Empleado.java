package es.martinezpenya.ejemplos.UD11._4_5_Empleados;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Empleado {

    private String nombre;
    private String apellido1;
    private String apellido2;
    @Embedded private Direccion direccion;
    @ManyToOne(fetch=FetchType.LAZY)
    private Empleado gerente;
    @ManyToMany(fetch=FetchType.EAGER)
    private ArrayList<Proyecto> proyectos;

    public Empleado(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Empleado getGerente() {
        return gerente;
    }

    public void setGerente(Empleado gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1 + " " + apellido2 + " " + direccion;
    }
}