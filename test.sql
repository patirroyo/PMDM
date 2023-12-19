CREATE TABLE IF NOT EXISTS REGION(
   id bigint auto_increment,
   nombre varchar(25),
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS ENTRENADOR(
   id_entrenador bigint auto_increment,
   nombre_entrenador varchar(25),
   active boolean,
   PRIMARY KEY(id_entrenador)
);

CREATE TABLE IF NOT EXISTS POKEMON(
   id bigint auto_increment,
   nombre varchar(50),
   fechaCaptura date,
   region_id INT,
   entrenador_id INT,
   PRIMARY KEY(id)

);



-- Insertar Regiones
INSERT INTO REGION (nombre) VALUES
('Kanto'),
('Johto'),
('Hoenn'),
('Sinnoh');

-- Insertar Entrenadores desactivados
INSERT INTO ENTRENADOR (nombre_entrenador, active) VALUES
('Ash Ketchum', 0),
('Misty', 0),
('Brock', 0),
('May', 0);

-- Insertar Pokémon con relación a Regiones y Entrenadores
INSERT INTO POKEMON (nombre, fechaCaptura, region_id, entrenador_id) VALUES
('Pikachu', '2023-01-01', 1, 1),
('Charmander', '2023-02-15', 1, 2),
('Totodile', '2023-03-20', 2, 3),
('Treecko', '2023-04-10', 3, 4),
('Piplup', '2023-05-05', 4, 1),
('Eevee', '2023-06-12', 1, 2),
('Mudkip', '2023-07-18', 2, 3),
('Cyndaquil', '2023-08-25', 3, 4),
('Torchic', '2023-09-30', 4, 1),
('Squirtle', '2023-10-15', 1, 2);



IF (Select e.id_entrenador from ENTRENADOR e where e.active = 1 limit 1) = 1 THEN
   UPDATE ENTRENADOR SET active = 1 WHERE nombre_entrenador = 'Ash Ketchum';
END IF;