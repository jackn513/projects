START TRANSACTION;

-- Drop tables if they exist, using CASCADE to drop dependent objects
DROP TABLE IF EXISTS sale_items CASCADE;
DROP TABLE IF EXISTS sale CASCADE;
DROP TABLE IF EXISTS customer_plants CASCADE;
DROP TABLE IF EXISTS journal CASCADE;
DROP TABLE IF EXISTS wishlist CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS plants CASCADE;

-- plant table information --
CREATE TABLE plants
(
    plant_id          SERIAL,
    name              VARCHAR(100)   NOT NULL,
    scientific_name   VARCHAR(200)   NOT NULL,
    plant_description VARCHAR(500),
    price             DECIMAL(10, 2) NOT NULL,
    image_name        VARCHAR(256),
    water             VARCHAR(500)   NOT NULL,
    light             VARCHAR(999)   NOT NULL,
    humidity          VARCHAR(999)   NOT NULL,
    temp              VARCHAR(999)   NOT NULL,
    toxic             VARCHAR(999)   NOT NULL,
    fun_fact          VARCHAR(999)   NOT NULL,
    CONSTRAINT PK_plants PRIMARY KEY (plant_id)
);

-- customer table --
CREATE TABLE customer
(
    customer_id   SERIAL,
    customer_name VARCHAR(128) NOT NULL,
    profile_bio   VARCHAR(500),
    profile_image VARCHAR(256),
    email         VARCHAR(150) NOT NULL UNIQUE,
    password      VARCHAR(256) NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    role varchar(50) NOT NULL,
    CONSTRAINT PK_customer PRIMARY KEY (customer_id)
);

-- the plants a customer has added to their collection --
CREATE TABLE customer_plants
(
    customer_id INT,
    plant_id    INT,
    CONSTRAINT FK_customer_plant_01 FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    CONSTRAINT FK_customer_plant_02 FOREIGN KEY (plant_id)
        REFERENCES plants (plant_id),
    PRIMARY KEY (customer_id, plant_id)
);

-- customer wishlist for plants --
CREATE TABLE wishlist
(
    wishlist_id SERIAL,
    customer_id INT NOT NULL,
    plant_id    INT NOT NULL,
    added_on    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_wishlist_01 PRIMARY KEY (wishlist_id),
    CONSTRAINT FK_wishlist_01 FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    CONSTRAINT FK_wishlist_02 FOREIGN KEY (plant_id) REFERENCES plants (plant_id)
);

-- customer journal entries for plants --
CREATE TABLE journal
(
    journal_id  SERIAL,
    customer_id INT NOT NULL,
    plant_id    INT NOT NULL,
    entry_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    entry_text  TEXT,
    CONSTRAINT PK_journal_01 PRIMARY KEY (journal_id),
    CONSTRAINT FK_journal_01 FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    CONSTRAINT FK_journal_02 FOREIGN KEY (plant_id) REFERENCES plants (plant_id)
);

-- sales table --
CREATE TABLE sale
(
    sale_id     SERIAL,
    customer_id INT  NOT NULL,
    sale_date   DATE NOT NULL,
    ship_date   DATE,
    CONSTRAINT PK_sale PRIMARY KEY (sale_id),
    CONSTRAINT FK_sale_customer FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
);

-- link sales to plants --
CREATE TABLE sale_items
(
    sale_id  INT NOT NULL,
    plant_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    CONSTRAINT FK_sale_items_sale FOREIGN KEY (sale_id)
        REFERENCES sale (sale_id),
    CONSTRAINT FK_sale_items_plant FOREIGN KEY (plant_id)
        REFERENCES plants (plant_id),
    PRIMARY KEY (sale_id, plant_id)
);

