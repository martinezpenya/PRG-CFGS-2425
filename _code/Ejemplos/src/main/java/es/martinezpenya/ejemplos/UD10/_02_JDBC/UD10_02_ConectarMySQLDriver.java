package es.martinezpenya.ejemplos.UD10._02_JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UD10_02_ConectarMySQLDriver {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/prueba";
        String username = "prueba";
        String password = "1234";

        try {
            Driver driver = DriverManager.getDriver(url);

            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);

            Connection con = driver.connect(url, properties);
            System.out.println("Conexión completada a través de Driver");
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR al conectar: " + ex.getMessage());
        }
    }
}