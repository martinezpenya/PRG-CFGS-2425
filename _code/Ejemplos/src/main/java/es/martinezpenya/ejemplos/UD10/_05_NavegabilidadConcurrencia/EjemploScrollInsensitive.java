package es.martinezpenya.ejemplos.UD10._05_NavegabilidadConcurrencia;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.*;

public class EjemploScrollInsensitive {

    public static void main(String[] args) {
        try (Connection con = HikariCPSingleton.getConnection();
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("SELECT id, name FROM characters")) {

            // Mover a la primera fila
            if (rs.first()) {
                System.out.println("primera fila: " + rs.getInt("id") + ", " + rs.getString("name"));
            }

            // Mover a la última fila
            if (rs.last()) {
                System.out.println("última fila: " + rs.getInt("id") + ", " + rs.getString("name"));
            }

            // Simulamos un retraso y actualizamos la base de datos (en otra sesión)
            System.out.println("Esperando las actualizaciones...");
            Thread.sleep(20000); // Esperar 10 segundos

            // Mover a la primera fila otra vez
            if (rs.first()) {
                System.out.println("primera fila después de esperar: " + rs.getInt("id") + ", " + rs.getString("name"));
            }

        } catch (SQLException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
