package es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPSingletonTest {

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connection = HikariCPSingleton.getConnection();
            // Hacemos algo con la conexión
        } catch (SQLException e) {
            System.out.println("ERROR al conectar: " + e.getMessage());
        }
    }
}
