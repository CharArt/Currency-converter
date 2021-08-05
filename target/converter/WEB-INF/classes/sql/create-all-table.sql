CREATE TABLE "user" (
	user_id BIGSERIAL PRIMARY KEY,
	user_login VARCHAR(50) NOT NULL UNIQUE,
	user_name VARCHAR(50) NOT NULL,
	user_surname VARCHAR(50) NOT NULL,
	user_patronymic VARCHAR(50) NOT NULL,
	user_password VARCHAR(100) NOT NULL,
	user_of_birth DATE NOT NULL,
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

CREATE TABLE valcurs (
	write_id BIGSERIAL PRIMARY KEY,
	currency_id VARCHAR(50) NOT NULL,
	currency_numcode SMALLINT NOT NULL,
	currency_charcode VARCHAR(50) NOT NULL,
	currency_nominal INTEGER NOT NULL,
	currency_name	VARCHAR(50) NOT NULL,
	currency_value VARCHAR(50) NOT NULL,
	currency_date DATE NOT NULL
);

CREATE TABLE history (
	request_id BIGSERIAL PRIMARY KEY,
	write_of_id BIGINT REFERENCES valcurs (write_id),
	write_in_id BIGINT REFERENCES valcurs (write_id),
	user_id BIGINT REFERENCES "user"(user_id) ON DELETE CASCADE,
	date_valcurs DATE,
	date_conversion TIMESTAMP WITH TIME ZONE NOT NULL
);

--Пользователи, тестовая таблица содержит 10 пользователей.Users, the test table  contains 10 users.
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('CharArtPav','Artem', 'Charykov', 'Pavlovich', '$2y$12$lv3EwUK0tDrTgIiMlzu73u3UfMCR0jaow62tZrz3YUmb1mPdojpEa','1993-2-26'::date, now()::timestamp, true);						--1
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('KenElenaVal','Elena', 'Ken', 'Vasilevna', '$2y$12$Osr4SSpszmx09VRP5S2nPeQfl6FQxMltWu6AFJ2Bb.l/DMOLy20q6','1992-11-19'::date, now()::timestamp, true);							--2
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('FedAlecsEv','Fedarcov', 'Aleksandr', 'Evgenievich', '$2y$12$4F2JFP.ekdJ1F0K/HW47we7EV7dOKSrP/TTNc0aXSLA/oqMIaTldC','1988-10-21'::date, '2020-1-8 09:15:56'::timestamp, true);	--3
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('FedMariaAlecs','Fedarcov', 'Maria', 'Alecsandrovna', '$2y$12$ULOsPVzslrKD2G2OK5FTduMOqJ4fWsJTfwm5pWCkD6yVvpwBGBvZu','1993-02-5'::date, '2020-2-12 20:10:23'::timestamp, true);	--4
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('Anton1','Anton', 'Prashkin', 'Alecsandrovich', '$2y$12$6i5j5C3.8/mJP1MRk2Z.D.CN3QS3.BdafN5em2wjclqKhL8hp8GoC','1988-2-18'::date, '2020-5-17 01:15:02'::timestamp, true);		--5
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('VictorRotan','Victor', 'Rotanov', 'Vladimirovich', '$2y$12$FTfzItq/2GY46EBxt69EYO1PGiE6h9aSfsEtrX85MlxlJv9woP42e','1962-12-3'::date, '2020-9-20 12:35:25'::timestamp, true);	--6
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('Elena1','Elena', 'Rotanova', 'Vladimirovna', '$2y$12$IOaPYmopA09PyIcGPJsepeL5YQD.sO4RW8FxUBSfQOIKwaI531pHK','1972-8-11'::date, '2020-9-25 06:45:33'::timestamp, true);			--7
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('Vladimir1','Vladimir', 'Rotanov', 'Fedorovich', '$2y$12$3eJYPoMSv4mibYUq3kr9HeFo9DrPQZ54StA/mhxTI1aNCoIY/mJjK','1937-8-9'::date, '2020-10-12 15:30:21'::timestamp, false);		--8
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('CharPavAnot','Pavel', 'Charykov', 'Anatolievich', '$2y$12$Qs27YRE8EdrCVH4vQeaHOu2xNCUqEo4cklntq4242eNYzznE5rP0C','1967-3-17'::date,'2020-11-12 17:08:08'::timestamp, true);	--9
insert into "user" (user_login, user_name, user_surname, user_patronymic, user_password, user_of_birth, user_created_at, user_is_active)
values ('Irina','Irina', 'Ratanova', 'Konstantinovna', '$2y$12$ekXAoj7ffI/z0UrgLtIwJuY.QG/75RkExKnbPyPsNdItGRLzdc3ua','1967-7-27'::date, '2020-11-30 19:01:48'::timestamp, true);		--10

--Роли пользователей.User roles.
insert into role (role_name) values ('ADMIN');	--1
insert into role (role_name) values ('USER');	--2

--Таблица связи между ролями и пользователями.Table of relationships between roles and users.
insert into user_role (user_id, role_id) values (1, 1);	--CharArtPav-ADMIN
insert into user_role (user_id, role_id) values (2, 1);	--KenElenaVal-ADMIN
insert into user_role (user_id, role_id) values (3, 2);	--FedAlecsEv-USER
insert into user_role (user_id, role_id) values (4, 2);	--FedMariaAlecs-USER
insert into user_role (user_id, role_id) values (5, 2);	--Anton1-USER
insert into user_role (user_id, role_id) values (6, 2);	--VictorRotan-USER
insert into user_role (user_id, role_id) values (7, 2);	--Elena1-USER
insert into user_role (user_id, role_id) values (8, 1);	--Vladimir1-ADMIN
insert into user_role (user_id, role_id) values (9, 2);	--CharPavAnot-USER
insert into user_role (user_id, role_id) values (10, 2);	--Irina-USER

--Первый блок таблицы датирован 2002.03.02, содержит 17 валют.The first block of the table is dated for 2002.03.02, contains 17 currencies.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--1) Австралийский доллар.
values ('R01010', 036,'AUD', 1,'Австралийский доллар', '16,0102', '2002-3-2'::date);													 --Australian dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--2) Фунт стерлингов Соединенного королевства.
values ('R01035', 826,'GBP', 1,'Фунт стерлингов Соединенного королевства', '43,8254', '2002-3-2'::date);								 --Pound sterling of the United Kingdom.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--3) Белорусских рублей.
values ('R01090', 974,'BYR', 1000,'Белорусских рублей', '18,4290', '2002-3-2'::date);													 --Belarusian rubles.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--4) Датских крон.
values ('R01215', 208,'DKK', 10,'Датских крон', '36,1010', '2002-3-2'::date);															 --Danish crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--5) Доллар США.
values ('R01235', 840,'USD', 1,'Доллар США', '30,9436', '2002-3-2'::date);																 --The United States dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--6) Евро.
values ('R01239', 978,'EUR', 1,'Евро', '26,8343', '2002-3-2'::date);																	 --Euro.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--7) Исландских крон.
values ('R01310', 352,'ISK', 100,'Исландских крон', '30,7958', '2002-3-2'::date);														 --Icelandic krona.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--8) Казахстанских тенге.
values ('R01335', 398,'KZT', 100,'Казахстанских тенге', '20,3393', '2002-3-2'::date);													 --Kazakhstani tenge.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--9) Канадский доллар.
values ('R01350', 124,'CAD', 1,'Канадский доллар', '19,3240', '2002-3-2'::date);														 --Canadian dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--10) Норвежских крон.
values ('R01535', 578,'NOK', 10,'Норвежских крон', '34,7853', '2002-3-2'::date);														  --Norwegian kroner.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--11) СДР (специальные права заимствования).
values ('R01589', 960,'XDR', 1,'СДР (специальные права заимствования)', '38,4205', '2002-3-2'::date);									  --SDR (Special drawing rights).
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--12) Сингапурский доллар.
values ('R01625', 702,'SGD', 1,'Сингапурский доллар', '16,8878', '2002-3-2'::date);														  --The Singapore dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--13) Турецких лир.
values ('R01700', 792,'TRL', 1000000,'Турецких лир', '22,2616', '2002-3-2'::date);														  --Turkish liras.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--14) Украинских гривен.
values ('R01720', 980,'UAH', 10,'Украинских гривен', '58,1090', '2002-3-2'::date);														  --The Ukrainian hryvnia.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--15) Шведских крон.
values ('R01770', 752,'SEK', 10,'Шведских крон', '29,5924', '2002-3-2'::date);															  --Swedish kronor.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--16) Швейцарский франк.
values ('R01775', 756,'CHF', 10,'Швейцарский франк', '18,1861', '2002-3-2'::date);														  --Swiss franc.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--17) Японских иен.
values ('R01820', 392,'JPY', 100,'Японских иен', '23,1527', '2002-3-2'::date);															  --Japanese yen.

