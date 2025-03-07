package es.martinezpenya.ejemplos.UD10._10_Predefinidas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

public class EjemploInsercionBorradoConPreparedStatement {

    public static void insertFilmPrepared(int id, String episode, String title) {
        String sql = "INSERT INTO films (id, episode, title) VALUES (?,?,?)";
        try (Connection con = HikariCPSingleton.getConnection(); // Obtener conexión del pool
             PreparedStatement pst = con.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros
            pst.setInt(1, id);
            pst.setString(2, episode);
            pst.setString(3, title);
            // Ejecutamos la sentencia preparada sin peligro de SQL Injection
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al insertar el film. Mensaje: " + e.getMessage());
        }
    }

    public static void deleteFilmPrepared(int id) {
        String sql = "DELETE FROM films WHERE id = ?";
        try (Connection con = HikariCPSingleton.getConnection(); // Obtener conexión del pool
             PreparedStatement pst = con.prepareStatement(sql)) {
            // Asignamos el valor al parámetro
            pst.setInt(1, id);
            // Ejecutamos la sentencia preparada sin peligro de SQL Injection
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al borrar el film. Mensaje: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        insertFilmPrepared(8, "Episode VIII", "The last Jedi");
        Scanner sc = new Scanner(System.in);
        System.out.println("Pausa, pulsa ENTER para borrar el film introducido....");
        sc.nextLine();
        deleteFilmPrepared(8);
    }
}