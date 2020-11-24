CREATE TABLE book (
    id BIGINT IDENTITY PRIMARY KEY,
    title VARCHAR(30) NOT NULL
);

CREATE TABLE author (
    id BIGINT IDENTITY  PRIMARY KEY,
    firstname VARCHAR(30),
    lastname VARCHAR(30) NOT NULL
);

CREATE TABLE client (
    id BIGINT IDENTITY  PRIMARY KEY,
    firstname VARCHAR(30),
    lastname VARCHAR(30) NOT NULL,
    card_number CHAR(9),
    birth_date DATE,
    registration_date DATE
);

CREATE TABLE book_copy (
    id BIGINT IDENTITY PRIMARY KEY,
    release_year SMALLINT,
    book_id BIGINT,
    hire_id BIGINT
);

CREATE TABLE hire (
    id BIGINT IDENTITY  PRIMARY KEY,
    book_copy_id BIGINT NOT NULL,
    client_id BIGINT NOT NULL,
    hire_date DATE,
    return_date DATE,
    is_returned BOOLEAN
);