INSERT INTO `category` (`name`) VALUES ('miejskie');

INSERT INTO `category` (`name`) VALUES ('górskie');

INSERT INTO `category` (`name`) VALUES ('szosowe');

INSERT INTO `category` (`name`) VALUES ('trekingowe');

INSERT INTO `category` (`name`) VALUES ('dziecięce');



INSERT INTO `product` (`name`, `producer`, `price`, `description`, `Category_idCategory`) 
VALUES 
('Rower miejski ALFA A.01 damski', 'Romero', '999.99', 'Wygodny i funkcjonalny damski rower miejski, 

który sprawdza się zarówno na miejskich drogach, jak i poza miastem, także na trudniejszych trasach. 

Dzięki aluminiowej ramie rower jest lekki, trwały i odporny na czynniki zewnętrzne. 
Ergonomiczne siodło wykonane zostało z lekkiej, elastrometrowej pianki. 
Rama : aluminium, rozmiar 21". 
Wielkość koła: 28 cali. Rocznik: 2018.', '1');



INSERT INTO `product` (`name`, `producer`, `price`, `description`, `Category_idCategory`) 
VALUES 
('Rower miejski BETA B.01 męski', 'Romero', '1029.99', 'BETA B.01 ma wszystko, 
czego potrzebuje rower na wycieczki nie tylko 
po miejskich trasach - mniejsze, bardziej zwrotne koła, 
niską lekką ramę, wygodne siodełko, 
przedni amortyzator i amortyzowaną sztycę, 2 hamulce, 7 biegów. 
Dzięki temu jazda jest nie tylko komfortowa, 
ale i dynamiczna. Rama : stalowa. Wielkość koła: 26 cali. 
Rocznik: 2017.', '1');



INSERT INTO `product` (`name`, `producer`, `price`, `description`, `Category_idCategory`) 
VALUES 
('Rower szosowy XMartin unisex', 'XMartin', '2399.99', 'Długodystansowcy i kolarze którzy jeżdżą 
cały rok docenią 
wszystkie potrzebne mocowania do bagażnika i błotników, mocne hamulce tarczowe oraz 
możliwość montażu szerszych opon, 
które przydadzą się podczas nieoczekiwanego objazdu na powrocie do domu.
 
Rama : aluminium. Wielkość koła: 28 cali. Rocznik: 2017.', '3');