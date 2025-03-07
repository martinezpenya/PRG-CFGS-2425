package es.martinezpenya.ejemplos.UD10._08_Insercion;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploMoveToInsertRow {
    public static void main(String[] args) {
        String sql = "SELECT * FROM films";
        try (Connection con = HikariCPSingleton.getConnection();
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = st.executeQuery(sql);) {
            // Creamos un nuevo registro y lo insertamos
            rs.moveToInsertRow();
            rs.updateInt(1, 7);
            rs.updateString(2, "Episode VII");
            rs.updateString(3, "The force awakens");
            rs.insertRow();
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}