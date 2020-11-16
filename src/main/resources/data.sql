INSERT INTO product (title, color, price, description, image, in_stock) VALUES ('Brownie', 'brown', 109, 'Tamsiai rudos spalvos, vaškinės odos kuprinė. Šios odos privalumas tas, jog laikui bėgant ji apsitrins ir taps tik gražesnė. Matmenys 30x50x20', 'www.google.lt', 5);
INSERT INTO product (title, color, price, description, image, in_stock) VALUES ('Shadow', 'black', 129, 'Juoda perdirbtos odos kuprinė, klasikinio stiliaus. Apdirbimo būdas - koreguotasis. Matmenys 30x40x10', 'www.google.lt', 4);
INSERT INTO product (title, color, price, description, image, in_stock) VALUES ('Milk', 'cream', 129, 'Šviesios augalinio rauginimo odos kuptinė, tvirta bei ilgaamžė, retro stilius. Matmenys 30x60x20', 'www.google.lt', 3);

INSERT INTO orders (full_name, shipping_address, country, phone_number, email_address) VALUES ('Kristina Spucyte', 'Priegliaus g., 10-17, Vilnius', 'Lietuva', '863770972', 'kristina@spucyte.lt');
INSERT INTO orders (full_name, shipping_address, country, phone_number, email_address) VALUES ('Egle Kasnauskaite', 'Staneviciaus g., 22-134, Panemune', 'Anglija', '34363345553', 'kasnauskaite@umr.lt');
INSERT INTO orders (full_name, shipping_address, country, phone_number, email_address) VALUES ('Monika Straukiene', 'Klaipedos g., 199-54, Gargzdai', 'Lietuva', '863998992', 'strauk@braskes.lt');

INSERT INTO order_details (order_id, product_id, quantity) VALUES ((SELECT order_id FROM orders WHERE email_address = 'kristina@spucyte.lt'), (SELECT product_id FROM product WHERE title = 'Brownie'), 1);
INSERT INTO order_details (order_id, product_id, quantity) VALUES ((SELECT order_id FROM orders WHERE email_address = 'kasnauskaite@umr.lt'), (SELECT product_id FROM product WHERE title = 'Shadow'), 2);
INSERT INTO order_details (order_id, product_id, quantity) VALUES ((SELECT order_id FROM orders WHERE email_address = 'strauk@braskes.lt'), (SELECT product_id FROM product WHERE title = 'Milk'), 1);
