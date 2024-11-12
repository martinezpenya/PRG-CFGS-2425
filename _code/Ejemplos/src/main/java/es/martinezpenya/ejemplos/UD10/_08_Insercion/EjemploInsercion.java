package es.martinezpenya.ejemplos.UD10._08_Insercion;

import es.martinezpenya.ejemplos.UD10._03_Patrones._01_Singleton.Singleton;

import java.sql.*;

public class EjemploInsercion {
    static java.sql.Connection con = Singleton.getInstance().getConnection();

    public static void insertUserFijo(){
        Statement st = null;
        String sql = "INSERT INTO estudiantes (nombre, promedio) VALUES ('Luís', 6.8)";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("ERROR al insertar el usuario: " + ex.getMessage());
        } finally {
            try{
                //Siempre se debe cerrar todo lo abierto
                if (st != null) {
                    st.close();
                }
            } catch(java.sql.SQLException ex){
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }
    public static void insertUserParametros(String nombre, String apellidos){
        Statement st = null;
        String sql = "INSERT INTO usuarios (nombre, apellidos) VALUES ('" + nombre + "', '" + apellidos + "')";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al insertar el usuario. Mensaje: " + e.getMessage());
        } finally {
            try{
                //Siempre se debe cerrar todo lo abierta
                if (st != null) {
                    st.close();
                }
            } catch(java.sql.SQLException ex){
                System.out.println("Se ha producido un error. Mensaje: " + ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        insertUserFijo();
        insertUserParametros("David", "Martínez");
    }
}
