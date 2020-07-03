-- sifra je admin
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token, fcm_token) values ("sara@gmail.com", true , "Sara", "Saric", "ORY3tic/hPfVpVk+bzsAFxgjIEXPNVUVvFEJzpHYWcs=", "2020-05-20", "fD5EfEJiiyj4SRuyVC70bu5rxUtlVC", NULL, NULL);
--sifra je 12345
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token, fcm_token) values ("marko@gmail.com", true, "Marko", "Markovic", "hm3IhDOhsOBGxm/Py6Ca+EMJB1vJuAHiEbmPZcz+wTo=", "2020-06-02", "FaQpklJ3xq5ojPePqItilf7SIlRe1W", NULL, null );
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token, fcm_token) values ("ana@gmail.com", true, "Ana", "Markovic", "hm3IhDOhsOBGxm/Py6Ca+EMJB1vJuAHiEbmPZcz+wTo=", "2020-06-02", "FaQpklJ3xq5ojPePqItilf7SIlRe1W", NULL, null );
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token, fcm_token) values ("john@gmail.com", true, "John", "Doe", "hm3IhDOhsOBGxm/Py6Ca+EMJB1vJuAHiEbmPZcz+wTo=", "2020-06-02", "FaQpklJ3xq5ojPePqItilf7SIlRe1W", NULL, null );
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token, fcm_token) values ("zika@gmail.com", true, "Zika", "Markovic", "hm3IhDOhsOBGxm/Py6Ca+EMJB1vJuAHiEbmPZcz+wTo=", "2020-06-02", "FaQpklJ3xq5ojPePqItilf7SIlRe1W", NULL, null );


insert into address values (1, "Novi Sad", "Serbia", "21 000", "Branka Bajica 12",45.257563, 19.820307);
insert into address values (2, "Novi Sad", "Serbia", "21 000", "Narodnog fronta 64", 45.238845, 19.830443);
insert into address values (3, "Novi Sad", "Serbia", "21 000", "Rumenacka 4", 45.263395, 19.817527);
insert into address values (4, "Beograd", "Serbia", "11 000", "Knez Mihailova 25", 44.816957, 20.458021);
insert into address values (5, "Beograd", "Serbia", "11 000", "Knez Mihailova 87", 44.820107, 20.453482);

insert into address values (6, "Beograd", "Serbia", "11 000", "Cara Nikolaja II 11", 44.797840, 20.476450);
insert into address values (7, "Beograd", "Serbia", "11 000", "Đorđa Stanojevica 11", 44.809650, 20.400560);
insert into address values (8, "Novi Sad", "Serbia", "21 000", "Kisačka 41", 45.263580, 19.838200);
insert into address values (9, "Novi Sad", "Serbia", "21 000", "Narodnog Fronta 10", 45.242030, 19.843250);
insert into address values (10, "Novi Sad", "Serbia", "21 000", "Novosadskog Sajma 35", 45.252460, 19.827010);


insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (1, "Rent a Car NS agency based in Novi Sad has an excellent ratio of price and quality of vehicles. We offer you rental of new cars with complete equipment at extremely favorable rental conditions. We guarantee: professionalism, reliability, safety", "rcarNS@gmail.com", "Rent a Car NS", "+38121447389", 1, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (2, "NS Renting Cars agency based in Novi Sad has an excellent ratio of price and quality of vehicles. We guarantee: professionalism, reliability, safety", "nsrentingcar@gmail.com", "NS Renting Cars", "+38121831664", 2, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (3, "About", "eurorentns@gmail.com", "Euro Rent NS", "+38121233814", 3, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (4, "About", "bgcarrent@gmail.com", "BG Car rent", "+38111744658", 4, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (5, "About", "rentacarBG@gmail.com", "Rent a Car BG", "+38111648331", 5, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (6, "About", "info@martelloplus.com", "Martello Plus", "+38111648331", 6, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (7, "About", "info@goldrentacarbeograd.com", "GOLD Rent A Car Beograd", "+38111648331", 7, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (8, "About", "info@tantumrentacar.com", "Tantum Rent A Car Novi Sad", "+38111648331", 8, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (9, "About", "info@adaggio.com", "Adaggio VIA rent a car Rent A Car Novi Sad", "+38111648331", 9, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (10, "About", "info@sixt.com", "Sixt rent a car", "+38111648331", 10, "011/3298-448");




insert into pricelist values (1, 2000, 2020);
insert into pricelist values (2, 2000, 2020);
insert into pricelist values (3, 3200, 2020);


insert into additional_service values (1, "GPS", 1500);
insert into additional_service values (2, "Child seat", 2000);

insert into car_service_additional_services values (1, 1);
insert into car_service_additional_services values (1, 2);

--insert into car_service_additional_services values (2, 2);

insert into pricelist values (4, 2500, 2020);
insert into pricelist values (5, 1900, 2020);
insert into pricelist values (6, 1700, 2020);
insert into pricelist values (7, 4000, 2020);


insert into vehicle values (1, 1, 1, 1, 2, 0, "Description", 4, "Petrol","reno_clio_1.jpg",  "Unlimited","Renault Clio 5", 2017, "2021-06-20", 5, "Economy",0,1);
insert into vehicle values (2, 1, 0, 1, 2, 0, "Description", 5, "Petrol","ford_fiesta_1.jpg",  "Unlimited", "Ford fiesta", 2015, "2021-02-12", 5, "Medium",0, 2);
insert into vehicle values (3, 1, 0, 1, 5, 0, "Description", 5, "Diesel","nissan_2.jpg",  "Unlimited", "Nissan Qashqai", 2017, "2020-11-04", 5, "Large",0,3);
insert into vehicle values (4, 1, 0, 1, 2, 0, "Description", 5, "Petrol", "renault_megan.jpg", "Unlimited", "Renault Megan 4", 2013, "2020-10-18", 5, "Economy", 0,4);
insert into vehicle values (5, 1, 0, 2, 5, 0, "Description", 5, "Diesel","citroen_c3.jpg", "Unlimited", "Citroen C3", 2015, "2021-05-10", 5, "Medium", 0,5);
insert into vehicle values (6, 1, 0, 1, 5, 0, "Description", 5, "Petrol","renault_twingo.jpg", "Unlimited", "Renault Twingo", 2016, "2021-06-12", 4, "Medium", 0,6);
insert into vehicle values (7, 1, 0, 1, 5, 0, "Description", 5, "Petrol","golf7_1.jpg",  "Unlimited", "Volkswagen Golf 7", 2017, "2021-11-04", 5, "Medium",0,3);
insert into vehicle values (8, 1, 0, 1, 5, 0, "Description", 5, "Petrol","audi_1.jpg",  "Unlimited", "Audi A1", 2017, "2021-11-04", 5, "Medium",0,7);
insert into vehicle values (9, 1, 0, 1, 5, 0, "Description", 5, "Diesel","peugeout108_1.jpg",  "Unlimited", "Peugeot 108", 2017, "2021-11-04", 5, "Economy",0,3);
insert into vehicle values (10, 1, 1, 1, 2, 0, "Description", 4, "Petrol","polo1.jpg",  "Unlimited","Volkswagen Polo", 2020, "2021-06-20", 5, "Economy", 0,4);
insert into vehicle values (11, 1, 0, 1, 2, 0, "Description", 5, "Petrol","skoda1.jpg",  "Unlimited", "Skoda Fabia", 2014, "2021-02-12", 5, "Medium",0, 2);
insert into vehicle values (12, 1, 0, 1, 5, 0, "Description", 5, "Diesel","mini1.jpg",  "Unlimited", "Mini Cooper", 2018, "2020-11-04", 5, "Medium",0, 3);


insert into car_service_vehicles values (1,1);
insert into car_service_vehicles values (1,2);
insert into car_service_vehicles values (1,3);
insert into car_service_vehicles values (1,4);
insert into car_service_vehicles values (2,5);
insert into car_service_vehicles values (2,6);
insert into car_service_vehicles values (1, 7);
insert into car_service_vehicles values (1, 8);
insert into car_service_vehicles values (1, 9);
insert into car_service_vehicles values (4, 10);
insert into car_service_vehicles values (4, 11);
insert into car_service_vehicles values (4, 12);

insert into vehicle_photo values (1, "reno_clio_1.jpg");
insert into vehicle_photo values (2, "reno_clio_2.jpg");
insert into vehicle_photo values (3, "reno_clio_3.jpg");
insert into vehicle_photo values (4, "reno_clio_4.jpg");

insert into vehicle_photo values (5, "ford_fiesta_1");
insert into vehicle_photo values (6, "ford_fiesta_2");
insert into vehicle_photo values (7, "ford_fiesta_3");
insert into vehicle_photo values (8, "ford_fiesta_4");

insert into vehicle_photo values (9, "nissan_2.jpg");
insert into vehicle_photo values (10, "nissan2.jpg");
insert into vehicle_photo values (11, "nissan3.jpg");
insert into vehicle_photo values (12, "nissan4.jpg");

insert into vehicle_photo values (13, "renault_megan.jpg");
insert into vehicle_photo values (14, "renault_megan_2.jpg");
insert into vehicle_photo values (15, "renault_megan_3.jpg");

insert into vehicle_photo values (16, "citroen_c3.jpg");
insert into vehicle_photo values (17, "citroen_c3_2.jpg");
insert into vehicle_photo values (18, "citroen_c3_3.jpg");
insert into vehicle_photo values (19, "citroen_c3_4.jpg");

insert into vehicle_photo values (20, "renault_twingo.jpg");
insert into vehicle_photo values (21, "renault_twingo_2.jpg");
insert into vehicle_photo values (22, "renault_twingo_3.jpg");

insert into vehicle_photo values (23, "golf7_1.jpg");
insert into vehicle_photo values (24, "golf7_2.jpg");
insert into vehicle_photo values (25, "golf7_3.jpg");

insert into vehicle_photo values (26, "audi_1.jpg");
insert into vehicle_photo values (27, "audi_2.jpg");
insert into vehicle_photo values (28, "audi_3.jpg");
insert into vehicle_photo values (29, "audi_4.jpg");

insert into vehicle_photo values (30, "peugeout108_1.jpg");
insert into vehicle_photo values (31, "peugeout108_2.jpg");
insert into vehicle_photo values (32, "peugeout108_3.jpg");
insert into vehicle_photo values (33, "peugeout108_4.jpg");

insert into vehicle_photo values (34, "polo1.jpg");
insert into vehicle_photo values (35, "polo2.jpg");
insert into vehicle_photo values (36, "polo3.jpg");


insert into vehicle_photo values (37, "mini1.jpg");
insert into vehicle_photo values (38, "mini2.jpg");
insert into vehicle_photo values (39, "mini3.jpg");

insert into vehicle_photo values (40, "skoda1.jpg");
insert into vehicle_photo values (41, "skoda2.jpg");
insert into vehicle_photo values (42, "skoda3.jpg");



insert into vehicle_vehicle_photos values (1, 1);
insert into vehicle_vehicle_photos values (1, 2);
insert into vehicle_vehicle_photos values (1, 3);
insert into vehicle_vehicle_photos values (1, 4);

insert into vehicle_vehicle_photos values (2, 5);
insert into vehicle_vehicle_photos values (2, 6);
insert into vehicle_vehicle_photos values (2, 7);
insert into vehicle_vehicle_photos values (2, 8);

insert into vehicle_vehicle_photos values (3, 9);
insert into vehicle_vehicle_photos values (3, 10);
insert into vehicle_vehicle_photos values (3, 11);
insert into vehicle_vehicle_photos values (3, 12);

insert into vehicle_vehicle_photos values (4, 13);
insert into vehicle_vehicle_photos values (4, 14);
insert into vehicle_vehicle_photos values (4, 15);

insert into vehicle_vehicle_photos values (5, 16);
insert into vehicle_vehicle_photos values (5, 17);
insert into vehicle_vehicle_photos values (5, 18);
insert into vehicle_vehicle_photos values (5, 19);

insert into vehicle_vehicle_photos values (6, 20);
insert into vehicle_vehicle_photos values (6, 21);
insert into vehicle_vehicle_photos values (6, 22);

insert into vehicle_vehicle_photos values (7, 23);
insert into vehicle_vehicle_photos values (7, 24);
insert into vehicle_vehicle_photos values (7, 25);

insert into vehicle_vehicle_photos values (8, 26);
insert into vehicle_vehicle_photos values (8, 27);
insert into vehicle_vehicle_photos values (8, 28);
insert into vehicle_vehicle_photos values (8, 29);

insert into vehicle_vehicle_photos values (9, 30);
insert into vehicle_vehicle_photos values (9, 31);
insert into vehicle_vehicle_photos values (9, 32);
insert into vehicle_vehicle_photos values (9, 33);

insert into vehicle_vehicle_photos values (10, 34);
insert into vehicle_vehicle_photos values (10, 35);
insert into vehicle_vehicle_photos values (10, 36);

insert into vehicle_vehicle_photos values (12, 37);
insert into vehicle_vehicle_photos values (12, 38);
insert into vehicle_vehicle_photos values (12, 39);

insert into vehicle_vehicle_photos values (11, 40);
insert into vehicle_vehicle_photos values (11, 41);
insert into vehicle_vehicle_photos values (11, 42);




insert into review values (1, "Super. Odlicne cene!", "2020-04-14", 4.5, 2);
insert into vehicle_reviews values (1, 1);

insert into review values (2, "Very good", "2020-05-20", 5, 2);
insert into vehicle_reviews values (2, 2);

insert into review values (3, "Great service. I will definitely use it again!", "2020-04-23", 5, 2);
insert into vehicle_reviews values (2, 3);

insert into review values (4, "Dobar odnos cene i kvaliteta!", "2019-02-26", 4.5, 2);
insert into vehicle_reviews values (3, 4);

insert into review values (5, "Veoma zadovoljan uslugom", "2019-09-30", 5, 2);
insert into vehicle_reviews values (1, 5);

insert into review values (6, "Great service. I will definitely use it again!", "2020-04-23", 5, 4);
insert into vehicle_reviews values (2, 6);

insert into review values (7, "Excelent service, great price, very pleasant staff, helpful, everything was very correct!", "2019-08-23", 5, 2);
insert into vehicle_reviews values (3, 7);

insert into review values (8, "Hassle free car rental, competitive prices, friendly and professional staff!", "2020-01-19", 5, 3);
insert into vehicle_reviews values (4, 8);

insert into review values (9, "Best cars and excellent prices. Great customer service very helpful!", "2020-01-19", 5, 4);
insert into vehicle_reviews values (1, 9);

insert into review values (10, "Hassle free car rental, competitive prices, friendly and professional staff!", "2020-01-19", 5, 3);
insert into vehicle_reviews values (2, 10);

insert into review values (11, "A neat vehicle and an affordable price. Helpful and friendly staff !", "2020-01-19", 5, 3);
insert into vehicle_reviews values (3, 11);

insert into reservation (id, pick_up_date, pickup_notification_sent, price, return_date, return_notification_sent, review_id, user_id, vehicle_id)  values (1, "2020-06-11",  false, 14000.0, "2020-06-27 16:15", false, null,2, 1 );
insert into reservation  values (2, "2020-04-21", false, 19200.0, "2020-06-27 16:15", false, 3,2, 3);
insert into reservation values (3, "2020-06-27 16:15", false, 22400.0, "2020-06-30",  false, null, 3, 3);
insert into reservation values (4, "2020-03-11",  false, 14000.0, "2020-03-27 16:15", false, null, 2, 1 );
insert into reservation values (5, "2020-04-11",  false, 14000.0, "2020-04-27 16:15", false, null, 4, 1 );
insert into reservation values (6, "2019-05-11",  false, 14000.0, "2019-05-20 16:15", false, null, 2, 2 );
insert into reservation values (7, "2020-06-11",  false, 14000.0, "2020-06-27 16:15", false, null, 2, 3 );
insert into reservation values (8, "2019-07-10",  false, 14000.0, "2019-07-15 16:15", false, null, 3, 1 );
insert into reservation values (9, "2019-07-10",  false, 14000.0, "2019-07-27 16:15", false, null, 4, 4 );
insert into reservation values (10, "2019-08-10",  false, 14000.0, "2019-08-27 16:15", false, null, 2, 4 );
insert into reservation values (11, "2020-07-10",  false, 14000.0, "2020-07-11 16:15", false, null, 1, 4 );
insert into reservation values (12, "2020-08-05",  false, 14000.0, "2020-08-10 13:15", false, null, 2, 4 );

insert into user_reservations values (2, 1);
insert into user_reservations values (2, 2);
insert into user_reservations values (3, 3);
insert into user_reservations values (2, 4);
insert into user_reservations values (4, 5);
insert into user_reservations values (2, 6);
insert into user_reservations values (2, 7);
insert into user_reservations values (3, 8);
insert into user_reservations values (4, 9);
insert into user_reservations values (2, 10);
insert into user_reservations values (1, 11);
insert into user_reservations values (2, 12);
