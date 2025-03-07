package es.martinezpenya.ejemplos.UD10._03_Patrones._03_DAO;

public class TestFilmDAOImplementado {

    public static void main(String[] args) {
        // Crear una instancia de FilmDAOImplementado
        FilmDAOImplementado filmDAO = new FilmDAOImplementado();

        // Crear un film ficticio para el episodio 7
        Film film = new Film();
        film.setId(7); // Cambiamos el episodio a 7
        film.setEpisode("VII");
        film.setTitle("The Force Awakens"); // Cambiamos el título

        // 1. Insertar el film en la base de datos
        System.out.println("Insertando el film...");
        filmDAO.agregarFilm(film);
        System.out.println("Film insertado: " + film.getTitle());

        // 2. Recuperar el film recién insertado (asumiendo que el ID es 1)
        System.out.println("\nRecuperando el film con ID 7...");
        Film filmRecuperado = filmDAO.obtenerFilm(7);
        if (filmRecuperado != null) {
            System.out.println("Film recuperado: " + filmRecuperado.getTitle() + " (" + filmRecuperado.getEpisode() + ")");
        } else {
            System.out.println("No se encontró el film con ID 7.");
        }

        // 3. Modificar el film recuperado
        if (filmRecuperado != null) {
            System.out.println("\nModificando el film...");
            filmRecuperado.setEpisode("Episode VII"); // Cambiamos el título para agregar más detalle
            filmDAO.actualizarFilm(filmRecuperado);
            System.out.println("Film modificado: " + filmRecuperado.getTitle());

            // Verificar la modificación
            System.out.println("\nRecuperando el film modificado...");
            Film filmModificado = filmDAO.obtenerFilm(filmRecuperado.getId());
            if (filmModificado != null) {
                System.out.println("Film modificado recuperado: " + filmModificado.getTitle() + " (" + filmModificado.getEpisode() + ")");
            } else {
                System.out.println("No se encontró el film modificado.");
            }
        }

        // 4. Eliminar el film
        if (filmRecuperado != null) {
            System.out.println("\nEliminando el film con ID " + filmRecuperado.getId() + "...");
            filmDAO.eliminarFilm(filmRecuperado.getId());
            System.out.println("Film eliminado.");

            // Verificar la eliminación
            System.out.println("\nIntentando recuperar el film eliminado...");
            Film filmEliminado = filmDAO.obtenerFilm(filmRecuperado.getId());
            if (filmEliminado == null) {
                System.out.println("El film fue eliminado correctamente.");
            } else {
                System.out.println("El film no fue eliminado.");
            }
        }
    }
}