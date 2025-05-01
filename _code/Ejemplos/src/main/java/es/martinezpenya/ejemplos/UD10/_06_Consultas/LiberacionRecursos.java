package es.martinezpenya.ejemplos.UD10._06_Consultas;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LiberacionRecursos {
    static Statement stmt = null;
    static ResultSet rs = null;
    static Connection con;

    public static void main(String[] args) {
        try {
            con = HikariCPSingleton.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT id, name, hair_color FROM characters");

            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        } finally {
            try {
                //Siempre se debe cerrar todo lo abierto
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
            try {
                //Siempre se debe cerrar todo lo abierto
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }
}