-- Inserting into plants table
INSERT INTO plants (name, scientific_name, plant_description, price, image_name, water, light, humidity, temp, toxic, fun_fact)
VALUES
    ('Monstera Deliciosa', 'Monstera deliciosa', 'A tropical plant with large, split leaves.', 29.99, NULL,
     'Water every 1-2 weeks', 'Bright, indirect light', 'High humidity', '65-85°F', 'Non-toxic', 'Also known as the Swiss Cheese Plant'),

    ('Fiddle Leaf Fig', 'Ficus lyrata', 'A popular houseplant with large, glossy leaves.', 49.99, NULL,
     'Water weekly', 'Bright, indirect light', 'Moderate humidity', '60-75°F', 'Toxic to pets', 'Can grow up to 10 feet tall indoors'),

    ('Snake Plant', 'Sansevieria trifasciata', 'A hardy plant with upright, sword-like leaves.', 19.99, NULL,
     'Water every 2-3 weeks', 'Low to bright indirect light', 'Low to moderate humidity', '55-85°F', 'Non-toxic', 'Also known as Mother-in-Law''s Tongue'),

    ('Pothos', 'Epipremnum aureum', 'An easy-to-care-for vining plant with heart-shaped leaves.', 12.99, NULL,
     'Water weekly', 'Low to bright indirect light', 'Moderate humidity', '60-80°F', 'Toxic to pets', 'One of the most popular indoor plants worldwide'),

    ('Peace Lily', 'Spathiphyllum spp.', 'A flowering plant known for its elegant white blooms and dark green leaves.', 24.99, NULL,
     'Keep soil moist, water weekly', 'Low to moderate indirect light', 'High humidity', '65-80°F', 'Toxic to pets', 'Effective at removing air pollutants'),

    ('ZZ Plant', 'Zamioculcas zamiifolia', 'A low-maintenance plant with shiny, dark green leaves that are thick and waxy.', 24.99, NULL,
     'Water every 2-3 weeks', 'Low to bright indirect light', 'Low humidity', '60-75°F', 'Toxic to pets', 'Can survive in low light conditions'),

    ('Spider Plant', 'Chlorophytum comosum', 'A resilient plant with arching leaves, often producing offshoots or "spiderettes".', 14.99, NULL,
     'Keep soil evenly moist, water weekly', 'Moderate to bright indirect light', 'Average to high humidity', '55-80°F', 'Non-toxic', 'Purifies the air by absorbing toxins'),

    ('Aloe Vera', 'Aloe vera', 'A succulent plant known for its medicinal properties and fleshy, toothed leaves.', 9.99, NULL,
     'Water every 3 weeks', 'Bright, indirect light', 'Low humidity', '60-75°F', 'Toxic to pets', 'Used in skincare for its soothing gel'),

    ('Chinese Money Plant', 'Pilea peperomioides', 'A plant with round, pancake-shaped leaves on long stems, often called the "friendship plant".', 19.99, NULL,
     'Water every 1-2 weeks', 'Moderate to bright indirect light', 'Moderate humidity', '60-75°F', 'Non-toxic', 'Produces small offshoots or "pups"'),

    ('Boston Fern', 'Nephrolepis exaltata', 'A lush fern with arching fronds that give a feathery appearance.', 16.99, NULL,
     'Keep soil consistently moist, water frequently', 'Moderate to bright indirect light', 'High humidity', '60-75°F', 'Non-toxic', 'One of the best air-purifying plants'),

    ('Rubber Plant', 'Ficus elastica', 'A bold plant with glossy leaves that can be green, burgundy, or variegated.', 29.99, NULL,
     'Water weekly', 'Moderate to bright indirect light', 'Moderate humidity', '60-80°F', 'Toxic to pets', 'Originates from Southeast Asia'),

    ('Calathea', 'Calathea spp.', 'A plant known for its decorative foliage with intricate patterns and colors.', 24.99, NULL,
     'Keep soil consistently moist, water regularly', 'Low to moderate indirect light', 'High humidity', '65-75°F', 'Non-toxic', 'Folds its leaves at night'),

    ('Philodendron', 'Philodendron spp.', 'A versatile plant with various leaf shapes and textures, ideal for indoor settings.', 17.99, NULL,
     'Water weekly', 'Low to moderate indirect light', 'Moderate humidity', '65-75°F', 'Toxic to pets', 'Grows well in hanging baskets'),

    ('Schefflera', 'Schefflera spp.', 'A tall plant with compound leaves that can add a tropical touch to any room.', 39.99, NULL,
     'Water weekly', 'Moderate to bright indirect light', 'Moderate to high humidity', '60-75°F', 'Toxic to pets', 'Also known as Umbrella Tree'),

    ('Jade Plant', 'Crassula ovata', 'A succulent with fleshy, oval-shaped leaves that symbolizes good luck and prosperity.', 14.99, NULL,
     'Water every 2-3 weeks', 'Bright light, direct sun if possible', 'Low humidity', '65-75°F', 'Toxic to pets', 'Can live for decades'),

    ('Monstera Adansonii', 'Monstera adansonii', 'A smaller cousin of Monstera deliciosa with fenestrated leaves and trailing vines.', 34.99, NULL,
     'Water every 1-2 weeks', 'Moderate to bright indirect light', 'High humidity', '65-80°F', 'Non-toxic', 'Known as Swiss Cheese Vine'),

    ('Lucky Bamboo', 'Dracaena sanderiana', 'A plant often grown in water, featuring slender stalks and symbolic significance in Feng Shui.', 12.99, NULL,
     'Keep roots submerged in water, change water every 2 weeks', 'Moderate indirect light', 'Moderate humidity', '65-80°F', 'Non-toxic', 'Not actually bamboo'),

    ('String of Pearls', 'Senecio rowleyanus', 'A unique succulent with trailing stems adorned with spherical, bead-like leaves.', 19.99, NULL,
     'Water every 2-3 weeks', 'Bright light, some direct sun', 'Low humidity', '70-85°F', 'Toxic to pets', 'Resembles a string of peas'),

    ('Parlor Palm', 'Chamaedorea elegans', 'A compact palm known for its feathery, arching fronds that thrive in low-light conditions.', 18.99, NULL,
     'Keep soil consistently moist, water regularly', 'Low to moderate indirect light', 'High humidity', '65-75°F', 'Non-toxic', 'Great for beginners'),

    ('Oxalis', 'Oxalis spp.', 'A plant with triangular leaflets that fold up at night, known for its shamrock-shaped leaves.', 16.99, NULL,
     'Keep soil slightly moist, water when top inch feels dry', 'Bright indirect light', 'Average to high humidity', '65-75°F', 'Toxic to pets', 'Also known as Shamrock Plant'),

    ('Thai Constellation Monstera', 'Monstera deliciosa var. Thai Constellation', 'A variegated cultivar of Monstera with striking creamy-white patterns on its leaves.', 99.99, 'thai_constellation_monstera.jpg',
     'Water every 1-2 weeks', 'Bright, indirect light', 'High humidity', '65-85°F', 'Non-toxic', 'Highly sought after for its unique variegation');



