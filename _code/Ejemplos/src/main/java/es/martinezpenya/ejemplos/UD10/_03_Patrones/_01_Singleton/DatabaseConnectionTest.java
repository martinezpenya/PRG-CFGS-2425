package es.martinezpenya.ejemplos.UD10._03_Patrones._01_Singleton;

import java.sql.Connection;

public class DatabaseConnectionTest {
    public class Main {
        public static void main(String[] args) {
            // Obtenemos la instancia única de DatabaseConnection
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();

            // Usamos la conexión para interactuar con la base de datos
            Connection connection = dbConnection.getConnection();
            // Aquí podríamos ejecutar consultas SQL, por ejemplo:
            // Statement statement = connection.createStatement();
            // ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");

            // Cerramos la conexión cuando ya no la necesitemos
            dbConnection.closeConnection();
        }
    }
}