--Второй блок таблицы датирован 2002.04.02, содержит 17 валют.The second block of the table is dated for 2002.04.02, contains 17 currencies.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--18) Австралийский доллар
values ('R01010', 036,'AUD', 1,'Австралийский доллар', '16,6906', '2002-4-2'::date);													  --Australian dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--19) Фунт стерлингов Соединенного королевства
values ('R01035', 826,'GBP', 1,'Фунт стерлингов Соединенного королевства', '44,4854', '2002-4-2'::date);								  --Pound sterling of the United Kingdom.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--20) Белорусских рублей
values ('R01090', 974,'BYR', 1000,'Белорусских рублей', '18,1003', '2002-4-2'::date);													  --Belarusian rubles.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--21) Датских крон
values ('R01215', 208,'DKK', 10,'Датских крон', '36,6539', '2002-4-2'::date);															  --Danish crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--22) Доллар США
values ('R01235', 840,'USD', 1,'Доллар США', '31,1741', '2002-4-2'::date);																  --The United States dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--23) Евро
values ('R01239', 978,'EUR', 1,'Евро', '27,2493', '2002-4-2'::date);																	  --Euro.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--24) Исландских крон
values ('R01310', 352,'ISK', 100,'Исландских крон', '31,1928', '2002-4-2'::date);														  --Icelandic krona
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--25) Казахстанских тенге
values ('R01335', 398,'KZT', 100,'Казахстанских тенге', '20,4575', '2002-4-2'::date);													  --Kazakhstani tenge.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--26) Канадский доллар
values ('R01350', 124,'CAD', 1,'Канадский доллар', '19,5241', '2002-4-2'::date);														  --Canadian dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--27) Норвежских крон
values ('R01535', 578,'NOK', 10,'Норвежских крон', '35,3400', '2002-4-2'::date);														  --Norwegian kroner.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--28) СДР (специальные права заимствования)
values ('R01589', 960,'XDR', 1,'СДР (специальные права заимствования)', '38,8713', '2002-4-2'::date);									  --SDR (Special drawing rights).
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--29) Сингапурский доллар
values ('R01625', 702,'SGD', 1,'Сингапурский доллар', '16,8782', '2002-4-2'::date);														  --The Singapore dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--30) Турецких лир
values ('R01700', 792,'TRL', 1000000,'Турецких лир', '22,9306', '2002-4-2'::date);														  --Turkish liras.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--31) Украинских гривен
values ('R01720', 980,'UAH', 10,'Украинских гривен', '58,5704', '2002-4-2'::date);														  --The Ukrainian hryvnia.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--32) Шведских крон
values ('R01770', 752,'SEK', 10,'Шведских крон', '30,1569', '2002-4-2'::date);															  --Swedish kronor
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--33) Швейцарский франк
values ('R01775', 756,'CHF', 10,'Швейцарский франк', '18,6025', '2002-4-2'::date);														  --Swiss franc.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--34) Японских иен
values ('R01820', 392,'JPY', 100,'Японских иен', '23,4040', '2002-4-2'::date);															  --Japanese yen.

