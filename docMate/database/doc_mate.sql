start transaction;

DROP SEQUENCE IF EXISTS users_sequence cascade ;
drop table if exists _users cascade;
drop table if exists documents cascade;
drop table if exists collaborators cascade;
drop table if exists docu_version cascade;
drop table if exists comments cascade;
drop table if exists user_session cascade;
drop table if exists notifications cascade;

CREATE SEQUENCE users_sequence
    START WITH 1
    INCREMENT BY 1;

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


create table documents
(
    document_id serial       not null primary key,
    title       varchar(100) not null,
    content     text         not null,
    created_at  timestamp,
    updated_at  timestamp,
    user_id     int references _users (user_id) on delete cascade
);

create table collaborators
(
    collaborator_id serial not null primary key,
    document_id     int references documents (document_id) on delete cascade,
    user_id         int references _users (user_id) on delete cascade,
    role            varchar(50),
    created_at      timestamp
);

create table docu_version
(
    version_id     serial not null primary key,
    document_id    int references documents (document_id) on delete cascade,
    version_number int    not null,
    content        text   not null,
    created_at     timestamp
);

create table comments
(
    comment_id  serial not null primary key,
    document_id int references documents (document_id) on delete cascade,
    user_id     int references _users (user_id) on delete cascade,
    content     text   not null,
    created_at  timestamp
);

create table user_session
(
    session_id    serial       not null primary key,
    user_id       int references _users (user_id) on delete cascade,
    session_token varchar(255) not null,
    created_at    timestamp,
    expires_at    timestamp
);

create table notifications
(
    notification_id serial not null primary key,
    user_id         int references _users (user_id) on delete cascade,
    message         text   not null,
    is_read         boolean default false,
    created_at      timestamp
);

commit;


select * from _users