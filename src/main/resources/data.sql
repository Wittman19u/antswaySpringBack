DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    firstname VARCHAR(128),
    lastname VARCHAR(128),
    address VARCHAR(255),
    phone_number VARCHAR(15)
);