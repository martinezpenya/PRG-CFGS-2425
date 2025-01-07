package es.martinezpenya.ejemplos.UD10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UD10_01_ConectarMySQL {
    public static void main(String[] av) {
        try {
            // Dependiendo de a qué tipo de SGBD queramos conectar cargaremos un controlador u otro
            // Intentar cargar el driver de MySQL
            Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Cargado " + c.getName());

            //Definir la url de conexión y los parámetros de usuario y contraseña
            String host = "jdbc:mysql://localhost:3306/prueba";
            String username = "prueba";
            String password = "1234";
            Connection con = DriverManager.getConnection(host, username, password);

            System.out.println("Conexión completada");
            con.close();
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERROR al conectar: " + ex.getMessage());
        }
    }
}
