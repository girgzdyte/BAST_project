CREATE TABLE backpack (
  backpack_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  title VARCHAR(64),
  color VARCHAR(15),
  price INT,
  description VARCHAR,
  image VARCHAR(255),
  in_stock INT(20)
);

CREATE TABLE cart (
  cart_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  full_name VARCHAR(64) NOT NULL,
  shipping_address VARCHAR NOT NULL,
  country VARCHAR(32) NOT NULL,
  phone_number VARCHAR NOT NULL,
  email_address VARCHAR(64) NOT NULL
);

CREATE TABLE order_details (
  order_detail_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  cart_id BIGINT NOT NULL,
  backpack_id BIGINT(45) NOT NULL,
  quantity INT(24) NOT NULL
);


ALTER TABLE order_details ADD FOREIGN KEY (cart_id) REFERENCES cart (cart_id);

ALTER TABLE order_details ADD FOREIGN KEY (backpack_id) REFERENCES backpack (backpack_id);

