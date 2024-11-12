package es.martinezpenya.ejemplos.UD10._06_Consultas;

import java.sql.*;

public class _2_LiberacionRecursos {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pr_tuNombre";
    private static final String USUARIO = "pr_tuNombre";
    private static final String PASSWD = "1234";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(JDBC_URL, USUARIO, PASSWD)) {
            Statement stmt = con.createStatement();
            Statement st = null;
            ResultSet rs = null;
            try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM usuarios");

                while (rs.next()) {
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println(rs.getString(3));
                }

            } catch (SQLException e) {
                System.out.println("ERROR: " + e.getMessage());

            } finally {
                try {
                    //Siempre se debe cerrar todo lo abierto
                    if (rs != null) {
                        rs.close();
                    }
                } catch (java.sql.SQLException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
                try {
                    //Siempre se debe cerrar todo lo abierto
                    if (st != null) {
                        st.close();
                    }
                } catch (java.sql.SQLException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}
