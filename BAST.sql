CREATE TABLE `customers` (
  `customer_id` INT PRIMARY KEY,
  `email` VARCHAR,
  `password` VARCHAR,
  `full_name` VARCHAR,
  `shipping_address` VARCHAR,
  `country` VARCHAR,
  `phone` INT
);

CREATE TABLE `products` (
  `product_id` INT PRIMARY KEY,
  `name` VARCHAR,
  `price` INT,
  `description` VARCHAR(30),
  `image` LONGBLOB,
  `color` VARCHAR,
  `unitsInStock` INT
);

CREATE TABLE `orders` (
  `order_id` INT PRIMARY KEY,
  `customer_id` INT,
  `ammount` INT,
  `shipping_address` VARCHAR,
  `order_email` VARCHAR
);

CREATE TABLE `order_details` (
  `order_detail_id` INT PRIMARY KEY,
  `order_id` INT,
  `product_id` INT,
  `price` INT
);

ALTER TABLE `orders` ADD FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`);

ALTER TABLE `order_details` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);
