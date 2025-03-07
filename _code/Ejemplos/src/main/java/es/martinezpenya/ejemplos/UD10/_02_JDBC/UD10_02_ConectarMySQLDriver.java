package es.martinezpenya.ejemplos.UD10._02_JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UD10_02_ConectarMySQLDriver {
    public static void main(String[] args) {
        //Definir la url de conexión y los parámetros de usuario y contraseña
        String url = "jdbc:mysql://databasedmp.cipxbdkxiaqy.us-east-1.rds.amazonaws.com:3306/starwars";
        String username = "admin";
        String password = "123456Ab$";

        try {
            Driver driver = DriverManager.getDriver(url);
            //Establecer las propiedades de la conexión
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            //Conectar
            Connection con = driver.connect(url, properties);
            System.out.println("Conexión completada a través de Driver");
            //Cerrar la conexión
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR al conectar: " + ex.getMessage());
        }
    }
}