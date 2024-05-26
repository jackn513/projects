

CREATE TABLE plants (
    plant_id SERIAL,
    name varchar(100) NOT NULL,
    scientific_name VARCHAR(200) NOT NULL,
    plant_description VARCHAR(500),
    price decimal (10, 2) NOT NULL,
    image_name VARCHAR(256),
    water VARCHAR(500) NOT NULL,
--     Light humidity temp toxic fun fact
    CONSTRAINT PK_plants PRIMARY KEY (plant_id)
);


CREATE TABLE customer (
    customer_id SERIAL,
    customer_name VARCHAR (128) NOT NULL,
    profile_bio VARCHAR (500),
    email VARCHAR (150) NOT NULL,
    password VARCHAR (50) NOT NULL,
    CONSTRAINT PK_customer PRIMARY KEY (customer_id)
);

CREATE TABLE sale (
    sale_id serial,
    customer_id INT NOT NULL,
    sale_date date NOT NULL,
    ship_date date,
    CONSTRAINT PK_sale PRIMARY KEY (sale_id),
    CONSTRAINT FK_sale_customer FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);