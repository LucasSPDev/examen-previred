INSERT INTO usuario (email, nombre, password) VALUES ('admin@miempresa.com', 'Admin', 'admin123');
INSERT INTO usuario (email, nombre, password) VALUES ('usuario1@miempresa.com', 'Usuario1', 'usuario1password');
INSERT INTO usuario (email, nombre, password) VALUES ('usuario2@miempresa.com', 'Usuario2', 'usuario2password');
INSERT INTO estado_tarea (nombre) VALUES ('Pendiente');
INSERT INTO estado_tarea (nombre) VALUES ('En Progreso');
INSERT INTO estado_tarea (nombre) VALUES ('Completada');
INSERT INTO tarea (titulo, descripcion, usuario_id, estado_id) VALUES ('Tarea 1', 'Descripción de la tarea 1', 1, 1);
INSERT INTO tarea (titulo, descripcion, usuario_id, estado_id) VALUES ('Tarea 2', 'Descripción de la tarea 2', 2, 2);
INSERT INTO tarea (titulo, descripcion, usuario_id, estado_id) VALUES ('Tarea 3', 'Descripción de la tarea 3', 3, 3);