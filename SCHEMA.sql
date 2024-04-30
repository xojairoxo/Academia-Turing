DROP DATABASE IF EXISTS AcademiaTuring;
CREATE DATABASE AcademiaTuring;
USE AcademiaTuring;

CREATE TABLE Ausuario(
   id varchar(10),
   nombre varchar(32), 
   contrasenia varchar(30) NOT NULL, 
   username varchar(20) NOT NULL, 
   Primary Key(id),
   Unique (username)
);

CREATE TABLE curso(
	codigo varchar(15),
    nombre varchar(30),
    creditos int,

	Primary Key(codigo)
);

CREATE TABLE cursosUsuarios(
	id_registro int auto_increment,
	id_usuario varchar(15),
    codigo_curso varchar(15),
	horario varchar(50),
    prioridad varchar(16),
    Primary Key(id_registro),
    Foreign Key(id_usuario) references Ausuario(id),
    Foreign Key(codigo_curso) references curso(codigo)
);

INSERT INTO Ausuario (id, nombre, contrasenia, username)
VALUES ('1', 'Juan Perez', '123', '123'),
       ('2', 'Maria Garcia', '1234', '1234');

INSERT INTO curso (codigo, nombre, creditos)
VALUES ('C001', 'Programación I', 3),
       ('C002', 'Programación II', 4),
       ('C003', 'Programación III', 3),
       ('C004', 'Programación IV', 4);

SELECT * FROM Ausuario;
SELECT * FROM curso;

-- Ejemplo de inserción en cursosUsuarios con horario y prioridad
INSERT INTO cursosUsuarios (id_usuario, codigo_curso, horario, prioridad)
VALUES ('1', 'C001', 'Lunes y Miércoles 9:00 AM - 11:00 AM', 'Alta'),
       ('2', 'C002', 'Martes y Jueves 2:00 PM - 4:00 PM', 'Media');

