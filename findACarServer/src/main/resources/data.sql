-- sifra je admin
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token, fcm_token) values ("marko@mailinator.com", true , "Marko", "Markovic", "ORY3tic/hPfVpVk+bzsAFxgjIEXPNVUVvFEJzpHYWcs=", "2020-05-20", "fD5EfEJiiyj4SRuyVC70bu5rxUtlVC", NULL, NULL);
--sifra je 12345
insert into user  (email, email_verified, first_name, last_name, password, registration_date, salt, token, fcm_token) values ("marko@gmail.com", true, "Marko", "Markovic", "hm3IhDOhsOBGxm/Py6Ca+EMJB1vJuAHiEbmPZcz+wTo=", "2020-06-02", "FaQpklJ3xq5ojPePqItilf7SIlRe1W", NULL, null );


insert into address values (1, "Novi Sad", "Serbia", "21 000", "Branka Bajica 12",45.257563, 19.820307);
insert into address values (2, "Novi Sad", "Serbia", "21 000", "Narodnog fronta 64", 45.238845, 19.830443);
insert into address values (3, "Novi Sad", "Serbia", "21 000", "Rumenacka 4", 45.263395, 19.817527);
insert into address values (4, "Beograd", "Serbia", "11 000", "Knez Mihailova 25", 44.816957, 20.458021);
insert into address values (5, "Beograd", "Serbia", "11 000", "Knez Mihailova 87", 44.820107, 20.453482);

insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (1, "Rent a Car NS agency based in Novi Sad has an excellent ratio of price and quality of vehicles. We offer you rental of new cars with complete equipment at extremely favorable rental conditions. We guarantee: professionalism, reliability, safety", "rcarNS@gmail.com", "Rent a Car NS", "+38121447389", 1, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (2, "NS Renting Cars agency based in Novi Sad has an excellent ratio of price and quality of vehicles. We guarantee: professionalism, reliability, safety", "nsrentingcar@gmail.com", "NS Renting Cars", "+38121831664", 2, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (3, "About", "eurorentns@gmail.com", "Euro Rent NS", "+38121233814", 3, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (4, "About", "bgcarrent@gmail.com", "BG Car rent", "+38111744658", 4, "011/3298-448");
insert into car_service (id, about, email, name, phone, address_id, landline_phone) values (5, "About", "rentacarBG@gmail.com", "Rent a Car BG", "+38111648331", 5, "011/3298-448");

insert into pricelist values (1, 2000, 2020);
insert into pricelist values (2, 2000, 2020);
insert into pricelist values (3, 3200, 2020);

insert into vehicle values (1, 1, 1, 1, 2, 0, "Description", 4, "Petrol","reno_clio_1.jpg",  "Unlimited","Renault Clio 5", 2017, "20/06/2021", 5, "Economy",0,1);

insert into vehicle values (2, 1, 0, 1, 2, 0, "Description", 5, "Petrol","ford_fiesta_1.jpg",  "Unlimited", "Ford fiesta", 2015, "12/02/2021", 5, "Medium",0, 2);

insert into vehicle values (3, 1, 0, 1, 5, 0, "Description", 5, "Diesel","nissan_2.jpg",  "Unlimited", "Nissan Qashqai", 2017, "04/11/2020", 5, "Large",0,3);


insert into pricelist values (4, 2500, 2020);
insert into pricelist values (5, 1900, 2020);
insert into pricelist values (6, 1700, 2020);
insert into vehicle values (4, 1, 0, 1, 2, 0, "Description", 5, "Petrol", "renault_megan.jpg", "Unlimited", "Renault Megan 4", 2013, "18/10/2020", 5, "Economy", 0,4);

insert into vehicle values (5, 1, 0, 2, 5, 0, "Description", 5, "Diesel","citroen_c3.jpg", "Unlimited", "Citroen C3", 2015, "10/05/2021", 5, "Medium", 0,5);

insert into vehicle values (6, 1, 0, 1, 5, 0, "Description", 5, "Petrol","renault_twingo.jpg", "Unlimited", "Renault Twingo", 2016, "12/06/2021", 4, "Medium", 0,6);


insert into car_service_vehicles values (1,1);
insert into car_service_vehicles values (1,2);
insert into car_service_vehicles values (1,3);
insert into car_service_vehicles values (1,4);
insert into car_service_vehicles values (2,5);
insert into car_service_vehicles values (2,6);

insert into review values (1, "Super. Odlicne cene!", "2020-04-14", 4.5, 2);
insert into vehicle_reviews values (1, 1);

insert into review values (2, "Very good", "2020-05-20", 5, 2);
insert into vehicle_reviews values (2, 2);

insert into review values (3, "Great service. I will definitely use it again!", "2020-04-23", 5, 2);
insert into vehicle_reviews values (2, 3);

insert into reservation values (1, "2020-06-11", 14000.0, "2020-06-18",null,2, 1);
insert into user_reservations values (2,1);

insert into reservation values (2, "2020-04-15", 19200.0, "2020-04-21", 3,2, 3);
insert into user_reservations values (2,2);

insert into reservation values (3, "2020-05-23", 22400.0, "2020-05-30",null, 2, 3);
insert into user_reservations values (2,3);

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
