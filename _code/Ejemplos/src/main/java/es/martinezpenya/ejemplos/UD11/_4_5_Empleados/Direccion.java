package es.martinezpenya.ejemplos.UD11._4_5_Empleados;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Direccion {
    private String poblacion;
    private String pais;

    public Direccion(String poblacion, String pais) {
        this.poblacion = poblacion;
        this.pais = pais;
    }

    public Direccion() {

    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "poblacion='" + poblacion + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
