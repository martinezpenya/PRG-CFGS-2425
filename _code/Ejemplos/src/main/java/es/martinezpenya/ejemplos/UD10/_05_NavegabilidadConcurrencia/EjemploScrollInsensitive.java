package es.martinezpenya.ejemplos.UD10._05_NavegabilidadConcurrencia;

import java.sql.*;

public class EjemploScrollInsensitive {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pr_tuNombre";
    private static final String USUARIO = "pr_tuNombre";
    private static final String PASSWD = "1234";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(JDBC_URL, USUARIO, PASSWD);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT id, nombre FROM usuarios")) {

            // Mover a la primera fila
            if (rs.first()) {
                System.out.println("primera fila: " + rs.getInt("id") + ", " + rs.getString("nombre"));
            }

            // Mover a la última fila
            if (rs.last()) {
                System.out.println("última fila: " + rs.getInt("id") + ", " + rs.getString("nombre"));
            }

            // Simulamos un retraso y actualizamos la base de datos (en otra sesión)
            System.out.println("Esperando las actualizaciones...");
            Thread.sleep(10000); // Esperar 10 segundos

            // Mover a la primera fila otra vez
            if (rs.first()) {
                System.out.println("primera fila después de esperar: " + rs.getInt("id") + ", " + rs.getString("nombre"));
            }

        } catch (SQLException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
