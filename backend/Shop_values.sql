INSERT INTO `category` (`name`) VALUES ('miejskie');
INSERT INTO `category` (`name`) VALUES ('górskie');
INSERT INTO `category` (`name`) VALUES ('szosowe');
INSERT INTO `category` (`name`) VALUES ('trekingowe');
INSERT INTO `category` (`name`) VALUES ('dziecięce');

INSERT INTO `img` (`url`) VALUES ('assets/images/miejski_damski.jpg');
INSERT INTO `img` (`url`) VALUES ('assets/images/miejski_meski.png');
INSERT INTO `img` (`url`) VALUES ('assets/images/szosowy_XMartin.jpg');
INSERT INTO `img` (`url`) VALUES ('assets/images/szosowy_Bodo.png');
INSERT INTO `img` (`url`) VALUES ('assets/images/gorski.jpg');
INSERT INTO `img` (`url`) VALUES ('assets/images/gorski_Mountain.jpg');


INSERT INTO `product` (`name`, `producer`, `price`, `description`, `category_id_category`, `img_id_img`)
VALUES 
('Rower miejski ALFA A.01 damski', 'Romero', '999.99', 'Wygodny i funkcjonalny damski rower miejski, 

który sprawdza się zarówno na miejskich drogach, jak i poza miastem, także na trudniejszych trasach. 

Dzięki aluminiowej ramie rower jest lekki, trwały i odporny na czynniki zewnętrzne. 
Ergonomiczne siodło wykonane zostało z lekkiej, elastrometrowej pianki. 
Rama : aluminium, rozmiar 21". 
Wielkość koła: 28 cali. Rocznik: 2018.', '1', '1');


INSERT INTO `product` (`name`, `producer`, `price`, `description`,  `category_id_category`, `img_id_img`)
VALUES 
('Rower miejski BETA B.01 męski', 'Romero', '1029.99', 'BETA B.01 ma wszystko, 
czego potrzebuje rower na wycieczki nie tylko 
po miejskich trasach - mniejsze, bardziej zwrotne koła, 
niską lekką ramę, wygodne siodełko, 
przedni amortyzator i amortyzowaną sztycę, 2 hamulce, 7 biegów. 
Dzięki temu jazda jest nie tylko komfortowa, 
ale i dynamiczna. Rama : stalowa. Wielkość koła: 26 cali. 
Rocznik: 2017.', '1', '2');


INSERT INTO `product` (`name`, `producer`, `price`, `description`,  `category_id_category`, `img_id_img`)
VALUES 
('Rower szosowy XMartin unisex', 'XMartin', '2399.99', 'Długodystansowcy i kolarze którzy jeżdżą 
cały rok docenią 
wszystkie potrzebne mocowania do bagażnika i błotników, mocne hamulce tarczowe oraz 
możliwość montażu szerszych opon, 
które przydadzą się podczas nieoczekiwanego objazdu na powrocie do domu.
 
Rama : aluminium. Wielkość koła: 28 cali. Rocznik: 2017.', '3', '3');


INSERT INTO `product` (`name`, `producer`, `price`, `description`,  `category_id_category`, `img_id_img`)
VALUES
('Rower szosowy Bodo unisex', 'Bodo', '4449.99', 'Przystępny rower szosowy z wygodną geometrią ramy idealny na długie jazdy treningowe zarówno dla początkujących,
 jak i ambitnych kolekcjonerów kilometrów.  Bodo ma lekką i sztywną aluminiową ramę i widelec karbonowy,
  który oferuje komfort na nierównych drogach. Rama i widelec przeszły jeden z najcięższych testów w branży
  rowerowej. Rower jest wyposażony w napęd 2 x 11 Shimano 105, który lekko i precyzyjnie zmienia przełożenia,
  oraz ma wystarczające rezerwy na ostre sprinty, czy długie podjazdy.

Rama : aluminium. Wielkość koła: 28 cali. Rocznik: 2017.', '3', '4');


INSERT INTO `product` (`name`, `producer`, `price`, `description`,  `category_id_category`, `img_id_img`)
VALUES
('Rower gorski Ride 342', 'Ride', '2449.99', ' Szutrowe ścieżki, leśne szlaki, wąskie naturalnie ukształtowane
 odcinki oraz specjalnie zaprojektowane szlaki do jazdy MTB - to naturalne środowisko i żywioł tego modelu.
Dzięki antypoślizgowym oponom, amortyzowanemu widelcowi i zrównoważonej pozycji na rowerze, możemy w łatwy sposób
kontrolować jazdę nawet na takich przeszkodach jak kamienie czy też korzenie, a jednocześnie cały czas cieszyć się
dostatecznym komfortem jazdy.

Rama : aluminium. Wielkość koła: 27 cali. Rocznik: 2018.', '2', '5');


INSERT INTO `product` (`name`, `producer`, `price`, `description`,  `category_id_category`, `img_id_img`)
VALUES
('Rower gorski Mountain M2', 'Mountain', '4449.99', ' to propozycja stworzona dla fanów wyścigów XC i maratonów MTB.
 Entuzjaści górskiego ścigania docenią ultralekką ramę z włókna węglowego D84 SL - takiego samego, jak w topowym Levelu TE.
  Dzięki zastosowaniu tak zaawansowanej ramy specjalnie zaprojektowanej przez inżynierów Kross i produkowanej w Polsce,
  Level 14.0 prowadzi się niezwykle precyzyjnie, a moc w pełni przenoszona jest na koła. Szybkości i świetnemu prowadzeniu
  sprzyja też wykorzystanie sztywnej osi tylnego koła w standardzie Boost.

Rama : włókno węglowe. Wielkość koła: 27 cali. Rocznik: 2018.', '2', '6');