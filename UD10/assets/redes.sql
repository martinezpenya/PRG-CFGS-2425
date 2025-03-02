--
-- Archivo generado con SQLiteStudio v3.4.4 el jue. may. 23 11:02:50 2024
--
-- Codificación de texto usada: UTF-8
--

-- Tabla: users
CREATE TABLE IF NOT EXISTS users (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(50) NOT NULL,
 apellido VARCHAR(255) NOT NULL
 );
INSERT INTO users (id, nombre, apellido) VALUES (3, 'Andrés', 'García');
INSERT INTO users (id, nombre, apellido) VALUES (4, 'Janet', 'Espinosa');
INSERT INTO users (id, nombre, apellido) VALUES (5, 'Pepe', 'Ponz');
INSERT INTO users (id, nombre, apellido) VALUES (6, 'Maria', 'Gallardo');
INSERT INTO users (id, nombre, apellido) VALUES (7, 'Maria', 'Gallardo');
INSERT INTO users (id, nombre, apellido) VALUES (8, 'Alberto', 'Gracia');
INSERT INTO users (id, nombre, apellido) VALUES (12, 'Juan', 'María');
INSERT INTO users (id, nombre, apellido) VALUES (13, 'Juan', 'Marqués');
INSERT INTO users (id, nombre, apellido) VALUES (14, 'Juan', 'Imedio');
INSERT INTO users (id, nombre, apellido) VALUES (18, 'Pedro', 'Martínez');
INSERT INTO users (id, nombre, apellido) VALUES (23, 'Juan Pedro', 'Pascal');


-- Tabla: posts
CREATE TABLE IF NOT EXISTS posts (
  id INT PRIMARY KEY AUTO_INCREMENT,
  texto VARCHAR(255) NOT NULL,
  likes INT NOT NULL,
  fecha timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  userId INTEGER NOT NULL,
  FOREIGN KEY (userId) REFERENCES users(id)
);


-- Tabla: comments
CREATE TABLE IF NOT EXISTS comments (
  id INT PRIMARY KEY AUTO_INCREMENT,
  texto VARCHAR(255) NOT NULL,
  fecha timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  userId INT  NOT NULL,
  postId INT  NOT NULL,
  FOREIGN KEY (userId) REFERENCES users(id),
  FOREIGN KEY (postId) REFERENCES posts(id)
);
