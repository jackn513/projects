START TRANSACTION;

DROP TABLE IF EXISTS sale_items;
DROP TABLE IF EXISTS sale;
DROP TABLE IF EXISTS customer_plants;
DROP TABLE IF EXISTS journal;
DROP TABLE IF EXISTS wishlist;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS plants;

-- plant table information --
CREATE TABLE plants (
                        plant_id SERIAL,
                        name VARCHAR(100) NOT NULL,
                        scientific_name VARCHAR(200) NOT NULL,
                        plant_description VARCHAR(500),
                        price DECIMAL(10, 2) NOT NULL,
                        image_name VARCHAR(256),
                        water VARCHAR(500) NOT NULL,
                        light VARCHAR(999) NOT NULL,
                        humidity VARCHAR(999) NOT NULL,
                        temp VARCHAR(999) NOT NULL,
                        toxic VARCHAR(999) NOT NULL,
                        fun_fact VARCHAR(999) NOT NULL,
                        CONSTRAINT PK_plants PRIMARY KEY (plant_id)
);

-- customer table --
CREATE TABLE customer (
                          customer_id SERIAL,
                          customer_name VARCHAR(128) NOT NULL,
                          profile_bio VARCHAR(500),
                          profile_image VARCHAR(256),
                          email VARCHAR(150) NOT NULL UNIQUE,
                          password VARCHAR(256) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT PK_customer PRIMARY KEY (customer_id)
);

-- the plants a customer has added to their collection --
CREATE TABLE customer_plants(
                                customer_id INT,
                                plant_id INT,
                                CONSTRAINT FK_customer_plant_01 FOREIGN KEY (customer_id)
                                    REFERENCES customer(customer_id),
                                CONSTRAINT FK_customer_plant_02 FOREIGN KEY (plant_id)
                                    REFERENCES plants(plant_id),
                                PRIMARY KEY (customer_id, plant_id)
);

-- customer wishlist for plants --
CREATE TABLE wishlist(
                         wishlist_id SERIAL,
                         customer_id INT NOT NULL,
                         plant_id INT NOT NULL,
                         added_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT PK_wishlist_01 PRIMARY KEY (wishlist_id),
                         CONSTRAINT FK_wishlist_01 FOREIGN KEY (customer_id)
                             REFERENCES customer (customer_id),
                         CONSTRAINT FK_wishlist_02 FOREIGN KEY (plant_id) REFERENCES plants (plant_id)
);

-- customer journal entries for plants --
CREATE TABLE journal (
                         journal_id SERIAL,
                         customer_id INT NOT NULL,
                         plant_id INT NOT NULL,
                         entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         entry_text TEXT,
                         CONSTRAINT PK_journal_01 PRIMARY KEY (journal_id),
                         CONSTRAINT FK_journal_01 FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                         CONSTRAINT FK_journal_02 FOREIGN KEY (plant_id) REFERENCES plants(plant_id)
);

-- sales table --
CREATE TABLE sale (
                      sale_id SERIAL,
                      customer_id INT NOT NULL,
                      sale_date DATE NOT NULL,
                      ship_date DATE,
                      CONSTRAINT PK_sale PRIMARY KEY (sale_id),
                      CONSTRAINT FK_sale_customer FOREIGN KEY(customer_id)
                          REFERENCES customer(customer_id)
);

-- link sales to plants --
CREATE TABLE sale_items (
                            sale_id INT NOT NULL,
                            plant_id INT NOT NULL,
                            quantity INT NOT NULL DEFAULT 1,
                            CONSTRAINT FK_sale_items_sale FOREIGN KEY (sale_id)
                                REFERENCES sale(sale_id),
                            CONSTRAINT FK_sale_items_plant FOREIGN KEY (plant_id)
                                REFERENCES plants(plant_id),
                            PRIMARY KEY (sale_id, plant_id)
);

-- Inserting into plants table
INSERT INTO plants (name, scientific_name, plant_description, price, image_name, water, light, humidity, temp, toxic, fun_fact)
VALUES
    ('Monstera Deliciosa', 'Monstera deliciosa', 'A tropical plant with large, split leaves.', 29.99, 'monstera_deliciosa.jpg', 'Water every 1-2 weeks', 'Bright, indirect light', 'High humidity', '65-85°F', 'Non-toxic', 'Also known as the Swiss Cheese Plant'),
    ('Fiddle Leaf Fig', 'Ficus lyrata', 'A popular houseplant with large, glossy leaves.', 49.99, 'fiddle_leaf_fig.jpg', 'Water weekly', 'Bright, indirect light', 'Moderate humidity', '60-75°F', 'Toxic to pets', 'Can grow up to 10 feet tall indoors'),
    ('Snake Plant', 'Sansevieria trifasciata', 'A hardy plant with upright, sword-like leaves.', 19.99, 'snake_plant.jpg', 'Water every 2-3 weeks', 'Low to bright indirect light', 'Low to moderate humidity', '55-85°F', 'Non-toxic', 'Also known as Mother-in-Law''s Tongue');

-- Inserting into customer table
INSERT INTO customer (customer_name, profile_bio, email, password, profile_image)
VALUES
    ('John Doe', 'Plant enthusiast and gardener.', 'john.doe@example.com', 'password123', 'john_doe.jpg'),
    ('Jane Smith', 'Loves indoor gardening and tropical plants.', 'jane.smith@example.com', 'securepassword', 'jane_smith.jpg'),
    ('Emily Johnson', 'Succulent and cactus collector.', 'emily.johnson@example.com', 'mypassword', 'emily_johnson.jpg');

-- Inserting into customer_plants table
INSERT INTO customer_plants (customer_id, plant_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3);

-- Inserting into wishlist table
INSERT INTO wishlist (customer_id, plant_id)
VALUES
    (1, 3),
    (2, 1),
    (3, 2);

-- Inserting into journal table
INSERT INTO journal (customer_id, plant_id, entry_text)
VALUES
    (1, 1, 'My Monstera Deliciosa is growing new leaves!'),
    (2, 3, 'The Snake Plant is thriving with little care.'),
    (3, 2, 'Fiddle Leaf Fig needs more light, moving it to a brighter spot.');

-- Inserting into sale table with today's date
INSERT INTO sale (customer_id, sale_date, ship_date)
VALUES
    (1, CURRENT_DATE, CURRENT_DATE + INTERVAL '2 days'),
    (2, CURRENT_DATE, CURRENT_DATE + INTERVAL '2 days'),
    (3, CURRENT_DATE, CURRENT_DATE + INTERVAL '2 days');

-- Inserting into sale_items table
INSERT INTO sale_items (sale_id, plant_id, quantity)
VALUES
    (1, 1, 2),
    (2, 3, 1),
    (3, 2, 3);

COMMIT;

select sale.customer_id, c.customer_name, sale.sale_date, sale.ship_date from sale
JOIN customer c on c.customer_id = sale.customer_id