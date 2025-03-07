package es.martinezpenya.ejemplos.UD10._06_Consultas;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LiberacionRecursosTryWithResources {
    public static void main(String[] args) {
        try (Connection con = HikariCPSingleton.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, hair_color FROM characters");) {

            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}