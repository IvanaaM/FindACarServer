insert into user values (1, "a", "Marko", "Markovic", "a");

insert into address values (1, "Novi Sad", "Serbia", "21 000", "Branka Bajica 12");
insert into address values (2, "Novi Sad", "Serbia", "21 000", "Narodnog fronta 64");
insert into address values (3, "Novi Sad", "Serbia", "21 000", "Rumenacka 4");
insert into address values (4, "Belgrade", "Serbia", "11 000", "Knez Mihailova 25");
insert into address values (5, "Belgrade", "Serbia", "11 000", "Knez Mihailova 87");

insert into car_service values (1, "About", "rcarNS@gmail.com", "Rent a Car NS", "+38121447389", 1);
insert into car_service values (2, "About", "nsrentingcar@gmail.com", "NS Renting Cars", "+38121831664", 2);
insert into car_service values (3, "About", "eurorentns@gmail.com", "Euro Rent NS", "+38121233814", 3);
insert into car_service values (4, "About", "bgcarrent@gmail.com", "BG Car rent", "+38111744658", 4);
insert into car_service values (5, "About", "rentacarBG@gmail.com", "Rent a Car BG", "+38111648331", 5);

insert into vehicle values (1, 1, 1, 2, 0, "Description", 4, "Petrol", "Unlimited", "Renault Clio 5", 2017, "20/06/2021", 5, "Economy", 1);
insert into pricelist values (1, 2000, 2020, 1);
insert into vehicle values (2, 1, 0, 2, 0, "Description", 5, "Petrol", "Unlimited", "Ford fiesta", 2015, "12/02/2021", 5, "Medium", 1);
insert into pricelist values (2, 2000, 2020, 2);
insert into vehicle values (3, 1, 0, 5, 0, "Description", 5, "Diesel", "Unlimited", "Nissan Qashqai", 2017, "04/11/2020", 5, "Large", 1);
insert into pricelist values (3, 2700, 2020, 3);

insert into vehicle values (4, 1, 0, 2, 0, "Description", 5, "Petrol", "Unlimited", "Renault Megan", 2013, "18/10/2020", 5, "Economy", 2);
insert into pricelist values (4, 2500, 2020, 4);
insert into vehicle values (5, 1, 0, 5, 0, "Description", 5, "Diesel", "Unlimited", "Citroen C3", 2015, "10/05/2021", 5, "Medium", 2);
insert into pricelist values (5, 1900, 2020, 5);
insert into vehicle values (6, 1, 0, 5, 0, "Description", 5, "Petrol", "Unlimited", "Renault Twingo", 2016, "12/06/2021", 4, "Medium", 2);
insert into pricelist values (6, 1700, 2020, 6);

insert into review values (1, "Super. Odlicne cene!", "2020-04-14", 4.5, 1);
insert into car_service_reviews values (1, 1);

insert into review values (2, "Great service. I will definitely use it again!", "2020-05-20", 5, 1);
insert into car_service_reviews values (2, 2);




