-- sifra je admin
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token) values ("marko@mailinator.com", true , "Marko", "Markovic", "ORY3tic/hPfVpVk+bzsAFxgjIEXPNVUVvFEJzpHYWcs=", "2020-05-20", "fD5EfEJiiyj4SRuyVC70bu5rxUtlVC", NULL );
--sifra je 12345
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token) values ("test@test.com", true, "test", "test", "hm3IhDOhsOBGxm/Py6Ca+EMJB1vJuAHiEbmPZcz+wTo=", "2020-06-02", "FaQpklJ3xq5ojPePqItilf7SIlRe1W", NULL);


insert into address values (1, "Novi Sad", "Serbia", "21 000", "Branka Bajica 12");
insert into address values (2, "Novi Sad", "Serbia", "21 000", "Narodnog fronta 64");
insert into address values (3, "Novi Sad", "Serbia", "21 000", "Rumenacka 4");
insert into address values (4, "Beograd", "Serbia", "11 000", "Knez Mihailova 25");
insert into address values (5, "Beograd", "Serbia", "11 000", "Knez Mihailova 87");

insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (1, "Rent a Car NS agency based in Novi Sad has an excellent ratio of price and quality of vehicles. We offer you rental of new cars with complete equipment at extremely favorable rental conditions. We guarantee: professionalism, reliability, safety", "rcarNS@gmail.com", "Rent a Car NS", "+38121447389", 1, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (2, "NS Renting Cars agency based in Novi Sad has an excellent ratio of price and quality of vehicles. We guarantee: professionalism, reliability, safety", "nsrentingcar@gmail.com", "NS Renting Cars", "+38121831664", 2, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (3, "About", "eurorentns@gmail.com", "Euro Rent NS", "+38121233814", 3, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (4, "About", "bgcarrent@gmail.com", "BG Car rent", "+38111744658", 4, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (5, "About", "rentacarBG@gmail.com", "Rent a Car BG", "+38111648331", 5, "011/3298-448");

insert into pricelist values (1, 2000, 2020);
insert into pricelist values (2, 2000, 2020);
insert into pricelist values (3, 2700, 2020);

insert into vehicle values (1, 1, 1, 2, 0, "Description", 4, "Petrol","reno_clio_1.jpg",  "Unlimited","Renault Clio 5", 2017, "20/06/2021", 5, "Economy",1);

insert into vehicle values (2, 1, 0, 2, 0, "Description", 5, "Petrol","ford_fiesta_1.jpg",  "Unlimited", "Ford fiesta", 2015, "12/02/2021", 5, "Medium", 2);

insert into vehicle values (3, 1, 0, 5, 0, "Description", 5, "Diesel","nissan1.jpg",  "Unlimited", "Nissan Qashqai", 2017, "04/11/2020", 5, "Large", 3);


insert into pricelist values (4, 2500, 2020);
insert into pricelist values (5, 1900, 2020);
insert into pricelist values (6, 1700, 2020);
insert into vehicle values (4, 1, 0, 2, 0, "Description", 5, "Petrol", "renault_megan.jpg", "Unlimited", "Renault Megan", 2013, "18/10/2020", 5, "Economy", 4);

insert into vehicle values (5, 1, 0, 5, 0, "Description", 5, "Diesel","citroen_c3.jpg", "Unlimited", "Citroen C3", 2015, "10/05/2021", 5, "Medium", 5);

insert into vehicle values (6, 1, 0, 5, 0, "Description", 5, "Petrol","renault_twingo.jpg", "Unlimited", "Renault Twingo", 2016, "12/06/2021", 4, "Medium", 6);


insert into car_service_vehicles values (1,1);
insert into car_service_vehicles values (1,2);
insert into car_service_vehicles values (1,3);
insert into car_service_vehicles values (1,4);
insert into car_service_vehicles values (2,5);
insert into car_service_vehicles values (2,6);

insert into review values (1, "Super. Odlicne cene!", "2020-04-14", 4.5, 1, 1);
insert into car_service_reviews values (1, 1);

insert into review values (2, "Great service. I will definitely use it again!", "2020-05-20", 5, 1, 2);
insert into car_service_reviews values (2, 2);




