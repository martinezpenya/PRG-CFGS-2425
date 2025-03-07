package es.martinezpenya.ejemplos.UD10._07_Modificacion;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.*;

public class EjemploUpdateRow {

    public static void main(String[] args) {
        String sql = "SELECT * FROM films";
        try (Connection con = HikariCPSingleton.getConnection();
             // Creamos un Statement scrollable y modificable
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             // Ejecutamos un SELECT y obtenemos la tabla films en un ResultSet
             ResultSet rs = st.executeQuery(sql);) {
            // Nos movemos al último registro y lo actualizamos
            rs.last();
            rs.updateString(3, "Return Of The Jedi"); // Ponemos todas las palabras en mayúsculas
            rs.updateRow();
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}