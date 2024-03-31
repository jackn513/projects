-- Database: musicDB
--
-- Contains tables for viewing a albums for sale on the Music Library for Fellow Music Lovers site,
-- and its patrons respective carts

START TRANSACTION;

DROP TABLE IF EXISTS artist_info CASCADE;
DROP TABLE IF EXISTS label CASCADE;
DROP TABLE IF EXISTS album CASCADE;
DROP TABLE IF EXISTS artist_album CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS sale CASCADE;
DROP TABLE IF EXISTS line_item CASCADE;
DROP TABLE IF EXISTS cart CASCADE;

CREATE TABLE artist_info
(
    artist_id serial,
    artist_name varchar(150) NOT NULL,
    artist_image varchar(300),
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
    label_id int NOT NULL,
    date_released date NOT NULL,
    length_in_minutes integer NOT NULL,
    price decimal(10, 2) NOT NULL,
    album_image VARCHAR (999),
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
    quantity int NOT NULL DEFAULT(1),
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

INSERT INTO artist_info (artist_name, artist_image, date_of_birth, date_of_death)
VALUES
    ('Lingua Ignota (Kristen Hayter)','https://i.guim.co.uk/img/media/e0fb50801bea34256c906c64d7f8b1ce6e07353e/0_82_5073_3045/master/5073.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=83982ac2c5b511e380744db0d7231e59', '1986-06-17', NULL),
    ('SOPHIE', 'https://media.gq.com/photos/601aca9b827c658252890fd7/1:1/w_1125,h_1125,c_limit/Sophie%20obituary4.jpg','1986-09-17', '2021-01-30'),
    ('Björk', 'https://audioxide.com/api/images/album-artwork/debut-bjork-medium-square.jpg', '1965-09-17', NULL),
    ('Nina Simone', 'https://www.pbs.org/wnet/americanmasters/files/2021/01/HIFTBF_3204966_N.Simone_incontext_promo_AvaTews-scaled.jpg', '1933-02-21', '2003-04-21'),
    ('Yuja Wang', 'https://yt3.googleusercontent.com/ytc/AIdro_lpXblmiHMSFrH5MlULKAoDx4-DOxAAUEp3WeKGzA=s900-c-k-c0x00ffffff-no-rj', '1987-02-10', NULL),
    ('Joe Hisaishi', 'https://yt3.googleusercontent.com/3Wgbh7kEwYvf4asf2564QiUq8HDJyvHpgpnolQtzDQjcvnq02JPER3f3-nn_kA28Qn6vS1YXMw=s900-c-k-c0x00ffffff-no-rj',  '1950-12-06', NULL),
    ('Joni Mitchell', 'https://static01.nyt.com/images/2017/12/03/books/review/03prose/03prose-superJumbo.jpg',  '1943-11-07', NULL),
    ('Carole King', 'https://www.rollingstone.com/wp-content/uploads/2018/06/rs-carole-king-52f11705-1539-4780-bead-d4de6cb56416.jpg', '1942-02-09', NULL),
    ('ANOHNI', 'https://www.metroweekly.com/wp-content/uploads/2023/07/Screenshot-2023-07-07-at-1.31.37-PM.png', '1972-10-24', NULL),
    ('Yo-yo Ma', 'https://hips.hearstapps.com/hmg-prod/images/gettyimages-134506762.jpg', '1955-10-07', NULL),
    ('Hilary Hahn', 'https://images.squarespace-cdn.com/content/v1/64998fac59916f3f79018521/7c96642b-17f4-49fc-8dcb-225218c27314/hilary-hahn.jpg',  '1979-12-27', NULL),
    ('Florence Welch (Florence and the Machine)', 'https://static.standard.co.uk/s3fs-public/thumbnails/image/2018/11/20/10/florence-welch-2011.jpg?width=1200&height=1200&fit=crop',  '1986-08-28', NULL),
    ('Lorde', 'https://cdn.outsideonline.com/wp-content/uploads/2021/08/lorde-central-park_s.jpg', '1996-11-07', NULL),
    ('AURORA', 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/09/12/13/aurora-0.jpg', '1996-06-15', NULL),
    ('Sheku Kanneh-Mason', 'https://www.blackheroesfoundation.org/wp-content/uploads/2021/05/Sheku-Kanneh-Mason%E2%80%8B.jpg', '1999-04-04', NULL),
    ('Grimes', 'https://pyxis.nymag.com/v1/imgs/6b7/c32/bf3dd5331075a775047b1cdc03a4d1ce92-grimes.1x.rsquare.w1400.jpg', '1988-03-17', NULL),
    ('Shakira', 'https://media1.popsugar-assets.com/files/thumbor/68C0fuDCTEUJTl6I5x7xOAoGirk=/fit-in/792x792/filters:format_auto():upscale()/2023/07/27/701/n/1922398/tmp_gY6gWp_1b9edb7ca1bc7ecb_Thumbnail_PS23_07_Entertainment_ShakiraBirthChart_1456x1456.jpg', '1977-02-02', NULL),
    ('Janis Joplin', 'https://hips.hearstapps.com/hmg-prod/images/gettyimages-1257216313.jpg', '1943-01-19', '1970-10-04'),
    ('Rosalía', 'https://hips.hearstapps.com/hmg-prod/images/gettyimages-1193654802.jpg', '1992-11-25', NULL),
    ('Lana Del Rey', 'https://pyxis.nymag.com/v1/imgs/4b9/fb9/74f8a3ed7f600b2081740ae60637ead7ee-lana-del-rey.1x.rsquare.w1400.jpg', '1985-06-21', NULL),
    ('Bad Bunny', 'https://hips.hearstapps.com/hmg-prod/images/bad-bunny-winner-of-the-favorite-male-latin-artist-award-news-photo-1638370238.jpg?crop=0.681xw:1.00xh;0.160xw,0&resize=1200:*', '1994-03-10', NULL),
    ('Elton John', 'https://s.abcnews.com/images/GMA/elton-john-gty-rc-220619_1652967135810_hpMain_1x1_992.jpg', '1947-03-25', NULL),
    ('St. Vincent (Annie Clark)', 'https://www.interviewmagazine.com/wp-content/uploads/2011/11/img-st-vincent_153827260432.jpg', '1982-11-28', NULL),
    ('Mitski', 'https://static01.nyt.com/images/2022/02/04/arts/03mitski-review-02/03mitski-review-02-mediumSquareAt3X.jpg', '1990-01-27', NULL),
    ('Hildur Goðnadottir', 'https://yt3.googleusercontent.com/nPF32-dro0z6k_iBt6mi0Tgj7hp1PizZdg-hNYkKnG0zy-ruTyPWvb-nu3KMKWYekwbHtSmy=s900-c-k-c0x00ffffff-no-rj', '1982-11-04', NULL),
    ('FKA Twigs (Tahlia Barnett)', 'https://media.allure.com/photos/63a470cbe06e45ecab32f45a/1:1/w_3356,h_3356,c_limit/fka%20twigs%20adult%20braces.jpg', '1988-01-16', NULL),
    ('Philip Glass', 'https://www.interviewmagazine.com/wp-content/uploads/2014/02/img-philip-glass_084954719256.jpg', '1937-01-31', NULL),
    ('Sufjan Stevens', 'https://theindyreviewdotcom.files.wordpress.com/2019/06/sufjan-stevens-720x720.jpg', '1975-07-01', NULL),
    ('Adele', 'https://hips.hearstapps.com/hmg-prod/images/adele-attends-the-65th-grammy-awards-at-crypto-com-arena-on-news-photo-1700045909.jpg?crop=0.501xw:0.753xh;0.226xw,0&resize=640:*', '1988-05-05', NULL),
    ('Childish Gambino (Donald Glover)', 'https://yt3.googleusercontent.com/ytc/AIdro_mZm94mCowHIe9XcJa8Kr0xyDQp7yujpX7xFOD4tg=s900-c-k-c0x00ffffff-no-rj', '1983-11-25', NULL),
    ('Phoebe Bridges','https://hips.hearstapps.com/hmg-prod/images/main-photo-phoebe-bridgers-credit-frank-ockenfels-1591955724.jpg?crop=0.668xw:1.00xh;0.165xw,0&resize=1200:*', '1994-08-17', NULL),
    ('Hans Zimmer', 'https://i.scdn.co/image/ab6761610000e5eb371632043a8c12bb7eeeaf9d', '1957-09-12', NULL),
    ('Sevdaliza', 'https://images.genius.com/29fa06631ce87979e517a8d9ee912016.1000x1000x1.jpg', '1987-09-01', NULL),
    ('Moses Sumney', 'https://www.scoope.nl/wp-content/uploads/2023/06/moses-sumney.jpg', '1990-05-19', NULL),
    ('Oneohtrix Point Never (Daniel Lopatin)', 'https://media.pitchfork.com/photos/6454f869d014feef88cca03e/1:1/w_2406,h_2406,c_limit/Daniel-Lopatin.jpg', '1982-07-25', NULL),
    ('Aphex Twin (Richard D. James)', 'https://f4.bcbits.com/img/0032727004_10.jpg', '1971-08-18', NULL),
    ('Maggie Rogers', 'https://media.pitchfork.com/photos/5c3fb067973b5279a8970154/master/pass/maggierogers.jpg', '1994-04-25', NULL)
;

INSERT INTO label (label_name, date_established) VALUES 
	('Profound Lore', '2004-04'),
	('Sargent House', '2006'),
	('One Little Independent Records', '1995'),
	('BMG Rights Management (UK) Limited', '2008'),
	('Deutsche Grammophon GmgH, Berlin', '1898'),
	('Universal Music LLC', '1934'),
	('Warner Records INC', '1958'),
	('Ode Records', '1967'),
	('Secretly Canadian', '1996'),
	('Sony Music Entertainment', '1959'),
	('Polydor Records', '1924'),
	('Universal Music New Zealand Limited', '1965'),
	('Glassnote Entertainment Group LLC', '2007'),
	('Decca Classics', '1929'),
	('Arbutus Records', '2009'),
	('Columbia Records', '1889'),
	('Rimas Entertainment', '2008'),
	('This Record Company Ltd.', '1967'),
	('Loma Vista Recordings', '2012'),
	('Dead Oceans', '2007'),
	('Focus Features LLC', '2002'),
	('Young (FKA Young Turks)', '2006'),
	('Asthmatic Kitty Records', '1999'), 
	('XL Recordings LC', '1989'),
	('McDJ Entertainment', '2011'),
	('WaterTower Music', '2000'),
	('JagJaguwar', '1996'),
	('R&S Records', '1984')
;
INSERT INTO label (label_name) VALUES
	('Debay Sounds LLC'),
	('Twisted Elegance'),
	('Ridge Valley Digital'),
	('MSMSMSM INC')
;
INSERT INTO album (album_title, artist_id, label_id, date_released, length_in_minutes, price, album_image) VALUES
	('Caligula', 1, 1, '2019-07-19', 66, 7.99,
	 'https://m.media-amazon.com/images/I/6195neWWzPL._UF1000,1000_QL80_.jpg'),

	('Sinner Get Ready', 1, 2, '2021-08-06', 55, 7.99,
	 'https://m.media-amazon.com/images/I/91oQ4fEl4BS._UF1000,1000_QL80_.jpg'),

	('Oil of Every Pearls Un-Insides', 2, 31, '2017-06-14', 40, 10.99,
     'https://media.pitchfork.com/photos/648747aaaed875e699bc73ed/master/pass/Sophie.jpg'),

	('Fossora', 3, 2, '2022-11-30', 54, 14.99,
	 'https://media.pitchfork.com/photos/630f5a82d81b4a1c03943188/master/pass/Bjork-Fossora.jpg'),

	('Nina Simone: The Montreux Years (Live)', 4, 3, '2021-05-28', 121, 15.99,
     'https://m.media-amazon.com/images/I/91YL8F+wHRL._UF1000,1000_QL80_.jpg'),

	('The American Project', 5, 4, '2023-03-10', 42, 9.99,
     'https://m.media-amazon.com/images/I/81elXZwOQbL._UF1000,1000_QL80_.jpg'),

	('A Symphonic Celebration...', 6, 5, '2023-06-30', 88, 15.99,
     'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/250086c8-d911-4c55-b617-bf2686799d02.jpg'),

	('Blue', 7, 6, '1971-06-22', 36, 17.99,
     'https://m.media-amazon.com/images/I/81baUpgSr9L._UF1000,1000_QL80_.jpg'),

	('Tapestry', 8, 7, '1971-02-10', 45, 15.99,
     'https://media.pitchfork.com/photos/5df90fbc1dc57a00089529be/master/pass/caroleking.jpg'),

	('HOPELESSNESS', 9, 8, '2016-05-06', 42, 10.99,
     'https://m.media-amazon.com/images/I/71UKENg5yeL._UF1000,1000_QL80_.jpg'),

	('Crouching Tiger, Hidden Dragon', 10, 9, '2000-11-14', 49, 14.99,
     'https://m.media-amazon.com/images/I/81N0mpvB47L._UF1000,1000_QL80_.jpg'),

	('Paris', 11, 4, '2021-03-05', 53, 9.99,
     'https://images.universal-music.de/img/assets/508/508702/4/2048/hilary-hahn-paris.jpg'),

	('Dance Fever (Complete Edition)', 12, 10, '2023-04-21', 62, 14.99,
     'https://i.scdn.co/image/ab67616d0000b2733a10ef0d61ed15315d6b0ef3'),

	('Melodrama', 13, 11, '2017-06-16', 41, 7.99,
     'https://m.media-amazon.com/images/I/71fwgxq0wML._UF1000,1000_QL80_.jpg'),

	('All My Demons Greeting Me as a Friend', 14, 12, '2016-03-11', 47, 7.99,
     'https://m.media-amazon.com/images/I/51Gog8m1x8L._UF1000,1000_QL80_.jpg'),

	('Elgar', 15, 13, '2020-01-10', 69, 7.99,
     'https://m.media-amazon.com/images/I/810aOXdvFqL._UF1000,1000_QL80_.jpg'),

	('Visions', 16, 14, '2012-02-21', 50, 7.99,
     'https://m.media-amazon.com/images/I/71miHIEI9IL._UF1000,1000_QL80_.jpg'),

	('Oral Fixation, Vol.2', 17, 9, '2005-11-28', 50, 10.99,
     'https://m.media-amazon.com/images/I/81dpo1ksHYL._UF1000,1000_QL80_.jpg'),

	('Pearl', 18, 9, '1971-01-11', 34, 14.99,
     'https://m.media-amazon.com/images/I/810nwQrRf0L._UF1000,1000_QL80_.jpg'),

	('EL MAL QUERER', 19, 15, '2018-11-02', 30, 10.99,
     'https://media.pitchfork.com/photos/64b194c24d755736fe4b0d2a/master/pass/Rosalia-El-Mal-Querer.jpg'),

	('Ultraviolence (Deluxe)', 20, 10, '2014-01-01', 69, 15.99,
     'https://m.media-amazon.com/images/I/81ajxpblWYL._UF1000,1000_QL80_.jpg'),

	('Un Verano Sin Ti', 21, 16, '2022-05-06', 82, 14.99,
     'https://m.media-amazon.com/images/I/81C6LV7yNTL._UF1000,1000_QL80_.jpg'),
	('MASSEDUCTION', 23, 18, '2017-10-13', 42, 9.99,
     'https://m.media-amazon.com/images/I/714oYtrkdNL._UF1000,1000_QL80_.jpg'),

	('Goodbye Yellow Brick Road (2014 Remaster)', 22, 17, '1973-10-05', 76, 15.99,
     'https://images.fineartamerica.com/images/artworkimages/mediumlarge/3/1973-goddbye-yellow-brick-road-album-cover-david-lee-thompson.jpg'),

	('Bury Me At Makeout Creek', 24, 19, '2014-11-11', 30, 9.99,
     'https://m.media-amazon.com/images/I/61oLAk3KrcL._UF1000,1000_QL80_.jpg'),

	('Tár', 25, 20, '2022-10-21', 64, 15.99,
     'https://m.media-amazon.com/images/I/615Ja3MlyKL._UF1000,1000_QL80_.jpg'),

	('Magdelene', 26, 21, '2019-11-08', 39, 9.99,
     'https://media.pitchfork.com/photos/645e698710ea75c3530616af/master/w_1280%2Cc_limit/FKA-Twigs-Magdalene.jpg'),

	('Glassworks & Interview with Philip Glass', 27, 9, '2016-12-09', 88, 15.99,
     'https://i.discogs.com/ci2rpiKcN0Ril-WTb91kYICCZ5L3qn74XFNwZiOBihI/rs:fit/g:sm/q:90/h:574/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNzY3/ODAtMTI3NTYxOTEz/Mi5qcGVn.jpeg'),

	('Tonya Harding', 28, 22, '2017-12-08', 9, 5.99,
     'https://media.pitchfork.com/photos/5a318075e807ee3420166365/master/pass/tonya%20harding.jpg'),

	('21', 29, 23, '2011-01-24', 52, 10.99,
     'https://m.media-amazon.com/images/I/61lMwNQGYbL._UF1000,1000_QL80_.jpg'),

	('"Awaken, My Love!"', 30, 24, '2016-12-02', 49, 9.99,
     'https://media.pitchfork.com/photos/65772273239ec61ed8f07f5c/master/w_1280%2Cc_limit/Childish-Gambino-Awaken-My-Love.jpg'),

	('Punisher', 31, 19, '2020-06-17', 41, 7.99,
     'https://media.pitchfork.com/photos/5e8f1c49ecfafc0008428b37/master/pass/Phoebe-Bridgers-Punisher.jpg'),
	('The Dune SketchBook', 32, 25, '2021-09-03', 102, 15.99,
     'https://m.media-amazon.com/images/I/91B637EHz6L._UF1000,1000_QL80_.jpg'),
	('Shabrang', 33, 29, '2020-08-28', 62, 9.99,
     'https://media.pitchfork.com/photos/5f46748da3044e1e655f14a4/master/pass/shabrang_sevdalia.jpg'),

	('Græ', 34, 26, '2020-05-15', 66, 7.99,
     'https://media.pitchfork.com/photos/5eb98004a994f4606de32768/1:1/w_800,h_800,c_limit/græ%20(Part%20Two-%2013%20Two%20Dogs)_Moses%20Sumney.jpg'),

	('Again', 35, 30, '2023-09-29', 57, 7.99,
     'https://media.pitchfork.com/photos/64e567827a86d58a09b09f21/master/w_1280%2Cc_limit/oneohtrix-point-never-again.jpg'),

	('Selected Ambient Works 85-92', 36, 27, '1992-02-12', 75, 9.99,
	 'https://m.media-amazon.com/images/I/51TOvM8vU7L._UF1000,1000_QL80_.jpg'),

	('Surrender', 37, 28, '2022-07-29', 46, 7.99,
	 'https://media.pitchfork.com/photos/624471872afbc1aa4dab0c4c/master/pass/Maggie-Rogers-Surrender.jpg')
;

INSERT INTO customer (customer_name, street_address, phone_number, email, date_of_birth) VALUES
	('Billy Sharp', '20 E 9th Street', '534-980-4463', 'bjosharp@gmail.com', '1997-08-20'),
	('John Doe', '123 Main St', '513-346-1234', 'johndoes357@aol..com', '1990-05-15'),
	('Alice Johnson', '456 Oak Ave', '917-491-5678', 'jalicem78@gmail.com', '1985-09-20'),
	('Bob Smith', '789 Pine Rd', '600-092-9012', 'bob.smithy@gmail.com', '1992-03-10'),
	('Emily Davis', '101 Cedar Ln', '212-565-3456', 'emily.d@yahoo.com', '1988-11-25'),
	('Chris Miller', '202 Maple Dr', '900-102-7890', 'whoischris@gmail.com', '1995-07-18'),
	('Sophia White', '303 Birch Ct', '657-001-2345', 'sophia.white562@hotmail.com', '1983-12-05'),
	('Daniel Brown', '404 Elm Blvd', '351-090-6789', 'dbrownart@aol.com', '1998-02-28'),
	('Olivia Taylor', '505 Walnut Pl', '943-831-1234', 'yatlor@gmail.com', '1980-09-15'),
	('Michael Turner', '606 Pine Rd', '031-737-5678', 'turnerwordmichael@yahoo.com', '1993-06-08'),
	('Ella Martinez', '707 Oak Ave', '900-903-9012', 'ella.m.art@aol.com', '1987-04-30')
;

-- sold albums -- 

-- unsold albums -- 


END TRANSACTION;
COMMIT;

select * from artist_info


