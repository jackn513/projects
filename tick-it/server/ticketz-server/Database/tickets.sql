BEGIN
    TRANSACTION;

DROP TABLE IF EXISTS attendees CASCADE;
DROP TABLE IF EXISTS analytics CASCADE;
DROP TABLE IF EXISTS promotions CASCADE;
DROP TABLE IF EXISTS tickets CASCADE;
DROP TABLE IF EXISTS ticket_type CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS events CASCADE;
DROP TABLE IF EXISTS organizers CASCADE;

CREATE TABLE organizers
(
    organizer_id   SERIAL PRIMARY KEY NOT NULL,
    organizer_name VARCHAR(255)       NOT NULL,
    organizer_bio  VARCHAR(999)
);

CREATE TABLE events
(
    event_id     SERIAL PRIMARY KEY,
    organizer_id INT,
    event_name   VARCHAR(255) NOT NULL,
    description  TEXT         NOT NULL,
    date         DATE         NOT NULL,
    time TIMESTAMP NULL,
    location     VARCHAR(255) NOT NULL,
    status       VARCHAR(50)  NOT NULL,
    CONSTRAINT FK_event_organizer FOREIGN KEY (organizer_id)
        REFERENCES organizers (organizer_id)
);

CREATE TABLE users
(
    user_id   SERIAL PRIMARY KEY,
    full_name VARCHAR(255)       NOT NULL,
    username  VARCHAR(50) UNIQUE NOT NULL,
    password  VARCHAR(255)       NOT NULL,
    email     VARCHAR(100)       NOT NULL,
    role      VARCHAR(10)        NOT NULL
);

CREATE TABLE ticket_type
(
    type_id           SERIAL PRIMARY KEY NOT NULL,
    event_id          INT                NOT NULL,
    type              VARCHAR(100)       NOT NULL,
    price             DECIMAL(10, 2)     NOT NULL,
    tickets_available INT                NOT NULL,
    CONSTRAINT FK_ticket_event FOREIGN KEY (event_id)
        REFERENCES events (event_id)
);

CREATE TABLE tickets
(
    ticket_id     SERIAL PRIMARY KEY NOT NULL,
    type_id       INT                NOT NULL,
    user_id       INT                NOT NULL,
    purchase_date DATE               NOT NULL,
    qr_code       VARCHAR(255)       NOT NULL,
    CONSTRAINT FK_ticket_type FOREIGN KEY (type_id)
        REFERENCES ticket_type (type_id),
    CONSTRAINT FK_ticket_user FOREIGN KEY (user_id)
        REFERENCES users (user_id)
);

CREATE TABLE attendees
(
    attendee_id   SERIAL PRIMARY KEY NOT NULL,
    ticket_id     INT                NOT NULL,
    user_id       INT                NOT NULL,
    check_in_date DATE               NOT NULL,
    CONSTRAINT FK_attendee_ticket FOREIGN KEY (ticket_id)
        REFERENCES tickets (ticket_id),
    CONSTRAINT FK_attendee_user FOREIGN KEY (user_id)
        REFERENCES users (user_id)
);

CREATE TABLE promotions
(
    promotion_id SERIAL PRIMARY KEY NOT NULL,
    event_id     INT                NOT NULL,
    code         VARCHAR(20)        NOT NULL,
    discount     VARCHAR(255)       NOT NULL,
    start_date   DATE               NOT NULL,
    end_date     DATE               NOT NULL,
    CONSTRAINT FK_promotion_event FOREIGN KEY (event_id)
        REFERENCES events (event_id)
);

CREATE TABLE analytics
(
    analytics_id      SERIAL PRIMARY KEY NOT NULL,
    event_id          INT                NOT NULL,
    ticket_sold_total INT                NOT NULL,
    total_revenue     DECIMAL(10, 2)     NOT NULL,
    date_generated    DATE               NOT NULL,
    CONSTRAINT FK_analytics_event FOREIGN KEY (event_id)
        REFERENCES events (event_id)
);

END;

