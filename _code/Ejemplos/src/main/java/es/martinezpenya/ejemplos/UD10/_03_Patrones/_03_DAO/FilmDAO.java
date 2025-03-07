package es.martinezpenya.ejemplos.UD10._03_Patrones._03_DAO;

public interface FilmDAO {
    void agregarFilm(Film film);         // Crear una nueva película
    Film obtenerFilm(int id);            // Obtener una película por su ID
    void actualizarFilm(Film film);      // Actualizar una película existente
    void eliminarFilm(int id);           // Eliminar una película por su ID
}