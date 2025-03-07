package es.martinezpenya.ejemplos.UD10._03_Patrones._03_DAO;

import es.martinezpenya.ejemplos.UD10._03_Patrones._02_PoolObject.HikariCPSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmDAOImplementado implements FilmDAO {

    private Connection connection;

    public FilmDAOImplementado() {
        try {
            connection = HikariCPSingleton.getConnection();
        } catch (SQLException e) {
            System.out.println("ERROR al conectar: " + e.getMessage());
        }
    }

    @Override
    public void agregarFilm(Film film) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO films (id, episode, title) VALUES (?,?,?)");
            ps.setInt(1, film.getId());
            ps.setString(2, film.getEpisode());
            ps.setString(3, film.getTitle());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film obtenerFilm(int id) {
        Film film = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM films WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                film = new Film();
                film.setId(rs.getInt("id"));
                film.setEpisode(rs.getString("episode"));
                film.setTitle(rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public void actualizarFilm(Film film) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE films SET episode = ?, title = ? WHERE id = ?");
            ps.setString(1, film.getEpisode());
            ps.setString(2, film.getTitle());
            ps.setInt(3, film.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarFilm(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM films WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}