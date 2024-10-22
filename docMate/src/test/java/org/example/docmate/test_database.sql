BEGIN;

-- Drop sequences and tables if they exist to ensure a clean setup
DROP SEQUENCE IF EXISTS users_sequence CASCADE;
DROP TABLE IF EXISTS _users CASCADE;
DROP TABLE IF EXISTS documents CASCADE;
DROP TABLE IF EXISTS collaborators CASCADE;
DROP TABLE IF EXISTS docu_version CASCADE;
DROP TABLE IF EXISTS comments CASCADE;
DROP TABLE IF EXISTS user_session CASCADE;
DROP TABLE IF EXISTS notifications CASCADE;

-- Recreate sequence
CREATE SEQUENCE users_sequence
    START WITH 1
    INCREMENT BY 1;

-- Create users table
CREATE TABLE _users
(
    user_id    INT PRIMARY KEY DEFAULT nextval('users_sequence'),
    username   VARCHAR(255) NOT NULL UNIQUE,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    role VARCHAR(4),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- Create documents table
CREATE TABLE documents
(
    document_id serial       NOT NULL PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    content     TEXT         NOT NULL,
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    user_id     INT REFERENCES _users (user_id) ON DELETE CASCADE
);

-- Create collaborators table
CREATE TABLE collaborators
(
    collaborator_id serial NOT NULL PRIMARY KEY,
    document_id     INT REFERENCES documents (document_id) ON DELETE CASCADE,
    user_id         INT REFERENCES _users (user_id) ON DELETE CASCADE,
    role            VARCHAR(50),
    created_at      TIMESTAMP
);

-- Create docu_version table
CREATE TABLE docu_version
(
    version_id     serial NOT NULL PRIMARY KEY,
    document_id    INT REFERENCES documents (document_id) ON DELETE CASCADE,
    version_number INT    NOT NULL,
    content        TEXT   NOT NULL,
    created_at     TIMESTAMP
);

-- Create comments table
CREATE TABLE comments
(
    comment_id  serial NOT NULL PRIMARY KEY,
    document_id INT REFERENCES documents (document_id) ON DELETE CASCADE,
    user_id     INT REFERENCES _users (user_id) ON DELETE CASCADE,
    content     TEXT   NOT NULL,
    created_at  TIMESTAMP
);

-- Create user_session table
CREATE TABLE user_session
(
    session_id    serial       NOT NULL PRIMARY KEY,
    user_id       INT REFERENCES _users (user_id) ON DELETE CASCADE,
    session_token VARCHAR(255) NOT NULL,
    created_at    TIMESTAMP,
    expires_at    TIMESTAMP
);

-- Create notifications table
CREATE TABLE notifications
(
    notification_id serial NOT NULL PRIMARY KEY,
    user_id         INT REFERENCES _users (user_id) ON DELETE CASCADE,
    message         TEXT   NOT NULL,
    is_read         BOOLEAN DEFAULT FALSE,
    created_at      TIMESTAMP
);

-- Perform any necessary testing actions or queries here
-- Example: SELECT * FROM _users;

-- End transaction and rollback to clean up after testing
ROLLBACK;
