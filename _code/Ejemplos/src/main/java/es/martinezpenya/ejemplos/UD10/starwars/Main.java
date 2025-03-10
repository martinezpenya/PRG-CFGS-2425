package es.martinezpenya.ejemplos.UD10.starwars;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try (Connection con = DBConnect.getConnection()) {
            while (true) {
                menuPrincipal();
                int opcion = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer del entrada
                switch (opcion) {
                    case 1:
                        gestionarFilms();
                        break;
                    case 2:
                        gestionarCharacters();
                        break;
                    case 3:
                        gestionarCharacterFilms();
                        break;
                    case 4:
                        gestionarPlanetas();
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

    private static void gestionarCharacterFilms() {
        Scanner entrada = new Scanner(System.in);
        CharacterFilmDAO characterFilmDAO = new CharacterFilmDAO();
        while (true) {
            menuCharacterFilms();
            int opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer del entrada
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el id del character: ");
                    int id_character = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Introduce el id del film: ");
                    int id_film = entrada.nextInt();
                    entrada.nextLine();
                    Character character = null;
                    Film film = null;
                    try {
                        character = new CharacterDAO().obtener(id_character);
                    } catch (SQLException e) {
                        System.out.println("Error al obtener el character: " + e.getMessage());
                    }
                    try {
                        film = new FilmDAO().obtener(id_film);
                    } catch (SQLException e) {
                        System.out.println("Error al obtener el film: " + e.getMessage());
                    }
                    if (character == null || film == null) {
                        System.out.println("No se pudo crear el CharacterFilm porque el Character o el Film no existen.");

                    } else {
                        CharacterFilm nuevoCharacterFilm = new CharacterFilm(character, film);
                        try {
                            characterFilmDAO.crear(nuevoCharacterFilm);
                            System.out.println("CharacterFilm creado");
                        } catch (SQLException e) {
                            System.out.println("Error al crear characterFilm: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Introduce el ID del Character para ver todos los Films en los que aparece: ");
                    int idCharacter = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        ArrayList<CharacterFilm> characterFilms = characterFilmDAO.obtenerTodosPorCharacter(idCharacter);
                        if (!characterFilms.isEmpty()) {
                            System.out.println("Listado de CharacterFilm:");
                            for (CharacterFilm cf : characterFilms) {
                                System.out.println(cf);
                            }
                        } else {
                            System.out.println("No hay CharacterFilm registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los CharacterFilm del Character: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Introduce el ID del Film para ver todos los Characters que aparecen: ");
                    int idFilm = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        ArrayList<CharacterFilm> characterFilms = characterFilmDAO.obtenerTodosPorFilm(idFilm);
                        if (!characterFilms.isEmpty()) {
                            System.out.println("Listado de CharacterFilm:");
                            for (CharacterFilm cf : characterFilms) {
                                System.out.println(cf);
                            }
                        } else {
                            System.out.println("No hay CharacterFilm registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los CharacterFilm del Film: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del Character para eliminar todos los CharacterFilm asociados: ");
                    int idCharacterEliminar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        characterFilmDAO.eliminarPorCharacter(idCharacterEliminar);
                        System.out.println("CharacterFilm eliminados correctamente.");
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar CharacterFilm: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Introduce el ID del Film para eliminar todos los CharacterFilm asociados: ");
                    int idFilmEliminar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        characterFilmDAO.eliminarPorFilm(idFilmEliminar);
                        System.out.println("CharacterFilm eliminados correctamente.");
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar CharacterFilm: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Introduce el ID del Character del CharacterFilm a eliminar: ");
                    int idCharacterCharacterFilmEliminar = entrada.nextInt();
                    System.out.print("Introduce el ID del Film del CharacterFilm a eliminar: ");
                    int idFilmCharacterFilmEliminar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        characterFilmDAO.eliminarPorCharacterYFilm(idCharacterCharacterFilmEliminar, idFilmCharacterFilmEliminar);
                        System.out.println("CharacterFilm eliminado correctamente.");
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar CharacterFilm: " + e.getMessage());
                    }
                    break;
            }
        }
    }

    private static void gestionarFilms() {
        Scanner entrada = new Scanner(System.in);
        FilmDAO filmDAO = new FilmDAO();
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
                            System.out.println(film);
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

    private static void gestionarPlanetas() {
        Scanner entrada = new Scanner(System.in);
        PlanetDAO planetDAO = new PlanetDAO();
        while (true) {
            menuPlanets();
            int opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer del entrada
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el id del planeta: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Introduce el nombre del planeta: ");
                    String name = entrada.nextLine();
                    System.out.print("Introduce el rotation_period del planeta: ");
                    String rotation_period = entrada.nextLine();
                    System.out.print("Introduce el orbital_period del planeta: ");
                    String orbital_period = entrada.nextLine();
                    System.out.print("Introduce el diameter del planeta: ");
                    String diameter = entrada.nextLine();
                    System.out.print("Introduce el climate del planeta: ");
                    String climate = entrada.nextLine();
                    System.out.print("Introduce el gravity del planeta: ");
                    String gravity = entrada.nextLine();
                    System.out.print("Introduce el terrain del planeta: ");
                    String terrain = entrada.nextLine();
                    System.out.print("Introduce el surface_water del planeta: ");
                    String surface_water = entrada.nextLine();
                    System.out.print("Introduce el population del planeta: ");
                    String population = entrada.nextLine();
                    Planet nuevoPlanet = new Planet(id, name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population); // El ID se genera automáticamente
                    try {
                        planetDAO.crear(nuevoPlanet);
                        System.out.println("Planeta creado con ID: " + nuevoPlanet.getId());
                    } catch (SQLException e) {
                        System.out.println("Error al crear planeta: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Introduce el ID del planeta a consultar: ");
                    int idPlanet = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Planet planet = planetDAO.obtener(idPlanet);
                        if (planet != null) {
                            System.out.println("Planeta encontrado:");
                            System.out.println(planet);
                        } else {
                            System.out.println("No se encontró ningún planeta con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener el planeta: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ArrayList<Planet> planets = planetDAO.obtenerTodos();
                        if (!planets.isEmpty()) {
                            System.out.println("Listado de Planetas:");
                            for (Planet u : planets) {
                                System.out.println(u);
                            }
                        } else {
                            System.out.println("No hay planetas registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los planetas: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del planeta a actualizar: ");
                    int idActualizar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Planet planetActualizar = planetDAO.obtener(idActualizar);
                        if (planetActualizar != null) {
                            System.out.print("Introduce el nuevo nombre del planeta (deja en blanco para mantener el actual): ");
                            String nuevoName = entrada.nextLine();
                            if (!nuevoName.isEmpty()) {
                                planetActualizar.setName(nuevoName);
                            }
                            System.out.print("Introduce el nuevo rotation_period del planeta (deja en blanco para mantener el actual): ");
                            String nuevoRotation_period = entrada.nextLine();
                            if (!nuevoRotation_period.isEmpty()) {
                                planetActualizar.setRotation_period(nuevoRotation_period);
                            }
                            System.out.print("Introduce el nuevo orbital_period del planeta (deja en blanco para mantener el actual): ");
                            String nuevoOrbital_period = entrada.nextLine();
                            if (!nuevoOrbital_period.isEmpty()) {
                                planetActualizar.setOrbital_period(nuevoOrbital_period);
                            }
                            System.out.print("Introduce el nuevo diameter del planeta (deja en blanco para mantener el actual): ");
                            String nuevoDiameter = entrada.nextLine();
                            if (!nuevoDiameter.isEmpty()) {
                                planetActualizar.setDiameter(nuevoDiameter);
                            }
                            System.out.print("Introduce el nuevo climate del planeta (deja en blanco para mantener el actual): ");
                            String nuevoClimate = entrada.nextLine();
                            if (!nuevoClimate.isEmpty()) {
                                planetActualizar.setClimate(nuevoClimate);
                            }
                            System.out.print("Introduce el nuevo gravity del planeta (deja en blanco para mantener el actual): ");
                            String nuevoGravity = entrada.nextLine();
                            if (!nuevoGravity.isEmpty()) {
                                planetActualizar.setGravity(nuevoGravity);
                            }
                            System.out.print("Introduce el nuevo terrain del planeta (deja en blanco para mantener el actual): ");
                            String nuevoTerrain = entrada.nextLine();
                            if (!nuevoTerrain.isEmpty()) {
                                planetActualizar.setTerrain(nuevoTerrain);
                            }
                            System.out.print("Introduce el nuevo surface_water del planeta (deja en blanco para mantener el actual): ");
                            String nuevoSurface_water = entrada.nextLine();
                            if (!nuevoSurface_water.isEmpty()) {
                                planetActualizar.setSurface_water(nuevoSurface_water);
                            }
                            System.out.print("Introduce el nuevo population del planeta (deja en blanco para mantener el actual): ");
                            String nuevoPopulation = entrada.nextLine();
                            if (!nuevoPopulation.isEmpty()) {
                                planetActualizar.setPopulation(nuevoPopulation);
                            }
                            planetDAO.actualizar(planetActualizar);
                            System.out.println("Planeta actualizado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún Planeta con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al actualizar Planeta: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Introduce el ID del planeta a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Planet planetEliminar = planetDAO.obtener(idEliminar);
                        if (planetEliminar != null) {
                            // todo: Revisar si quiero eliminar Characters al eliminar su Planeta Origen.
                            planetDAO.eliminar(idEliminar);
                            System.out.println("Planeta eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún planeta con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar planeta: " + e.getMessage());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void gestionarCharacters() {
        Scanner entrada = new Scanner(System.in);
        CharacterDAO characterDAO = new CharacterDAO();
        while (true) {
            menuCharacters();
            PlanetDAO planetDAO = new PlanetDAO();
            int opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer del entrada
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el id del character: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Introduce el name del character: ");
                    String name = entrada.nextLine();
                    System.out.print("Introduce el height del character: ");
                    int height = Integer.parseInt(entrada.nextLine());
                    System.out.print("Introduce el mass del character: ");
                    int mass = Integer.parseInt(entrada.nextLine());
                    System.out.print("Introduce el hair_color del character: ");
                    String hair_color = entrada.nextLine();
                    System.out.print("Introduce el skin_color del character: ");
                    String skin_color = entrada.nextLine();
                    System.out.print("Introduce el eye_color del character: ");
                    String eye_color = entrada.nextLine();
                    System.out.print("Introduce el birth_year del character: ");
                    String birth_year = entrada.nextLine();
                    System.out.print("Introduce el gender del character: ");
                    String gender = entrada.nextLine();
                    System.out.print("Introduce el id del planeta del character: ");
                    int planet_id = Integer.parseInt(entrada.nextLine());
                    Character nuevoCharacter = null;
                    try {
                        nuevoCharacter = new Character(id, name, height, mass, skin_color, hair_color, eye_color, birth_year, gender, planetDAO.obtener(planet_id));
                    } catch (SQLException e) {
                        System.out.println("Error al obtener el planeta: " + e.getMessage());
                    }
                    try {
                        characterDAO.crear(nuevoCharacter);
                        System.out.println("Character creado con ID: " + nuevoCharacter.getId());
                    } catch (SQLException e) {
                        System.out.println("Error al crear character: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Introduce el ID del character a consultar: ");
                    int idCharacter = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Character character = characterDAO.obtener(idCharacter);
                        if (character != null) {
                            System.out.println("Character encontrado:");
                            System.out.println(character);
                        } else {
                            System.out.println("No se encontró ningún character con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener el character: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ArrayList<Character> characters = characterDAO.obtenerTodos();
                        if (!characters.isEmpty()) {
                            System.out.println("Listado de Characters:");
                            for (Character u : characters) {
                                System.out.println(u);
                            }
                        } else {
                            System.out.println("No hay characters registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los characters: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del character a actualizar: ");
                    int idActualizar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Character characterActualizar = characterDAO.obtener(idActualizar);
                        if (characterActualizar != null) {
                            System.out.print("Introduce el nuevo name del character (deja en blanco para mantener el actual): ");
                            String nuevoName = entrada.nextLine();
                            if (!nuevoName.isEmpty()) {
                                characterActualizar.setName(nuevoName);
                            }
                            System.out.print("Introduce el nuevo height del character (deja en blanco para mantener el actual): ");
                            String nuevoHeight = entrada.nextLine();
                            if (!nuevoHeight.isEmpty()) {
                                characterActualizar.setHeight(Integer.parseInt(nuevoHeight));
                            }
                            System.out.print("Introduce el nuevo mass del character (deja en blanco para mantener el actual): ");
                            String nuevoMass = entrada.nextLine();
                            if (!nuevoMass.isEmpty()) {
                                characterActualizar.setMass(Double.parseDouble(nuevoMass));
                            }
                            System.out.print("Introduce el nuevo hair_color del character (deja en blanco para mantener el actual): ");
                            String nuevoHair_color = entrada.nextLine();
                            if (!nuevoHair_color.isEmpty()) {
                                characterActualizar.setHair_color(nuevoHair_color);
                            }
                            System.out.print("Introduce el nuevo skin_color del character (deja en blanco para mantener el actual): ");
                            String nuevoSkin_color = entrada.nextLine();
                            if (!nuevoSkin_color.isEmpty()) {
                                characterActualizar.setSkin_color(nuevoSkin_color);
                            }
                            System.out.print("Introduce el nuevo eye_color del character (deja en blanco para mantener el actual): ");
                            String nuevoEye_color = entrada.nextLine();
                            if (!nuevoEye_color.isEmpty()) {
                                characterActualizar.setEye_color(nuevoEye_color);
                            }
                            System.out.print("Introduce el nuevo birth_year del character (deja en blanco para mantener el actual): ");
                            String nuevoBirth_year = entrada.nextLine();
                            if (!nuevoBirth_year.isEmpty()) {
                                characterActualizar.setBirth_year(nuevoBirth_year);
                            }
                            System.out.print("Introduce el nuevo gender del character (deja en blanco para mantener el actual): ");
                            String nuevoGender = entrada.nextLine();
                            if (!nuevoGender.isEmpty()) {
                                characterActualizar.setGender(nuevoGender);
                            }
                            System.out.print("Introduce el nuevo id del planeta del character (deja en blanco para mantener el actual): ");
                            String nuevoPlanet_id = entrada.nextLine();
                            if (!nuevoPlanet_id.isEmpty()) {
                                Planet p;
                                if ((p=planetDAO.obtener(Integer.parseInt(nuevoPlanet_id)))!=null) {
                                    characterActualizar.setPlanet_id(p);
                                }
                            }
                            characterDAO.actualizar(characterActualizar);
                            System.out.println("Character actualizado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún Character con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al actualizar Character: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Introduce el ID del character a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Character characterEliminar = characterDAO.obtener(idEliminar);
                        if (characterEliminar != null) {
                            characterDAO.eliminar(idEliminar);
                            System.out.println("Character eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún character con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar character: " + e.getMessage());
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
        System.out.println("4. Gestionar Planets");
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

    //MENU SECUNDARIO: menuPlanets()
    private static void menuPlanets() {
        System.out.println("\nMenú de Planets:");
        System.out.println("1. Crear planeta");
        System.out.println("2. Consultar planeta por ID");
        System.out.println("3. Listar todos los planetas");
        System.out.println("4. Actualizar planeta");
        System.out.println("5. Eliminar planeta");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }

    // MENÚ SECUNDARIO: menuCharacters()
    private static void menuCharacters() {
        System.out.println("\nMenú de Characters:");
        System.out.println("1. Crear character");
        System.out.println("2. Consultar character por ID");
        System.out.println("3. Listar todos los characters");
        System.out.println("4. Actualizar character");
        System.out.println("5. Eliminar character");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }

    // MENÚ SECUNDARIO: menuCharacterFilms()
    private static void menuCharacterFilms() {
        System.out.println("\nMenú de CharacterFilm:");
        System.out.println("1. Crear characterFilm");
        System.out.println("2. Consultar characterFilm por Character");
        System.out.println("3. Consultar characterFilm por Film");
        System.out.println("4. Eliminar characterFilm por Character");
        System.out.println("5. Eliminar characterFilm por Film");
        System.out.println("6. Eliminar characterFilm por Character y Film");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }
}