-- Inserting into customer table
INSERT INTO customer (customer_name, profile_bio, email, password, profile_image, role)
VALUES ('John Doe', 'Plant enthusiast and gardener.', 'john.doe@example.com', 'password123', 'john_doe.jpg', 'ROLE_USER'),
       ('Jane Smith', 'Loves indoor gardening and tropical plants.', 'jane.smith@example.com', 'securepassword',
        'jane_smith.jpg', 'ROLE_USER'),
       ('Emily Johnson', 'Succulent and cactus collector.', 'emily.johnson@example.com', 'mypassword',
        'emily_johnson.jpg', 'ROLE_USER');

-- Inserting into customer_plants table
INSERT INTO customer_plants (customer_id, plant_id)
VALUES (1, 1),
       (1, 2),
       (2, 3);

-- Inserting into wishlist table
INSERT INTO wishlist (customer_id, plant_id)
VALUES (1, 3),
       (2, 1),
       (3, 2);

-- Inserting into journal table
INSERT INTO journal (customer_id, plant_id, entry_text)
VALUES (1, 1, 'My Monstera Deliciosa is growing new leaves!'),
       (2, 3, 'The Snake Plant is thriving with little care.'),
       (3, 2, 'Fiddle Leaf Fig needs more light, moving it to a brighter spot.');

-- Inserting into sale table with today's date
INSERT INTO sale (customer_id, sale_date, ship_date)
VALUES (1, CURRENT_DATE, CURRENT_DATE + INTERVAL '2 days'),
       (2, CURRENT_DATE, CURRENT_DATE + INTERVAL '2 days'),
       (3, CURRENT_DATE, CURRENT_DATE + INTERVAL '2 days');

-- Inserting into sale_items table
INSERT INTO sale_items (sale_id, plant_id, quantity)
VALUES (1, 1, 2),
       (2, 3, 1),
       (3, 2, 3);

COMMIT;

-- Selecting data:

-- SELECT sale.customer_id, c.customer_name, sale.sale_date, sale.ship_date
-- FROM sale
-- JOIN customer c ON c.customer_id = sale.customer_id;

-- SELECT c.customer_name, p.name, journal.entry_text FROM journal
-- JOIN customer c on c.customer_id = journal.customer_id
-- JOIN plants p on p.plant_id = journal.plant_id


select * from customer

delete from customer where customer_name like '%Jess%'
