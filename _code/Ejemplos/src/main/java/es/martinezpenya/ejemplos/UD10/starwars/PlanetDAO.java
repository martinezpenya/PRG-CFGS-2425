package es.martinezpenya.ejemplos.UD10.starwars;

import java.sql.*;
import java.util.ArrayList;

public class PlanetDAO implements DAO<Planet> {
    private static final String INSERT_QUERY = "INSERT INTO planets (id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM planets WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM planets";
    private static final String UPDATE_QUERY = "UPDATE planets SET name = ?, rotation_period = ?, orbital_period = ?, diameter = ?, climate = ?, gravity = ?, terrain = ?, surface_water = ?, population = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM planets WHERE id = ?";
    private Connection con;

    public PlanetDAO () {
        try {
            con = DBConnect.getConnection();
        } catch (SQLException e) {
            System.out.println("ERROR al conectar: " + e.getMessage());
        }
    }

    public void crear(Planet planet) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, planet.getId());
            pst.setString(2, planet.getName());
            pst.setString(3, planet.getRotation_period());
            pst.setString(4, planet.getOrbital_period());
            pst.setString(5, planet.getDiameter());
            pst.setString(6, planet.getClimate());
            pst.setString(7, planet.getGravity());
            pst.setString(8, planet.getTerrain());
            pst.setString(9, planet.getSurface_water());
            pst.setString(10, planet.getPopulation());

            int filasInsertadas = pst.executeUpdate();
            if (filasInsertadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    planet.setId(id);
                }
            }
        }
    }

    public Planet obtener(int id) throws SQLException {
        Planet planet = null;
        try (PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int idDevuelto = rs.getInt("id");
                String name = rs.getString("name");
                String rotation_period = rs.getString("rotation_period");
                String orbital_period = rs.getString("orbital_period");
                String diameter = rs.getString("diameter");
                String climate = rs.getString("climate");
                String gravity = rs.getString("gravity");
                String terrain = rs.getString("terrain");
                String surface_water = rs.getString("surface_water");
                String population = rs.getString("population");
                planet = new Planet(id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population);
            }
        }
        return planet;
    }

    @Override
    public ArrayList<Planet> obtenerTodos() throws SQLException {
        ArrayList<Planet> planets = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_QUERY)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String rotation_period = rs.getString("rotation_period");
                String orbital_period = rs.getString("orbital_period");
                String diameter = rs.getString("diameter");
                String climate = rs.getString("climate");
                String gravity = rs.getString("gravity");
                String terrain = rs.getString("terrain");
                String surface_water = rs.getString("surface_water");
                String population = rs.getString("population");
                Planet planet = new Planet(id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population);
                planets.add(planet);
            }
        }
        return planets;
    }

    public void actualizar(Planet planet) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)) {

            pst.setString(1, planet.getName());
            pst.setString(2, planet.getRotation_period());
            pst.setString(3, planet.getOrbital_period());
            pst.setString(4, planet.getDiameter());
            pst.setString(5, planet.getClimate());
            pst.setString(6, planet.getGravity());
            pst.setString(7, planet.getTerrain());
            pst.setString(8, planet.getSurface_water());
            pst.setString(9, planet.getPopulation());
            pst.setInt(10, planet.getId());

            pst.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(DELETE_QUERY)) {

            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}
