package es.martinezpenya.ejemplos.UD10.starwars;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        DAO<Film> filmDAO = new FilmDAO();
        //DAO<Character>  characterDAO = new CharacterDAO();
        // IRepository<Comentario> comentarioDAO = new ComentarioRepositoryImpl();

        try (Connection con = DBConnect.getConnection()) {
            while (true) {
                menuPrincipal();
                int opcion = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer del entrada

                switch (opcion) {
                    case 1:
                        gestionarUsuarios(entrada, filmDAO);
                        break;
                    case 2:
                        // gestionarPosts(entrada, postDAO);
                        break;
                    case 3:
                        // gestionarComentarios(entrada, comentarioDAO, usuarioDAO, postDAO);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        entrada.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos: " + e.getMessage());
        }
    }

    private static void gestionarUsuarios(Scanner entrada, DAO<Film> filmDAO) {
        while (true) {
            menuFilms();
            int opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer del entrada
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el id del film: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Introduce el episode del film: ");
                    String episode = entrada.nextLine();
                    System.out.print("Introduce el title del film: ");
                    String title = entrada.nextLine();
                    Film nuevoFilm = new Film(id, episode, title); // El ID se genera automáticamente
                    try {
                        filmDAO.crear(nuevoFilm);
                        System.out.println("Usuario creado con ID: " + nuevoFilm.getId());
                    } catch (SQLException e) {
                        System.out.println("Error al crear usuario: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Introduce el ID del film a consultar: ");
                    int idFilm = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Film film = filmDAO.obtener(idFilm);
                        if (film != null) {
                            System.out.println("Film encontrado:");
                            System.out.printf(" %-3d %-15s %-35s%n",
                                    film.getId(),
                                    film.getEpisode(),
                                    film.getTitle());
                        } else {
                            System.out.println("No se encontró ningún film con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener el film: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ArrayList<Film> films = filmDAO.obtenerTodos();
                        if (!films.isEmpty()) {
                            System.out.println("Listado de Usuarios:");
                            for (Film u : films) {
                                System.out.println(u);
                            }
                        } else {
                            System.out.println("No hay films registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los films: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del film a actualizar: ");
                    int idActualizar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Film filmActualizar = filmDAO.obtener(idActualizar);
                        if (filmActualizar != null) {
                            System.out.print("Introduce el nuevo episode del film (deja en blanco para mantener el actual): ");
                            String nuevoEpisode = entrada.nextLine();
                            if (!nuevoEpisode.isEmpty()) {
                                filmActualizar.setEpisode(nuevoEpisode);
                            }
                            System.out.print("Introduce el nuevo title del film (deja en blanco para mantener el actual): ");
                            String nuevoTitle = entrada.nextLine();
                            if (!nuevoTitle.isEmpty()) {
                                filmActualizar.setTitle(nuevoTitle);
                            }
                            filmDAO.actualizar(filmActualizar);
                            System.out.println("Film actualizado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún Film con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al actualizar Film: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Introduce el ID del film a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Film filmEliminar = filmDAO.obtener(idEliminar);
                        if (filmEliminar != null) {
                            // eliminar primero los character_films y deaths asociados al film
                            // Character_filmDAO.eliminarCharacter_filmsPorFilm(idEliminar);
                            // luego eliminar el film
                            filmDAO.eliminar(idEliminar);
                            System.out.println("Film eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún film con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar film: " + e.getMessage());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    // MENÚ PRINCIPAL: menuPrincipal()
    private static void menuPrincipal() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Gestionar Films");
        System.out.println("2. Gestionar Characters");
        System.out.println("3. Gestionar Character_films");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción:  ");
    }

    // MENÚ SECUNDARIO: menuFilms()
    private static void menuFilms() {
        System.out.println("\nMenú de Films:");
        System.out.println("1. Crear film");
        System.out.println("2. Consultar film por ID");
        System.out.println("3. Listar todos los films");
        System.out.println("4. Actualizar film");
        System.out.println("5. Eliminar film");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }

    // MENÚ SECUNDARIO: menuPosts()
    private static void menuPosts() {
        System.out.println("\nMenú de Posts:");
        System.out.println("1. Crear post");
        System.out.println("2. Consultar post por ID");
        System.out.println("3. Listar todos los posts");
        System.out.println("4. Actualizar post");
        System.out.println("5. Eliminar post");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }

    // MENÚ SECUNDARIO: menuPosts()
    private static void menuComentarios() {
        System.out.println("\nMenú de Comentarios:");
        System.out.println("1. Crear comentario");
        System.out.println("2. Consultar comentario por ID");
        System.out.println("3. Listar todos los comentarios");
        System.out.println("4. Actualizar comentario");
        System.out.println("5. Eliminar comentario");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }
}