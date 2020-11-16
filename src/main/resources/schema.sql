CREATE TABLE product (
  product_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  title VARCHAR(64),
  color VARCHAR(15),
  price INT,
  description VARCHAR,
  image VARCHAR(255),
  in_stock INT(20)
);

CREATE TABLE orders (
  order_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  full_name VARCHAR(64) NOT NULL,
  shipping_address VARCHAR NOT NULL,
  country VARCHAR(32) NOT NULL,
  phone_number VARCHAR NOT NULL,
  email_address VARCHAR(64) NOT NULL
);

CREATE TABLE order_details (
  order_detail_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  order_id BIGINT NOT NULL,
  product_id BIGINT(45) NOT NULL,
  quantity INT(24) NOT NULL
);


ALTER TABLE order_details ADD FOREIGN KEY (order_id) REFERENCES orders (order_id);

ALTER TABLE order_details ADD FOREIGN KEY (product_id) REFERENCES product (product_id);

