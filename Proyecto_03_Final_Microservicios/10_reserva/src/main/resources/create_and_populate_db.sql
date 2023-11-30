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
  `company` varchar(45) DEFAULT NULL,
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

CREATE TABLE `promociones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hotel` tinyint DEFAULT NULL,
  `vuelo` tinyint DEFAULT NULL,
  `porcentaje` int DEFAULT NULL,
  `activa` tinyint DEFAULT '1',
  PRIMARY KEY (`id`)
);


INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (1,'Hotel Luxor','5 estrellas',200,1);
INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (2,'Hotel Paris','4 estrellas',150,0);
INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (3,'Hotel New York','3 estrellas',100,1);
INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (4,'Hotel Beach','4 estrellas',180,0);
INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (5,'Hotel Spa','5 estrellas',250,1);
INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (6,'Hotel Palace','5 estrellas',300,0);
INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (7,'Hotel Sunset','3 estrellas',80,1);
INSERT INTO `bdviajes`.`hoteles` (`id`,`nombre`,`categoria`,`precio`,`disponible`) VALUES (8,'Hotel Ocean','4 estrellas',120,1);

INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (1,'LATAM','2022-02-10 08:00:00',150,100);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (2,'LATAM','2022-02-15 10:00:00',200,20);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (3,'Iberia','2022-02-20 12:00:00',300,20);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (4,'Delta','2022-02-25 14:00:00',400,25);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (5,'Iberia','2022-03-01 16:00:00',500,30);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (6,'Air Europa','2022-03-05 18:00:00',600,35);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (7,'United','2022-03-10 20:00:00',700,40);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (8,'Iberia','2022-03-15 22:00:00',800,45);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (9,'Air France','2022-03-20 06:00:00',900,50);
INSERT INTO `bdviajes`.`vuelos` (`id`,`company`,`fecha`,`precio`,`plazas`) VALUES (10,'LATAM','2022-03-25 08:00:00',1000,55);

INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (1,'Juan Pérez','12345678',1,1,4,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (2,'María García','78901234',2,2,4,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (3,'José Rodríguez','90123456',3,3,4,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (4,'Pedro Fernández','11111111',4,4,5,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (5,'Sofía Torres','22222222',5,5,6,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (6,'Lucía Martínez','33333333',6,6,7,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (7,'Jorge Sánchez','44444444',7,7,8,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (8,'Elena González','55555555',8,8,9,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (9,'Rubén Jiménez','66666666',1,9,10,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (10,'Eva Méndez','77777777',2,10,1,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (11,'Luisa García','88888888',3,11,2,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (12,'Juan Carlos Pérez','99999999',4,2,13,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (13,'María José Rodríguez','11111111',5,3,14,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (14,'Pedro Antonio Fernández','22222222',6,4,15,NULL);
INSERT INTO `bdviajes`.`reservas` (`id`,`cliente`,`dni`,`id_hotel`,`id_vuelo`,`personas_reserva`,`precio_total`) VALUES (15,'Sofía Alejandra Torres','33333333',7,5,16,NULL);

INSERT INTO `bdviajes`.`promociones` (`id`,`hotel`,`vuelo`,`porcentaje`,`activa`) VALUES (1,1,1,25,1);
INSERT INTO `bdviajes`.`promociones` (`id`,`hotel`,`vuelo`,`porcentaje`,`activa`) VALUES (2,0,1,10,1);
INSERT INTO `bdviajes`.`promociones` (`id`,`hotel`,`vuelo`,`porcentaje`,`activa`) VALUES (3,1,0,15,0);
