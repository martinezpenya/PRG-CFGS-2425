package es.martinezpenya.ejemplos.UD10._08_Insercion;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.*;

public class EjemploInsercionConSQL {

    public static void insertFilmFijo(){
        String sql = "INSERT INTO films (id, episode, title) VALUES (7, 'Episode VII', 'The force awakens')";
        try (Connection con = HikariCPSingleton.getConnection();
             // Creamos un Statement scrollable y modificable
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             // Ejecutamos un SELECT y obtenemos la tabla films en un ResultSet
             ResultSet rs = st.executeQuery(sql);) {
        } catch (SQLException ex) {
            System.out.println("ERROR al insertar el film: " + ex.getMessage());
        }
    }

    public static void insertFilmParametros(int id, String episode, String title){
        // OJO!! Forma no recomendada por problemas de seguridad (SQL Injection)
        String sql = "INSERT INTO films (id, episode, title) VALUES (" + id + ", '" + episode + "', '" + title + "')";
        try (Connection con = HikariCPSingleton.getConnection();
             // Creamos un Statement scrollable y modificable
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             // Ejecutamos un SELECT y obtenemos la tabla films en un ResultSet
             ResultSet rs = st.executeQuery(sql);) {
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al insertar el film. Mensaje: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        insertFilmFijo();
        insertFilmParametros(8, "Episode VIII", "The last Jedi");
    }
}