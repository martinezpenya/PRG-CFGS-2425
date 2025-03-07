package es.martinezpenya.ejemplos.UD10._09_Borrado;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.*;

public class EjemploDeleteRow {

    public static void main(String[] args) {
        String sql = "SELECT * FROM films";
        try (Connection con = HikariCPSingleton.getConnection();
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = st.executeQuery(sql);) {
            // Desplazamos el cursor al tercer registro
            rs.absolute(3);
            rs.deleteRow();
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}