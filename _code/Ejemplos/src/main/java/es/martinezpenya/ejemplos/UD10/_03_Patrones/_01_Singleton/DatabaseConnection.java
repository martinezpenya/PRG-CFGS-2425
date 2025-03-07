package es.martinezpenya.ejemplos.UD10._03_Patrones._01_Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // 1. Declaramos una instancia estática y privada de la clase
    private static DatabaseConnection instance;
    private Connection connection;

    // 2. Hacemos el constructor privado para evitar que se creen instancias desde fuera
    private DatabaseConnection() {
        try {
            // Establecemos la conexión a la base de datos
            String url = "jdbc:mysql://databasedmp.cipxbdkxiaqy.us-east-1.rds.amazonaws.com:3306/starwars";
            String user = "admin";
            String password = "123456Ab$";
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // 3. Método estático para obtener la instancia única (Singleton)
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // 4. Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }

    // 5. Método para cerrar la conexión (opcional)
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}