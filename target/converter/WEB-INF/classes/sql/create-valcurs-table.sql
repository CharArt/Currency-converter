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