--Третий блок таблицы датирован 2002.05.02, содержит 17 валют.--The third block of the table is dated 2002.05.02, contains 17 currencies.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--35) Австралийский доллар
values ('R01010', 036,'AUD', 1,'Австралийский доллар', '16,8391', '2002-5-2'::date);													  --Australian dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--36) Фунт стерлингов Соединенного королевства
values ('R01035', 826,'GBP', 1,'Фунт стерлингов Соединенного королевства', '45,4481', '2002-5-2'::date);								  --Pound sterling of the United Kingdom.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--37) Белорусских рублей
values ('R01090', 974,'BYR', 1000,'Белорусских рублей', '17,9406', '2002-5-2'::date);													  --Belarusian rubles.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--38) Датских крон
values ('R01215', 208,'DKK', 10,'Датских крон', '37,8903', '2002-5-2'::date);															  --Danish crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--39) Доллар США
values ('R01235', 840,'USD', 1,'Доллар США', '31,1951', '2002-5-2'::date);																  --The United States dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--40) Евро
values ('R01239', 978,'EUR', 1,'Евро', '28,1785', '2002-4-2'::date);																	  --Euro.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--41) Исландских крон
values ('R01310', 352,'ISK', 100,'Исландских крон', '33,2641', '2002-5-2'::date);														  --Icelandic krona
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--42) Казахстанских тенге
values ('R01335', 398,'KZT', 100,'Казахстанских тенге', '20,3975', '2002-5-2'::date);													  --Kazakhstani tenge.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--43) Канадский доллар
values ('R01350', 124,'CAD', 1,'Канадский доллар', '19,9063', '2002-5-2'::date);														  --Canadian dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--44) Норвежских крон
values ('R01535', 578,'NOK', 10,'Норвежских крон', '37,1472', '2002-5-2'::date);														  --Norwegian kroner.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--45) СДР (специальные права заимствования)
values ('R01589', 960,'XDR', 1,'СДР (специальные права заимствования)', '39,6193', '2002-5-2'::date);									  --SDR (Special drawing rights).
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--46) Сингапурский доллар
values ('R01625', 702,'SGD', 1,'Сингапурский доллар', '17,2301', '2002-5-2'::date);														  --The Singapore dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--47) Турецких лир
values ('R01700', 792,'TRL', 1000000,'Турецких лир', '23,2366', '2002-5-2'::date);														  --Turkish liras.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--48) Украинских гривен
values ('R01720', 980,'UAH', 10,'Украинских гривен', '58,3981', '2002-5-2'::date);														  --The Ukrainian hryvnia.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--49) Шведских крон
values ('R01770', 752,'SEK', 10,'Шведских крон', '30,5248', '2002-5-2'::date);															  --Swedish kronor
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--50) Швейцарский франк
values ('R01775', 756,'CHF', 10,'Швейцарский франк', '19,2455', '2002-5-2'::date);														  --Swiss franc.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--51) Японских иен
values ('R01820', 392,'JPY', 100,'Японских иен', '24,3750', '2002-5-2'::date);															  --Japanese yen.

