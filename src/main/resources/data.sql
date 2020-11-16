INSERT INTO `rol` (`id`, `rol_name`) VALUES ('1', 'ROLE_ADMIN'), ('2', 'ROLE_USER');

INSERT INTO PLACE (ID, NAME, POPULATION, PROVINCE, STATUS)
VALUES
(1, 'Quilmes', 262379, 'Buenos Aires', 'connected'),
(2, 'La Plata', 193144, 'Buenos Aires', 'not connected'),
(3, 'Berazategui', 1900, 'Buenos Aires', 'not connected'),
(4, 'Rosario', 948312, 'Santa Fe', 'not connected'),
(5, 'Villa La Angostura', 1550, 'Neuquen', 'connected'),
(6, 'Almafuerte', 1800, 'Cordoba', 'not connected'),
(7, 'Rawson', 1800, 'Chubut', 'not connected'),
(8, 'Colon', 1400, 'Entre Rios', 'not connected');


INSERT INTO USER (ID, EMAIL, IMG, NAME, USER_NAME, PWD, POINTS)
VALUES
(1, 'admin@unq.edu.ar', null, 'Administrator', 'admin', '123456', 2000),
(2, 'cristian@unq.edu.ar', null, 'Cristian A', 'crisaranguren', '123456', 1000),
(3, 'juan@unq.edu.ar', null, 'Juan H', 'juanh', '123456', 1000),
(4, 'lucho@unq.edu.ar', null, 'Luis C', 'luchist', '123456', 1000),
(5, 'claudia@unq.edu.ar', null, 'Claudia N', 'claus', '123456', 500),
(6, 'morena@unq.edu.ar', null, 'Morena E', 'morexp', '123456', 3000),
(7, 'oscar@unq.edu.ar', null, 'Oscar C', 'osky', '123456', 500),
(8, 'newuser@unq.edu.ar', null, 'Nuevo Usuario', 'newuser', '123456', 0);

INSERT INTO USER_ROL (USER_ID, ROL_ID)
VALUES
('1', '1'),
('2', '2'), 
('3', '2'),
('4', '2'), 
('5', '2'), 
('6', '2'), 
('7', '2'), 
('8', '2'); 


INSERT INTO PROJECT (ID, END_DATE, FACTOR, IS_OPEN, NAME, PERCENTAGE_FOR_CLOSE, START_DATE, PLACE_ID)
VALUES
(1, {ts '2020-12-20 18:47:52.69'}, 1000, FALSE, 'Proyecto Quilmes', 100, {ts '2020-03-01 00:00:00.33'}, 1),
(2, {ts '2022-12-20 18:47:52.69'}, 2000, TRUE, 'Proyecto La Plata', 100, {ts '2020-03-12 00:00:00.23'}, 2),
(3, {ts '2021-12-20 20:47:52.69'}, 2500, TRUE, 'Proyecto Berazategui', 85, {ts '2020-04-23 00:00:00.42'}, 3),
(4, {ts '2022-12-20 18:47:52.69'}, 2600, TRUE, 'Proyecto Rosario', 95, {ts '2020-03-10 00:00:00.60'}, 4),
(5, {ts '2020-12-22 12:47:52.69'}, 2000, FALSE, 'Proyecto Villa La Angostura', 100, {ts '2020-02-01 00:00:00.30'}, 5),
(6, {ts '2022-12-20 18:47:52.69'}, 4500, TRUE, 'Proyecto Almafuerte', 85, {ts '2020-09-01 00:00:00.40'}, 6),
(7, {ts '2021-12-20 14:47:52.69'}, 6000, TRUE, 'Proyecto Rawson', 90, {ts '2020-09-01 00:00:00.59'}, 7),
(8, {ts '2021-12-20 08:47:52.69'}, 5000, TRUE, 'Proyecto Colon', 100, {ts '2020-07-01 00:00:00.25'}, 8);
 
 
 INSERT INTO DONATION (ID, AMOUNT, COMMENT, DATE, DONOR_ID, PROJECT_ID)
 VALUES
 (1, 2000, 'primera donacion', {ts '2020-08-22 18:47:52.20'} , 1, 1),
 (2, 500, 'segunda donacion', {ts '2020-08-24 12:23:52.21'} , 2, 1),
 (3, 500, 'tercera donacion', {ts '2020-09-05 12:23:52.42'} , 2, 1),
 (4, 500, 'cuarta donacion', {ts '2020-09-10 20:00:52.69'} , 3, 3),
 (5, 500, 'quinta donacion', {ts '2020-09-12 22:03:52.50'} , 4, 3),
 (6, 500, 'sexta donacion', {ts '2020-09-14 14:35:52.10'} , 5, 1),
 (7, 1000, 'septima donacion', {ts '2020-10-18 04:23:52.12'} , 6, 3),
 (8, 500, 'octava donacion', {ts '2020-10-16 22:28:52.69'} , 7, 1),
 (9, 500, 'novena donacion', {ts '2020-10-18 08:35:00.32'} , 5, 2),
 (10, 500, 'decima donacion', {ts '2020-10-20 21:27:50.41'} , 2, 2);
 
 
 INSERT INTO USER_POINTS_MAPPING(USER_ID, POINTS, PROJECT_NAME)
 VALUES
 (1, 2000,'Proyecto Quilmes'),
 (2, 500,'Proyecto Quilmes'),
 (3, 500,'Proyecto Berazategui'),
 (4, 500,'Proyecto Berazategui'),
 (5, 500,'Proyecto Quilmes'),
 (6, 1000,'Proyecto Berazategui'),
 (7, 500,'Proyecto La Plata'),
 (5, 500,'Proyecto La Plata'),
 (2, 500,'Proyecto La Plata');
 
