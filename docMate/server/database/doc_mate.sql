START TRANSACTION;

DROP SEQUENCE IF EXISTS users_sequence CASCADE;
DROP SEQUENCE IF EXISTS documents_sequence CASCADE;
DROP TABLE IF EXISTS _users CASCADE;
DROP TABLE IF EXISTS documents CASCADE;
DROP TABLE IF EXISTS collaborators CASCADE;
DROP TABLE IF EXISTS docu_version CASCADE;
DROP TABLE IF EXISTS comments CASCADE;
DROP TABLE IF EXISTS user_session CASCADE;
DROP TABLE IF EXISTS notifications CASCADE;

-- User sequence for the _users table
CREATE SEQUENCE users_sequence
    START WITH 1
    INCREMENT BY 1;

-- Document sequence for the documents table
CREATE SEQUENCE documents_sequence
    START WITH 1
    INCREMENT BY 1;

-- Collaborators sequence for the collaborators table
CREATE SEQUENCE collaborators_sequence
    START WITH 1
    INCREMENT BY 1;

-- User table
CREATE TABLE _users
(
    user_id    INT PRIMARY KEY DEFAULT nextval('users_sequence'),
    username   VARCHAR(255) NOT NULL UNIQUE,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    role       VARCHAR(4),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- Document table
CREATE TABLE documents
(
    document_id serial PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    content     TEXT         NOT NULL,
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    user_id     INT,
    CONSTRAINT fk_documents_user_id FOREIGN KEY (user_id) REFERENCES _users ON DELETE CASCADE
);

-- Reset the sequence for document_id
SELECT setval('documents_document_id_seq', 1, false);



CREATE TABLE collaborators
(
    collaborator_id INT PRIMARY KEY DEFAULT nextval('collaborators_sequence'),
    document_id     INT,
    user_id         INT,
    role            VARCHAR(50) DEFAULT 'VIEWER', -- Default role can be set as VIEWER
    created_at      TIMESTAMP DEFAULT NOW(), -- Automatically set the creation timestamp
    CONSTRAINT fk_collaborators_document_id FOREIGN KEY (document_id) REFERENCES documents ON DELETE CASCADE,
    CONSTRAINT fk_collaborators_user_id FOREIGN KEY (user_id) REFERENCES _users ON DELETE CASCADE
);


SELECT setval('collaborators_sequence', 1, false);

-- Document version table
CREATE TABLE docu_version
(
    version_id     serial PRIMARY KEY,
    document_id    INT,
    version_number INT    NOT NULL,
    content        TEXT   NOT NULL,
    created_at     TIMESTAMP,
    CONSTRAINT fk_docu_version_document_id FOREIGN KEY (document_id) REFERENCES documents ON DELETE CASCADE
);

-- Comment table
CREATE TABLE comments
(
    comment_id  serial PRIMARY KEY,
    document_id INT,
    user_id     INT,
    content     TEXT NOT NULL,
    created_at  TIMESTAMP,
    CONSTRAINT fk_comments_document_id FOREIGN KEY (document_id) REFERENCES documents ON DELETE CASCADE,
    CONSTRAINT fk_comments_user_id FOREIGN KEY (user_id) REFERENCES _users ON DELETE CASCADE
);

-- User session table
CREATE TABLE user_session
(
    session_id    serial PRIMARY KEY,
    user_id       INT,
    session_token VARCHAR(255) NOT NULL,
    created_at    TIMESTAMP,
    expires_at    TIMESTAMP,
    CONSTRAINT fk_user_session_user_id FOREIGN KEY (user_id) REFERENCES _users ON DELETE CASCADE
);

-- Notification table
CREATE TABLE notifications
(
    notification_id serial PRIMARY KEY,
    user_id         INT REFERENCES _users (user_id) ON DELETE CASCADE,
    message         TEXT NOT NULL,
    is_read         BOOLEAN DEFAULT FALSE,
    created_at      TIMESTAMP,
    CONSTRAINT fk_notification_user_id FOREIGN KEY (user_id) REFERENCES _users ON DELETE CASCADE
);

COMMIT;

select * from documents;

SELECT * FROM _users WHERE user_id = 3;

SELECT * FROM documents WHERE document_id = 3;


ALTER TABLE documents
    ADD COLUMN role VARCHAR(50) DEFAULT 'OWNER';


INSERT INTO _users (username, email, password, role, created_at, updated_at) VALUES
                                                                                 ('alice', 'alice@example.com', '$2a$10$hashedpassword1', 'USER', NOW(), NOW()),
                                                                                 ('bob', 'bob@example.com', '$2a$10$hashedpassword2', 'USER', NOW(), NOW()),
                                                                                 ('charlie', 'charlie@example.com', '$2a$10$hashedpassword3', 'USER', NOW(), NOW());