--The story of the conversion to users
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (5, 	6, 1, '2002-3-2'::date,'2020-12-30 19:02:48'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (22, 23, 1, '2002-4-2'::date,'2020-12-30 19:05:55'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (39, 40, 1, '2002-5-2'::date,'2020-12-30 19:09:15'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (2, 	6, 2, '2002-3-2'::date,'2020-12-29 19:05:50'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (19, 23, 2, '2002-4-2'::date,'2020-12-29 19:08:54'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (36, 40, 2, '2002-5-2'::date,'2020-12-29 19:15:35'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (1, 	8, 3, '2002-3-2'::date,'2020-12-28 19:01:12'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (18, 28, 3, '2002-4-2'::date,'2020-12-28 19:07:25'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (35, 45, 3, '2002-5-2'::date,'2020-12-28 19:13:22'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (1, 	2, 4, '2002-3-2'::date,'2020-12-27 19:00:58'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (18, 19, 4, '2002-4-2'::date,'2020-12-27 19:02:35'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (35, 36, 4, '2002-5-2'::date,'2020-12-27 19:15:21'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (16, 17, 5, '2002-3-2'::date,'2020-12-26 19:03:08'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (33, 34, 5, '2002-4-2'::date,'2020-12-26 19:04:00'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (50, 51, 5, '2002-5-2'::date,'2020-12-26 19:11:20'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (3, 	1, 6, '2002-3-2'::date,'2020-12-25 18:59:55'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (20, 18, 6, '2002-4-2'::date,'2020-12-25 19:01:11'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (37, 35, 6, '2002-5-2'::date,'2020-12-25 19:09:18'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (7, 	8, 7, '2002-3-2'::date,'2020-12-24 19:35:30'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (24, 25, 7, '2002-4-2'::date,'2020-12-24 19:36:33'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (41, 42, 7, '2002-5-2'::date,'2020-12-24 19:37:10'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (6,  17, 8, '2002-3-2'::date,'2020-12-23 19:17:31'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (23, 34, 8, '2002-4-2'::date,'2020-12-23 19:18:35'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (40, 51, 8, '2002-5-2'::date,'2020-12-23 19:19:05'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (17,  6, 9, '2002-3-2'::date,'2020-12-22 19:17:31'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (34, 23, 9, '2002-4-2'::date,'2020-12-22 19:18:35'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (51, 40, 9, '2002-5-2'::date,'2020-12-22 19:19:05'::timestamp);

insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (3, 	1, 10, '2002-3-2'::date,'2020-12-21 19:25:41'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (19, 18, 10, '2002-4-2'::date,'2020-12-21 19:26:11'::timestamp);
insert into history (write_of_id, write_in_id, user_id, date_valcurs, date_conversion) values (45, 35, 10, '2002-5-2'::date,'2020-12-21 19:27:45'::timestamp);
