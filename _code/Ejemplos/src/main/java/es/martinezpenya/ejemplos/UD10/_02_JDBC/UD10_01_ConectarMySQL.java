package es.martinezpenya.ejemplos.UD10._02_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UD10_01_ConectarMySQL {
    public static void main(String[] args) {
        try {
            // Dependiendo de a qué tipo de SGBD queramos conectar cargaremos un controlador u otro
            // Intentar cargar el driver de MySQL
            Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Cargado " + c.getName());

            //Definir la url de conexión y los parámetros de usuario y contraseña
            String host = "jdbc:mysql://databasedmp.cipxbdkxiaqy.us-east-1.rds.amazonaws.com:3306/starwars";
            String username = "admin";
            String password = "123456Ab$";
            Connection con = DriverManager.getConnection(host, username, password);

            System.out.println("Conexión completada");
            //cerrar la conexión
            con.close();
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERROR al conectar: " + ex.getMessage());
        }
    }
}