-- Inserting data into organizers table
INSERT INTO organizers (organizer_name, organizer_bio)
VALUES ('Event Management Solutions', 'A company specializing in organizing corporate events.'),
       ('Music Festivals Inc.', 'Organizers of large-scale music festivals worldwide.'),
       ('Sports Events Unlimited', 'Bringing sports events and tournaments to enthusiasts.'),
       ('Artists For Change', 'A coalition of arises imagining a better future'),
       ('Books with James', 'My weekly book club.'),
       ('Accessibility of the Future', 'Including accessibility for all those who need it'),
       ('On the River', 'A Music venue dedicated to bringing the newest and most popular artists to the stage');

-- Inserting data into events table with random times
INSERT INTO events (organizer_id, event_name, description, date, time, location, status)
VALUES
    (1, 'Mastering Corporate Event Planning Workshop', 'Learn the essentials of planning successful corporate events in this intensive workshop.',
     '2024-08-15', '2024-08-15 09:00:00', 'Event Management Solutions Headquarters, New York', 'UPCOMING'),

    (2, 'Summer Vibes Music Festival 2024', 'Join us for a weekend of music, food, and fun under the sun at the biggest music festival of the year!',
     '2024-07-28', '2024-07-28 12:00:00', 'Central Park, New York City', 'UPCOMING'),
    (2, 'Rocktoberfest 2024', 'Celebrate rock music''s greatest hits at this annual festival featuring legendary bands and emerging artists.',
     '2024-10-12', '2024-10-12 16:00:00', 'Los Angeles Memorial Coliseum, Los Angeles', 'PLANNED'),

    (3, 'Basketball Tournament Finals', 'Witness the excitement as top teams battle for the championship title in this thrilling basketball tournament.',
     '2024-09-14', '2024-09-14 18:00:00', 'Madison Square Garden, New York City', 'PLANNED'),
    (3, 'Marathon Challenge 2024', 'Run the scenic route through the city and compete against fellow runners in this annual marathon event.',
     '2024-11-02', '2024-11-02 07:00:00', 'Citywide, Chicago', 'PLANNED'),

    (4, 'Art Exhibition: Visionaries of Tomorrow', 'Explore visionary artworks from diverse artists envisioning a better future through their creations.',
     '2024-08-05', '2024-08-05 10:00:00', 'Metropolitan Museum of Art, New York City', 'UPCOMING'),
    (4, 'Performance Showcase: Voices for Change', 'Experience powerful performances by artists advocating for social and environmental change.',
     '2024-09-21', '2024-09-21 19:30:00', 'National Theatre, Washington D.C.', 'PLANNED'),

    (5, 'Weekly Book Club Meeting', 'Join us for an insightful discussion on the latest book of the week led by James and fellow book enthusiasts.',
     '2024-07-19', '2024-07-19 18:30:00', 'Local Coffee Shop, Boston', 'UPCOMING'),
    (5, 'Special Author Talk: Insights into Writing', 'Meet bestselling author John Smith as he shares his journey and insights into the world of writing.',
     '2024-08-02', '2024-08-02 17:00:00', 'Public Library, San Francisco', 'UPCOMING'),

    (6, 'Accessibility Summit 2024', 'Collaborate with experts to advance accessibility solutions for a more inclusive future.',
     '2024-10-08', '2024-10-08 09:00:00', 'Tech Hub, Seattle', 'PLANNED'),
    (6, 'Workshop: Designing for Accessibility', 'Learn practical strategies and tools for designing accessible products and environments.',
     '2024-11-15', '2024-11-15 13:00:00', 'Innovation Center, Austin', 'PLANNED'),

    (7, 'Summer Concert Series Kickoff', 'Celebrate the start of summer with live performances by emerging artists on the scenic riverfront stage.',
     '2024-07-25', '2024-07-25 20:00:00', 'Riverside Park Amphitheater, Chicago', 'UPCOMING'),
    (7, 'Country Music Night Under the Stars', 'Enjoy an evening of country music hits performed by local and national artists.',
     '2024-08-30', '2024-08-30 19:00:00', 'Riverfront Pavilion, Nashville', 'PLANNED');

SELECT events.organizer_id, organizer_name, event_name, description, date, time, location, status
FROM events
         JOIN organizers o ON events.organizer_id = o.organizer_id;
