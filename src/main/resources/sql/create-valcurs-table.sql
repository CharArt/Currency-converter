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

--Первый блок таблицы датирован 2002.03.02, содержит 17 валют.
--The first block of the table is dated for 2002.03.02, contains 17 currencies.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--1)  Australian Dollar.
values ('R01010', 036,'AUD', 1,'Australian Dollar', '16.0102', '2002-3-2'::date);													      --Australian Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--2)  Pound Sterling of the United Kingdom.
values ('R01035', 826,'GBP', 1,'Pound Sterling of the United Kingdom', '43.8254', '2002-3-2'::date);								      --Pound sterling of the United Kingdom.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--3)  Belarusian Rubles.
values ('R01090', 974,'BYR', 1000,'Belarusian Rubles', '18.4290', '2002-3-2'::date);													  --Belarusian Rubles.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--4)  Danish Crowns.
values ('R01215', 208,'DKK', 10,'Danish Crowns', '36.1010', '2002-3-2'::date);															  --Danish Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--5)  US Dollar.
values ('R01235', 840,'USD', 1,'US Dollar', '30.9436', '2002-3-2'::date);																  --US Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--6)  Euro.
values ('R01239', 978,'EUR', 1,'Euro', '26.8343', '2002-3-2'::date);																	  --Euro.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--7)  Icelandic Crowns.
values ('R01310', 352,'ISK', 100,'Icelandic Crowns', '30.7958', '2002-3-2'::date);														  --Icelandic Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--8)  Kazakhstani Tenge.
values ('R01335', 398,'KZT', 100,'Kazakhstani Tenge', '20.3393', '2002-3-2'::date);													      --Kazakhstani Tenge.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--9)  Canadian Dollar.
values ('R01350', 124,'CAD', 1,'Canadian Dollar', '19.3240', '2002-3-2'::date);														      --Canadian Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--10) Norwegian Crowns.
values ('R01535', 578,'NOK', 10,'Norwegian Crowns', '34.7853', '2002-3-2'::date);														  --Norwegian kroner.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--11) SDR (Special drawing rights).
values ('R01589', 960,'XDR', 1,'SDR (Special drawing rights)', '38.4205', '2002-3-2'::date);									          --SDR (Special drawing rights).
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--12) Singapore Dollar.
values ('R01625', 702,'SGD', 1,'Singapore Dollar', '16.8878', '2002-3-2'::date);														  --The Singapore dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--13) Turkish Lira.
values ('R01700', 792,'TRL', 1000000,'Turkish Lira', '22.2616', '2002-3-2'::date);														  --Turkish Lira.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--14) Ukrainian hryvnias.
values ('R01720', 980,'UAH', 10,'Ukrainian hryvnias', '58.1090', '2002-3-2'::date);														  --Ukrainian hryvnias.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--15) Swedish Crowns.
values ('R01770', 752,'SEK', 10,'Swedish Crowns', '29.5924', '2002-3-2'::date);															  --Swedish Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--16) Swiss Franc.
values ('R01775', 756,'CHF', 10,'Swiss Franc', '18.1861', '2002-3-2'::date);														      --Swiss Franc.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--17) Japanese Yen.
values ('R01820', 392,'JPY', 100,'Japanese Yen', '23.1527', '2002-3-2'::date);															  --Japanese Yen.

--Второй блок таблицы датирован 2002.04.02, содержит 17 валют.
--The second block of the table is dated for 2002.04.02, contains 17 currencies.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--18) Australian Dollar.
values ('R01010', 036,'AUD', 1,'Australian Dollar', '16.6906', '2002-4-2'::date);													      --Australian Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--19) Pound Sterling of the United Kingdom.
values ('R01035', 826,'GBP', 1,'Pound Sterling of the United Kingdom', '44.4854', '2002-4-2'::date);								      --Pound sterling of the United Kingdom.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--20) Belarusian Rubles.
values ('R01090', 974,'BYR', 1000,'Belarusian Rubles', '18.1003', '2002-4-2'::date);													  --Belarusian Rubles.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--21) Danish Crowns.
values ('R01215', 208,'DKK', 10,'Danish Crowns', '36.6539', '2002-4-2'::date);															  --Danish Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--22) US Dollar.
values ('R01235', 840,'USD', 1,'US Dollar', '31.1741', '2002-4-2'::date);																  --US Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--23) Euro.
values ('R01239', 978,'EUR', 1,'Euro', '27.2493', '2002-4-2'::date);																	  --Euro.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--24) Icelandic Crowns.
values ('R01310', 352,'ISK', 100,'Icelandic Crowns', '31.1928', '2002-4-2'::date);														  --Icelandic Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--25) Kazakhstani Tenge.
values ('R01335', 398,'KZT', 100,'Kazakhstani Tenge', '20.4575', '2002-4-2'::date);													      --Kazakhstani Tenge.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--26) Canadian Dollar.
values ('R01350', 124,'CAD', 1,'Canadian Dollar', '19.5241', '2002-4-2'::date);														      --Canadian Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--27) Norwegian Crowns.
values ('R01535', 578,'NOK', 10,'Norwegian Crowns', '35.3400', '2002-4-2'::date);														  --Norwegian Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--28) SDR (Special drawing rights).
values ('R01589', 960,'XDR', 1,'SDR (Special drawing rights)', '38.8713', '2002-4-2'::date);									          --SDR (Special drawing rights).
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--29) Singapore Dollar.
values ('R01625', 702,'SGD', 1,'Singapore Dollar', '16.8782', '2002-4-2'::date);														  --Singapore Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--30) Turkish Lira.
values ('R01700', 792,'TRL', 1000000,'Turkish Lira', '22.9306', '2002-4-2'::date);														  --Turkish Lira.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--31) Ukrainian hryvnias.
values ('R01720', 980,'UAH', 10,'Ukrainian hryvnias', '58.5704', '2002-4-2'::date);														  --Ukrainian hryvnias.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--32) Swedish Crowns.
values ('R01770', 752,'SEK', 10,'Swedish Crowns', '30.1569', '2002-4-2'::date);															  --Swedish Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--33) Swiss Franc.
values ('R01775', 756,'CHF', 10,'Swiss Franc', '18.6025', '2002-4-2'::date);														      --Swiss Franc.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--34) Japanese Yen.
values ('R01820', 392,'JPY', 100,'Japanese Yen', '23.4040', '2002-4-2'::date);															  --Japanese Yen.

