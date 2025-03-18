package es.martinezpenya.ejemplos.UD10.starwars;

import java.sql.*;
import java.util.ArrayList;

public class CharacterFilmsDAO implements DAO<CharacterFilm> {
    private static final String INSERT_QUERY = "INSERT INTO character_films (id_character, id_film) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY_BY_CHARACTER = "SELECT * FROM character_films WHERE id_character = ?";
    private static final String SELECT_ALL_QUERY_BY_FILM = "SELECT * FROM character_films WHERE id_film = ?";
    private static final String DELETE_QUERY_BY_CHARACTER = "DELETE FROM character_films WHERE id_character = ?";
    private static final String DELETE_QUERY_BY_FILM = "DELETE FROM character_films WHERE id_film = ?";
    public static final String DELETE_QUERY_BY_CHARACTER_AND_FILM = "DELETE FROM character_films WHERE id_character = ? AND id_film = ?";

    private Connection con;

    public CharacterFilmsDAO () {
        try {
            con = DBConnect.getConnection();
        } catch (SQLException e) {
            System.out.println("ERROR al conectar: " + e.getMessage());
        }
    }
    @Override
    public void crear(CharacterFilm entidad) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, entidad.getCharacter().getId());
            pst.setInt(2, entidad.getFilm().getId());

            ResultSet rs = pst.executeQuery();
        }
    }

    @Override
    public CharacterFilm obtener(int id) throws SQLException {
        //No tiene sentido en una tabla N a N
        return null;
    }

    @Override
    public ArrayList<CharacterFilm> obtenerTodos() throws SQLException {
        //No tiene sentido en una tabla N a N
        return null;
    }

    public ArrayList<CharacterFilm> obtenerTodosPorCharacter(int id_character) throws SQLException {
        ArrayList<CharacterFilm> characterFilms = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(SELECT_ALL_QUERY_BY_CHARACTER)) {
            pst.setInt(1, id_character);
            ResultSet rs = pst.executeQuery();
            CharacterDAO characterDAO = new CharacterDAO();
            Character character = characterDAO.obtener(id_character);
            FilmDAO filmDAO = new FilmDAO();
            while (rs.next()) {
                int id_film = rs.getInt("id_film");
                Film film = filmDAO.obtener(id_film);
                characterFilms.add(new CharacterFilm(character, film));
            }
        }
        return characterFilms;
    }

    public ArrayList<CharacterFilm> obtenerTodosPorFilm(int id_film) throws SQLException {
        ArrayList<CharacterFilm> characterFilms = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(SELECT_ALL_QUERY_BY_FILM)) {
            pst.setInt(1, id_film);
            ResultSet rs = pst.executeQuery();
            CharacterDAO characterDAO = new CharacterDAO();
            FilmDAO filmDAO = new FilmDAO();
            Film film = filmDAO.obtener(id_film);
            while (rs.next()) {
                int id_character = rs.getInt("id_character");
                Character character = characterDAO.obtener(id_character);
                characterFilms.add(new CharacterFilm(character, film));
            }
        }
        return characterFilms;
    }

    @Override
    public void actualizar(CharacterFilm entidad) throws SQLException {
        //No tiene sentido en una tabla N a N
    }

    @Override
    public void eliminar(int id) throws SQLException {
        //No tiene sentido en una tabla N a N
    }

    public void eliminarPorCharacterYFilm(int idCharacter, int idFilm) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(DELETE_QUERY_BY_CHARACTER_AND_FILM)) {
            pst.setInt(1, idCharacter);
            pst.setInt(2, idFilm);
            pst.executeUpdate();
        }
    }

    public void eliminarPorCharacter(int id) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(DELETE_QUERY_BY_CHARACTER)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public void eliminarPorFilm(int id) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(DELETE_QUERY_BY_FILM)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}
