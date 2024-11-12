package es.martinezpenya.ejemplos.UD10._10_Predefinidas;

import es.martinezpenya.ejemplos.UD10._03_Patrones._01_Singleton.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploInsercionPredefinidas {
    static Connection con;

    static {
        Singleton.getInstance();
        con = Singleton.getConnection();
    }

    public static void insertUserPredefinidas(String nombre, String apellidos) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO usuarios (nombre, apellidos) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error al insertar el usuario. Mensaje: " + e.getMessage());
        } finally {
            try {
                //Siempre se debe cerrar todo lo abierta
                if (pst != null) {
                    pst.close();
                }
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error. Mensaje: " + ex.getMessage());
            }
        }
    }

    public static void deleteUserPredefinidas(int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);

            // Establecer valor de parámetro `?`
            pst.setInt(1, id);

            // Ejecutar la consulta
            int filasAfectadas = pst.executeUpdate();

            // Comprobar cuántas filas fueron afectadas
            if (filasAfectadas > 0) {
                System.out.println("Fila borrada correctamente.");
            } else {
                System.out.println("No se encontró ninguna fila con ese id.");
            }
        } catch (SQLException ex) {
            System.out.println("Se ha producido un error al eliminar el usuario. Mensaje: " + ex.getMessage());
        } finally {
            try {
                //Siempre se debe cerrar todo lo abierta
                if (pst != null) {
                    pst.close();
                }
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error. Mensaje: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        insertUserPredefinidas("David", "Martínez");
        deleteUserPredefinidas(3);
    }
}
