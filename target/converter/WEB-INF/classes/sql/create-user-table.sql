CREATE TABLE "user" (
	user_id BIGSERIAL PRIMARY KEY,
	user_login VARCHAR(50) NOT NULL UNIQUE,
	user_name VARCHAR(50) NOT NULL,
	user_surname VARCHAR(50) NOT NULL,
	user_patronymic VARCHAR(50) NOT NULL,
	user_email VARCHAR(100) NOT NULL,
	user_password VARCHAR(100) NOT NULL,
	user_of_birth DATE,
	user_created_at TIMESTAMP WITH TIME ZONE NOT NULL,
	user_is_active BOOLEAN
);

CREATE TABLE role (
	role_id SMALLSERIAL PRIMARY KEY,
	role_name VARCHAR(50) NOT NULL
);

CREATE TABLE user_role (
	user_id BIGSERIAL REFERENCES "user" (user_id)ON DELETE CASCADE,
	role_id INTEGER REFERENCES role(role_id),
	PRIMARY KEY (user_id, role_id)
);

--Пользователи, тестовая таблица содержит 10 пользователей.
--Users, the test table  contains 10 users.
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --1 For password used bcrypt(12) algorithm.
values ('CharArtPav','Artem', 'Charykov', 'Pavlovich' , 'ArtPavChar@gmail.com', '$2a$12$ycUYSXfP1a5Q6tF71oTSDO4i7Mi/LKM8N6fiETqlA3KFqFYs36NXK','1993-2-26'::date, now()::timestamp, true);                          --1 Password: user1
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --2 For password used bcrypt(12) algorithm.
values ('KenElenaVal','Elena', 'Ken', 'Vasilevna', 'ElenaKenVas@gmail.com', '$2a$12$hLAZ.AceyUfKHhRVDlosrulXNeWl2caWItfnFX8NHHMWhVMfC0u1.','1992-11-19'::date, now()::timestamp, true);							    --2 Password: user2
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --3 For password used bcrypt(12) algorithm.
values ('FedAlecsEv','Fedarcov', 'Aleksandr', 'Evgenievich', 'AlekFedEvr@gmail.com', '$2a$12$uDwOHR2H607K3oQmqWLDleSRQMXKiXO95iYVsAxbmfaTATazBr7Vi','1988-10-21'::date, '2020-1-8 09:15:56'::timestamp, true);	    --3 Password: user3
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --4 For password used bcrypt(12) algorithm.
values ('FedMariaAlecs','Fedarcov', 'Maria', 'Alecsandrovna', 'MariaFedAlec@gmail.com', '$2a$12$vwfqXiH7r44DzlPB5kUNgOoJB9TUDJTVHJkLalQcUOUGHWO6O8FvC','1993-02-5'::date, '2020-2-12 20:10:23'::timestamp, true);	--4 Password: user4
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --5 For password used bcrypt(12) algorithm.
values ('Anton1','Anton', 'Prashkin', 'Alecsandrovich', 'AntonPrashAlec@gmail.com', '$2a$12$vM6ii27hkIulOKb6nLR.3.UdIo4xwD.wvbejXvRFQ9/iTURXwIEP6','1988-2-18'::date, '2020-5-17 01:15:02'::timestamp, true);	    --5 Password: user5
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --6 For password used bcrypt(12) algorithm.
values ('VictorRotan','Victor', 'Rotanov', 'Vladimirovich', 'VicRotVlad@gmail.com', '$2a$12$Iztak9llIzmdVdhcA2sYu.DfzAHK7miJBMMrzMMRm6AL4lvRosRPG','1962-12-3'::date, '2020-9-20 12:35:25'::timestamp, true);	    --6 Password: user6
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --7 For password used bcrypt(12) algorithm.
values ('Elena1','Elena', 'Rotanova', 'Vladimirovna', 'ElenaRotVladr@gmail.com', '$2a$12$Y2.4Xzw69EvNVotNSIuEvOWRBx.jOREd6c2MfK3RPl4IF3JEeRgai','1972-8-11'::date, '2020-9-25 06:45:33'::timestamp, true);		    --7 Password: user7
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --8 For password used bcrypt(12) algorithm.
values ('Vladimir1','Vladimir', 'Rotanov', 'Fedorovich', 'VladRotFed@gmail.com', '$2a$12$esqS1Z/U3FzAjwHmP0UpLeovxGHQWuURmdp7d/U3RXsfcf9ohjE62','1937-8-9'::date, '2020-10-12 15:30:21'::timestamp, false);		    --8 Password: user8
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --9 For password used bcrypt(12) algorithm.
values ('CharPavAnot','Pavel', 'Charykov', 'Anatolievich', 'PavAnatChar@gmail.com', '$2a$12$TIig7g5U/JmAKuel/jVZwuK8/NYoPvANQTVopvQIkKZYta7gU4ZPS','1967-3-17'::date,'2020-11-12 17:08:08'::timestamp, true);	    --9 Password: user9
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --10 For password used bcrypt(12) algorithm.
values ('Irina','Irina', 'Ratanova', 'Konstantinovna', 'IrinaRotKonst@gmail.com', '$2a$12$Z3rHO1KnX6dJHfsmsvipCu9nlzq0.HjqjVmIJeKXMChqleOwz7Uoy','1967-7-27'::date, '2020-11-30 19:01:48'::timestamp, true);	    --10 Password: user1

--Роли пользователей.
--User roles.
insert into role (role_name) values ('ADMIN');	--1
insert into role (role_name) values ('USER');	--2

--Таблица связи между ролями и пользователями.
--Table of relationships between roles and users.
insert into user_role (user_id, role_id) values (1, 1);	    --CharArtPav-ADMIN
insert into user_role (user_id, role_id) values (2, 1);	    --KenElenaVal-ADMIN
insert into user_role (user_id, role_id) values (3, 2);	    --FedAlecsEv-USER
insert into user_role (user_id, role_id) values (4, 2);	    --FedMariaAlecs-USER
insert into user_role (user_id, role_id) values (5, 2);	    --Anton1-USER
insert into user_role (user_id, role_id) values (6, 2);	    --VictorRotan-USER
insert into user_role (user_id, role_id) values (7, 2);	    --Elena1-USER
insert into user_role (user_id, role_id) values (8, 1);	    --Vladimir1-ADMIN
insert into user_role (user_id, role_id) values (9, 2);	    --CharPavAnot-USER
insert into user_role (user_id, role_id) values (10, 2);    --Irina-USER