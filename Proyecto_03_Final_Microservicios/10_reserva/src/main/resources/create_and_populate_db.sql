CREATE DATABASE `bdviajes`;

CREATE TABLE `hoteles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `disponible` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `vuelos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `compañia` varchar(45) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `plazas` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `reservas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente` varchar(45) DEFAULT NULL,
  `dni` varchar(45) DEFAULT NULL,
  `id_hotel` int DEFAULT NULL,
  `id_vuelo` int DEFAULT NULL,
  `personas_reserva` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (1, 'Hotel Luxor', '5 estrellas', 200.00, 1);
INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (2, 'Hotel Paris', '4 estrellas', 150.00, 0);
INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (3, 'Hotel New York', '3 estrellas', 100.00, 1);
INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (4, 'Hotel Beach', '4 estrellas', 180.00, 0);
INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (5, 'Hotel Spa', '5 estrellas', 250.00, 1);
INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (6, 'Hotel Palace', '5 estrellas', 300.00, 0);
INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (7, 'Hotel Sunset', '3 estrellas', 80.00, 1);
INSERT INTO hoteles (idhotel, nombre, categoria, precio, disponible) VALUES (8, 'Hotel Ocean', '4 estrellas', 120.00, 1);

INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (1, 'Aerolineas Argentinas', '2022-02-10 08:00:00', 150.00, 10);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (2, 'LATAM', '2022-02-15 10:00:00', 200.00, 15);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (3, 'American Airlines', '2022-02-20 12:00:00', 300.00, 20);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (4, 'Delta', '2022-02-25 14:00:00', 400.00, 25);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (5, 'Iberia', '2022-03-01 16:00:00', 500.00, 30);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (6, 'Air Europa', '2022-03-05 18:00:00', 600.00, 35);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (7, 'United', '2022-03-10 20:00:00', 700.00, 40);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (8, 'British Airways', '2022-03-15 22:00:00', 800.00, 45);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (9, 'Air France', '2022-03-20 06:00:00', 900.00, 50);
INSERT INTO vuelos (id, compañia, fecha, precio, plazas) VALUES (10, 'KLM', '2022-03-25 08:00:00', 1000.00, 55);

INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (1, 'Juan Pérez', '12345678', 1, 1, 4);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (2, 'María García', '78901234', 2, 2, 4);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (3, 'José Rodríguez', '90123456', 3, 3, 4);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (4, 'Pedro Fernández', '11111111', 4, 4, 5);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (5, 'Sofía Torres', '22222222', 5, 5, 6);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (6, 'Lucía Martínez', '33333333', 6, 6, 7);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (7, 'Jorge Sánchez', '44444444', 7, 7, 8);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (8, 'Elena González', '55555555', 8, 8, 9);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (9, 'Rubén Jiménez', '66666666', 1, 9, 10);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (10, 'Eva Méndez', '77777777', 2, 10, 1);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (11, 'Luisa García', '88888888', 3, 11, 2);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (12, 'Juan Carlos Pérez', '99999999', 4, 2, 13);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (13, 'María José Rodríguez', '11111111', 5, 3, 14);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (14, 'Pedro Antonio Fernández', '22222222', 6, 4, 15);
INSERT INTO reservas (id, cliente, dni, id_hotel, id_vuelo, personas_reserva) VALUES (15, 'Sofía Alejandra Torres', '33333333', 7, 5, 16);
