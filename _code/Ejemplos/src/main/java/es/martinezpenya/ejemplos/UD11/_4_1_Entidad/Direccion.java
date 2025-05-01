package es.martinezpenya.ejemplos.UD11._4_1_Entidad;

import javax.persistence.*;

@Embeddable
public class Direccion {
    protected String calle;
    protected String ciudad;
    protected String pais;
    protected String codPostal;
}