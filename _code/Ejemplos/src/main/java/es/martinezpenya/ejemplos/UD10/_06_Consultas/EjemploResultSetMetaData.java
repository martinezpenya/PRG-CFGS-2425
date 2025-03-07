package es.martinezpenya.ejemplos.UD10._06_Consultas;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.*;

public class EjemploResultSetMetaData {
    public static void main(String[] args) {
        try (Connection con = HikariCPSingleton.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, episode, title FROM films")) {

            // Obtener metadata del ResulSet
            ResultSetMetaData rsmd = rs.getMetaData();

            // Obtener el número de columnas
            int columnCount = rsmd.getColumnCount();
            System.out.println("Número de columnas: " + columnCount);

            // Listar las columnas de detalles
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                String columnType = rsmd.getColumnTypeName(i);
                int columnDisplaySize = rsmd.getColumnDisplaySize(i);
                boolean isNullable = rsmd.isNullable(i) == ResultSetMetaData.columnNullable;

                System.out.println("Columna " + i + ":");
                System.out.println("  Nombre: " + columnName);
                System.out.println("  Tipo: " + columnType);
                System.out.println("  Tamaño display: " + columnDisplaySize);
                System.out.println("  Nullable: " + isNullable);
            }

            // Iterar sobre el conjunto de resultados
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}