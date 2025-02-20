package es.martinezpenya.ejemplos.UD10;
/*
@see https://stackoverflow.com/questions/6567839/if-i-use-a-singleton-class-for-a-database-connection-can-one-user-close-the-con
Patron Singleton
================
Este patrón de diseño está diseñado para restringir la creación de objetos pertenecientes a una clase.
Su intención consiste en garantizar que una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella.
El patrón Singleton se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna.
Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor haciéndolo privado.
Las situaciones más habituales de aplicación de este patrón son aquellas en las que dicha clase ofrece un conjunto de utilidades comunes para todas las capas (como puede ser el sistema de log, conexión a la base de datos, ...) o cuando cierto tipo de datos debe estar disponible para todos los demás objetos de la aplicación.
El patrón Singleton provee una única instancia global gracias a que:
        - La propia clase es responsable de crear la única instancia.
        - Permite el acceso global a dicha instancia mediante un método de clase.
        - Declara el constructor de clase como privado (no es instanciable directamente).
*/
public class UD10_03_Singleton {
    private static UD10_03_Singleton dbInstance; //Variable para almacenar la unica instancia de la clase
    private static java.sql.Connection con;

    private UD10_03_Singleton() {
        // El Constructor es privado!!
    }

    public static UD10_03_Singleton getInstance() {
        //Si no hay ninguna instancia...
        if (dbInstance == null) {
            dbInstance = new UD10_03_Singleton();
        }
        return dbInstance;
    }

    public static java.sql.Connection getConnection() {
        if (con == null) {
            try {
                String host = "jdbc:mysql://localhost:3306/prueba";
                String username = "prueba";
                String password = "1234";
                con = java.sql.DriverManager.getConnection(host, username, password);
                System.out.println("Conexión realizada");
            } catch (java.sql.SQLException ex) {
                System.out.println("ERROR al conectar: " + ex.getMessage());
            }
        }
        return con;
    }
}
