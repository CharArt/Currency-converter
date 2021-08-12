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
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --1
values ('CharArtPav','Artem', 'Charykov', 'Pavlovich' , 'ArtPavChar@gmail.com', '$2y$12$lv3EwUK0tDrTgIiMlzu73u3UfMCR0jaow62tZrz3YUmb1mPdojpEa','1993-2-26'::date, now()::timestamp, true);                          --1
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --2
values ('KenElenaVal','Elena', 'Ken', 'Vasilevna', 'ElenaKenVas@gmail.com', '$2y$12$Osr4SSpszmx09VRP5S2nPeQfl6FQxMltWu6AFJ2Bb.l/DMOLy20q6','1992-11-19'::date, now()::timestamp, true);							    --2
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --3
values ('FedAlecsEv','Fedarcov', 'Aleksandr', 'Evgenievich', 'AlekFedEvr@gmail.com', '$2y$12$4F2JFP.ekdJ1F0K/HW47we7EV7dOKSrP/TTNc0aXSLA/oqMIaTldC','1988-10-21'::date, '2020-1-8 09:15:56'::timestamp, true);	    --3
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --4
values ('FedMariaAlecs','Fedarcov', 'Maria', 'Alecsandrovna', 'MariaFedAlec@gmail.com', '$2y$12$ULOsPVzslrKD2G2OK5FTduMOqJ4fWsJTfwm5pWCkD6yVvpwBGBvZu','1993-02-5'::date, '2020-2-12 20:10:23'::timestamp, true);	--4
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --5
values ('Anton1','Anton', 'Prashkin', 'Alecsandrovich', 'AntonPrashAlec@gmail.com', '$2y$12$6i5j5C3.8/mJP1MRk2Z.D.CN3QS3.BdafN5em2wjclqKhL8hp8GoC','1988-2-18'::date, '2020-5-17 01:15:02'::timestamp, true);	    --5
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --6
values ('VictorRotan','Victor', 'Rotanov', 'Vladimirovich', 'VicRotVlad@gmail.com', '$2y$12$FTfzItq/2GY46EBxt69EYO1PGiE6h9aSfsEtrX85MlxlJv9woP42e','1962-12-3'::date, '2020-9-20 12:35:25'::timestamp, true);	    --6
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --7
values ('Elena1','Elena', 'Rotanova', 'Vladimirovna', 'ElenaRotVladr@gmail.com', '$2y$12$IOaPYmopA09PyIcGPJsepeL5YQD.sO4RW8FxUBSfQOIKwaI531pHK','1972-8-11'::date, '2020-9-25 06:45:33'::timestamp, true);		    --7
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --8
values ('Vladimir1','Vladimir', 'Rotanov', 'Fedorovich', 'VladRotFed@gmail.com', '$2y$12$3eJYPoMSv4mibYUq3kr9HeFo9DrPQZ54StA/mhxTI1aNCoIY/mJjK','1937-8-9'::date, '2020-10-12 15:30:21'::timestamp, false);		    --8
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --9
values ('CharPavAnot','Pavel', 'Charykov', 'Anatolievich', 'PavAnatChar@gmail.com', '$2y$12$Qs27YRE8EdrCVH4vQeaHOu2xNCUqEo4cklntq4242eNYzznE5rP0C','1967-3-17'::date,'2020-11-12 17:08:08'::timestamp, true);	    --9
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_email, user_password, user_of_birth, user_created_at, user_is_active)                                                                --10
values ('Irina','Irina', 'Ratanova', 'Konstantinovna', 'IrinaRotKonst@gmail.com', '$2y$12$ekXAoj7ffI/z0UrgLtIwJuY.QG/75RkExKnbPyPsNdItGRLzdc3ua','1967-7-27'::date, '2020-11-30 19:01:48'::timestamp, true);	    --10

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