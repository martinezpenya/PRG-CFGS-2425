package es.martinezpenya.ejemplos.UD10._03_Patrones._02_DAO;

public interface UsuarioDAO {
    void agregarUsuario(Usuario usuario);

    Usuario obtenerUsuario(int id);

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(int id);
}