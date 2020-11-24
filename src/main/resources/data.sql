INSERT INTO backpack (title, color, price, description, image, in_stock) VALUES ('Rusty', 'brown', 129, 'Šviesiai rudos spalvos, vaškinės odos kuprinė. Šios odos privalumas tas, jog laikui bėgant ji apsitrins ir taps tik gražesnė. Matmenys 30x50x20', '/leather.jpg', 2);
INSERT INTO backpack (title, color, price, description, image, in_stock) VALUES ('Coffin', 'brown', 129, 'Rudos perdirbtos odos kuprinė, klasikinio stiliaus, su dekoracine juosta per vidurį. Apdirbimo būdas - koreguotasis. Matmenys 30x40x10', 'www.google.lt', 3);
INSERT INTO backpack (title, color, price, description, image, in_stock) VALUES ('Kokonas', 'brown', 149, 'Šiurkščios augalinio rauginimo odos kuptinė, tvirta bei ilgaamžė, retro stilius. Matmenys 30x60x20', 'www.google.lt', 1);
INSERT INTO backpack (title, color, price, description, image, in_stock) VALUES ('Minimal', 'brown', 109, 'Tamsiai rudos, storos lakuotos odos kuprinė, minimalistinė. Matmenys 30x60x20', 'www.google.lt', 2);
INSERT INTO backpack (title, color, price, description, image, in_stock) VALUES ('Littleblack', 'black', 129, 'Juoda kaip anglis, nedidelė matinės odos kuprinė. Matmenys 30x60x20', 'www.google.lt', 2);
INSERT INTO backpack (title, color, price, description, image, in_stock) VALUES ('Bean', 'black', 139, 'Sportinio stiliaus, didelė juoda kuprinė per petį.', 'www.google.lt', 1);

INSERT INTO cart (full_name, shipping_address, country, phone_number, email_address) VALUES ('Kristina Spucyte', 'Priegliaus g., 10-17, Vilnius', 'Lietuva', '863770972', 'kristina@spucyte.lt');
INSERT INTO cart (full_name, shipping_address, country, phone_number, email_address) VALUES ('Egle Kasnauskaite', 'Staneviciaus g., 22-134, Panemune', 'Anglija', '34363345553', 'kasnauskaite@umr.lt');
INSERT INTO cart (full_name, shipping_address, country, phone_number, email_address) VALUES ('Monika Straukiene', 'Klaipedos g., 199-54, Gargzdai', 'Lietuva', '863998992', 'strauk@braskes.lt');

INSERT INTO order_details (cart_id, backpack_id, quantity) VALUES ((SELECT cart_id FROM cart WHERE email_address = 'kristina@spucyte.lt'), (SELECT backpack_id FROM backpack WHERE title = 'Rusty'), 1);
INSERT INTO order_details (cart_id, backpack_id, quantity) VALUES ((SELECT cart_id FROM cart WHERE email_address = 'kasnauskaite@umr.lt'), (SELECT backpack_id FROM backpack WHERE title = 'Coffin'), 2);
INSERT INTO order_details (cart_id, backpack_id, quantity) VALUES ((SELECT cart_id FROM cart WHERE email_address = 'strauk@braskes.lt'), (SELECT backpack_id FROM backpack WHERE title = 'Kokonas'), 1);