--Третий блок таблицы датирован 2002.05.02, содержит 17 валют.
--The third block of the table is dated 2002.05.02, contains 17 currencies.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--35) Australian Dollar
values ('R01010', 036,'AUD', 1,'Australian Dollar', '16.8391', '2002-5-2'::date);													      --Australian Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--36) Pound Sterling of the United Kingdom
values ('R01035', 826,'GBP', 1,'Pound Sterling of the United Kingdom', '45.4481', '2002-5-2'::date);								      --Pound Sterling of the United Kingdom.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--37) Belarusian Rubles
values ('R01090', 974,'BYR', 1000,'Belarusian Rubles', '17.9406', '2002-5-2'::date);													  --Belarusian Rubles.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--38) Danish Crowns
values ('R01215', 208,'DKK', 10,'Danish Crowns', '37.8903', '2002-5-2'::date);															  --Danish Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--39) US Dollar
values ('R01235', 840,'USD', 1,'US Dollar', '31.1951', '2002-5-2'::date);																  --US Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--40) Euro.
values ('R01239', 978,'EUR', 1,'Euro', '28.1785', '2002-4-2'::date);																	  --Euro.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--41) Icelandic Crowns
values ('R01310', 352,'ISK', 100,'Icelandic Crowns', '33.2641', '2002-5-2'::date);														    --Icelandic krona
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--42) Kazakhstani Tenge.
values ('R01335', 398,'KZT', 100,'Kazakhstani Tenge', '20.3975', '2002-5-2'::date);													      --Kazakhstani Tenge.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--43) Canadian Dollar.
values ('R01350', 124,'CAD', 1,'Canadian Dollar', '19.9063', '2002-5-2'::date);														      --Canadian dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--44) Norwegian Crowns.
values ('R01535', 578,'NOK', 10,'Norwegian Crowns', '37.1472', '2002-5-2'::date);														  --Norwegian kroner.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--45) SDR (Special drawing rights).
values ('R01589', 960,'XDR', 1,'SDR (Special drawing rights)', '39,6193', '2002-5-2'::date);									          --SDR (Special drawing rights).
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--46) Singapore Dollar.
values ('R01625', 702,'SGD', 1,'Singapore Dollar', '17.2301', '2002-5-2'::date);														  --Singapore Dollar.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--47) Turkish Lira.
values ('R01700', 792,'TRL', 1000000,'Turkish Lira', '23.2366', '2002-5-2'::date);														  --Turkish Lira.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--48) Ukrainian hryvnias.
values ('R01720', 980,'UAH', 10,'Ukrainian hryvnias', '58.3981', '2002-5-2'::date);														  --Ukrainian hryvnias.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--49) Swedish Crowns.
values ('R01770', 752,'SEK', 10,'Swedish Crowns', '30.5248', '2002-5-2'::date);															  --Swedish Crowns.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--50) Swiss Franc.
values ('R01775', 756,'CHF', 10,'Swiss Franc', '19.2455', '2002-5-2'::date);														      --Swiss Franc.
insert into valcurs (currency_id, currency_numcode, currency_charcode, currency_nominal, currency_name, currency_value, currency_date)--51) Japanese Yen.
values ('R01820', 392,'JPY', 100,'Japanese Yen', '24.3750', '2002-5-2'::date);															  --Japanese Yen.