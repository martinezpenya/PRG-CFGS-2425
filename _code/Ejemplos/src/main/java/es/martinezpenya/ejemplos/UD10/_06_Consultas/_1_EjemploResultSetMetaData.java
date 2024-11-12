package es.martinezpenya.ejemplos.UD10._06_Consultas;

import java.sql.*;

public class _1_EjemploResultSetMetaData {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pr_tuNombre";
    private static final String USUARIO = "pr_tuNombre";
    private static final String PASSWD = "1234";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(JDBC_URL, USUARIO, PASSWD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, nombre, fecha_ingreso, salario FROM proveedores")) {

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
