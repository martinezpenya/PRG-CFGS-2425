package es.martinezpenya.ejemplos.UD10.starwars;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect {

    private static HikariDataSource dataSource;

    // Configuración del pool de conexiones
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://databasedmp.cipxbdkxiaqy.us-east-1.rds.amazonaws.com:6000/starwars"); // URL de la base de datos
        config.setUsername("admin"); // Usuario de la base de datos
        config.setPassword("123456Ab$"); // Contraseña de la base de datos
        config.setMaximumPoolSize(20); // Número máximo de conexiones en el pool
        config.setMinimumIdle(2); // Número mínimo de conexiones inactivas en el pool
        config.setIdleTimeout(3000); // Tiempo de espera para conexiones inactivas (en milisegundos)
        config.setMaxLifetime(180000); // Tiempo máximo de vida de una conexión (en milisegundos)
        config.setConnectionTimeout(300000); // Tiempo de espera para obtener una conexión (en milisegundos)

        dataSource = new HikariDataSource(config);
    }

    // Método para obtener una conexión del pool
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Método para cerrar el pool de conexiones (opcional)
    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}