package es.martinezpenya.ejemplos.UD10.starwars;

import java.sql.*;
import java.util.ArrayList;

public class CharacterDAO implements DAO<Character> {
    private static final String INSERT_QUERY = "INSERT INTO characters (id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, planet_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM characters WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM characters";
    private static final String UPDATE_QUERY = "UPDATE characters SET name = ?, height = ?, mass = ?, hair_color = ?, skin_color = ?, eye_color = ?, birth_year = ?, gender= ?, planet_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM characters WHERE id = ?";
    private Connection con;

    public CharacterDAO() {
        try {
            con = DBConnect.getConnection();
        } catch (SQLException e) {
            System.out.println("ERROR al conectar: " + e.getMessage());
        }
    }

    public void crear(Character character) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, character.getId());
            pst.setString(2, character.getName());
            pst.setInt(3, character.getHeight());
            pst.setDouble(4, character.getMass());
            pst.setString(5, character.getHair_color());
            pst.setString(6, character.getSkin_color());
            pst.setString(7, character.getEye_color());
            pst.setString(8, character.getBirth_year());
            pst.setString(9, character.getGender());
            pst.setInt(10, character.getPlanet_id().getId());

            int filasInsertadas = pst.executeUpdate();
            if (filasInsertadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    character.setId(id);
                }
            }
        }
    }

    @Override
    public Character obtener(int id) throws SQLException {
        Character character = null;
        try (PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {

            pst.setInt(1, id);
            PlanetDAO planetDAO = new PlanetDAO();
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int idDevuelto = rs.getInt("id");
                String name = rs.getString("name");
                int height = rs.getInt("height");
                double mass = rs.getDouble("mass");
                String hair_color = rs.getString("hair_color");
                String skin_color = rs.getString("skin_color");
                String eye_color = rs.getString("eye_color");
                String birth_year = rs.getString("birth_year");
                String gender = rs.getString("gender");
                Planet planet = planetDAO.obtener(rs.getInt("planet_id")); //buscamos el planeta por su id
                character = new Character(id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, planet);
            }
        }
        return character;
    }

    @Override
    public ArrayList<Character> obtenerTodos() throws SQLException {
        ArrayList<Character> characters = new ArrayList<>();
        PlanetDAO planetDAO = new PlanetDAO();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_QUERY)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int height = rs.getInt("height");
                double mass = rs.getDouble("mass");
                String hair_color = rs.getString("hair_color");
                String skin_color = rs.getString("skin_color");
                String eye_color = rs.getString("eye_color");
                String birth_year = rs.getString("birth_year");
                String gender = rs.getString("gender");
                int planet_id = rs.getInt("planet_id");
                Planet planet = null;
                if (!rs.wasNull()){
                    planet = planetDAO.obtener(planet_id); //buscamos el planeta por su id
                }
                Character character = new Character(id, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, planet);
                characters.add(character);
            }
        }
        return characters;
    }

    @Override
    public void actualizar(Character entidad) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)) {
            pst.setString(1, entidad.getName());
            pst.setInt(2, entidad.getHeight());
            pst.setDouble(3, entidad.getMass());
            pst.setString(4, entidad.getHair_color());
            pst.setString(5, entidad.getSkin_color());
            pst.setString(6, entidad.getEye_color());
            pst.setString(7, entidad.getBirth_year());
            pst.setString(8, entidad.getGender());
            pst.setInt(9, entidad.getPlanet_id().getId());
            pst.setInt(10, entidad.getId());
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
