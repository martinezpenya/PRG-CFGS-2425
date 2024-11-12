package es.martinezpenya.ejemplos.UD10._03_Patrones._02_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImplementado implements UsuarioDAO {

    private Connection connection;

    public UsuarioDAOImplementado() {
        String host = "jdbc:mysql://localhost:3306/prueba";
        String username = "prueba";
        String password = "1234";
        try {
            connection = java.sql.DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            System.out.println("ERROR al conectar: " + e.getMessage());
        }
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO usuarios (nombre, email) VALUES (?, ?)");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuario(int id) {
        Usuario usuario = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}