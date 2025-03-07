package es.martinezpenya.ejemplos.UD10.starwars;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
    void crear(T entidad) throws SQLException;;      // C: Create
    T obtener(int id) throws SQLException;;          // R: Read
    ArrayList<T> obtenerTodos() throws SQLException;;     // R: Read (all)
    void actualizar(T entidad) throws SQLException;; // U: Update
    void eliminar(int id) throws SQLException;;      // D: Delete
}