DROP TABLE IF EXISTS artist_info CASCADE;
DROP TABLE IF EXISTS label CASCADE;
DROP TABLE IF EXISTS album CASCADE;
DROP TABLE IF EXISTS artist_album CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS sale CASCADE;
DROP TABLE IF EXISTS line_item CASCADE;

CREATE TABLE artist_info
(
    artist_id serial,
    artist_name varchar(150) NOT NULL,
    date_of_birth date NOT NULL,
    date_of_death date,
    CONSTRAINT PK_artist_info PRIMARY KEY (artist_id)
);

CREATE TABLE label
(
    label_id SERIAL,
    label_name varchar(150) NOT NULL,
    date_established varchar(50),
    CONSTRAINT PK_label PRIMARY KEY (label_id)
);

CREATE TABLE album
(
    album_id serial,
    album_title varchar(150) NOT NULL,
    artist_id INT NOT NULL,
    label_id int  NOT NULL,
    date_released date NOT NULL,
    length_in_minutes integer NOT NULL,
    price decimal(10, 2) NOT NULL,
    CONSTRAINT PK_album PRIMARY KEY (album_id),
    CONSTRAINT FK_album_01 FOREIGN KEY (artist_id) REFERENCES artist_info (artist_id),
    CONSTRAINT FK_album_02 FOREIGN KEY (label_id) REFERENCES label (label_id)
);



CREATE TABLE customer
(
    customer_id SERIAL,
    customer_name varchar(150) NOT NULL,
    street_address varchar(200),
    phone_number varchar(20),
    email varchar(150) NOT NULL,
    date_of_birth date NOT NULL,
    CONSTRAINT PK_customer PRIMARY KEY (customer_id)
);

CREATE TABLE sale
(
    sale_id serial,
    customer_id int NOT NULL,
    album_id int NOT NULL,
    is_sold boolean NOT NULL,
    sale_date date,
    CONSTRAINT PK_sale PRIMARY KEY (sale_id),
    CONSTRAINT FK_sale_01 FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    CONSTRAINT FK_sale_02 FOREIGN KEY (album_id)
        REFERENCES album (album_id)
);

CREATE TABLE line_item
(
    line_item_id serial,
    sale_id int NOT NULL,
    album_id int NOT NULL,
    quantity int NOT NULL,
    CONSTRAINT PK_line_item PRIMARY KEY (line_item_id),
    CONSTRAINT FK_line_item_01 FOREIGN KEY (sale_id)
        REFERENCES sale (sale_id),
    CONSTRAINT FK_line_item_02 FOREIGN KEY (album_id)
        REFERENCES album (album_id)
);


INSERT INTO artist_info (artist_name, date_of_birth, date_of_death)
VALUES ('Artist 1', '2001-01-01', '2002-02-02'),
       ('Artist 2', '2001-01-01', '2003-03-03'),
       ('Artist 3', '2002-02-02', '2004-04-04')
;

-- Mock data for label table
INSERT INTO label (label_name, date_established)
VALUES ('Label 1', '2001-01-01'),
       ('Label 2 Productions', '2004-04-04'),
       ('Label 3', '2008-08-08')
;

-- Mock data for album table
INSERT INTO album (album_title, artist_id, label_id, date_released, length_in_minutes, price)
VALUES ('Album 1', 1, 1, '2002-02-02', 10, 9.99),
       ('Album 2', 3, 2, '2003-03-03', 50, 9.99),
       ('Album 3', 2, 3, '2004-04-04', 30, 9.99)
;

-- Mock data for customer table
INSERT INTO customer (customer_name, street_address, phone_number, email, date_of_birth)
VALUES ('Customer 1', 'Address 1', '123-555-1234', 'email1@email.com', '1992-03-18'),
       ('Customer 2', 'Address 2', '123-555-2345', 'email2@email.com', '1988-07-25'),
       ('Customer 3', 'Address 3', '123-555-9876', 'email3@email.com', '2000-12-05')
;

-- Mock data for sale table
INSERT INTO sale (customer_id, album_id, is_sold, sale_date)
VALUES (1, 3, false, '2005-02-01'),
       (2, 2, true,  '2022-02-15'),
       (3, 1, false, '2023-05-20')
;

-- Mock data for line_item table
INSERT INTO line_item (sale_id, album_id, quantity)
VALUES (1, 1, 2),
       (1, 2, 1),
       (2, 3, 3),
       (3, 2, 2)
;