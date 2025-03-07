package es.martinezpenya.ejemplos.UD10.starwars;

import java.sql.*;
import java.util.ArrayList;

public class FilmDAO implements DAO<Film> {
    private static final String INSERT_QUERY = "INSERT INTO films (id, episode, title) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM films WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM films";
    private static final String UPDATE_QUERY = "UPDATE films SET episode = ?, title = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM films WHERE id = ?";
    private Connection con;

    public FilmDAO () {
        try {
            con = DBConnect.getConnection();
        } catch (SQLException e) {
            System.out.println("ERROR al conectar: " + e.getMessage());
        }
    }

    @Override
    public void crear(Film film) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, film.getId());
            pst.setString(2, film.getEpisode());
            pst.setString(3, film.getTitle());

            int filasInsertadas = pst.executeUpdate();
            if (filasInsertadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    film.setId(id);
                }
            }
        }
    }

    @Override
    public Film obtener(int id) throws SQLException {
        Film usuario = null;
        try (PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int idDevuelto = rs.getInt("id");
                String episode = rs.getString("episode");
                String title = rs.getString("title");
                usuario = new Film(id, episode, title);
            }
        }
        return usuario;
    }

    @Override
    public ArrayList<Film> obtenerTodos() throws SQLException {
        ArrayList<Film> films = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_QUERY)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String episode = rs.getString("episode");
                String title = rs.getString("title");
                Film film = new Film(id, episode, title);
                films.add(film);
            }
        }
        return films;
    }

    @Override
    public void actualizar(Film usuario) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)) {
            pst.setString(1, usuario.getEpisode());
            pst.setString(2, usuario.getTitle());
            pst.setInt(3, usuario.getId());
            pst.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(DELETE_QUERY)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}