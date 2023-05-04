CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    email    VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100)       NOT NULL,
    city     VARCHAR(30)        NULL,
    street   VARCHAR(30)        NULL,
    building VARCHAR(10)        NULL,
    flat     VARCHAR(10)        NULL
);

CREATE TABLE orders
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users (id),
    price   INT    NOT NULL
);

CREATE TABLE passport
(
    user_id BIGINT REFERENCES users (id),
    number  VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE book
(
    id    BIGSERIAL PRIMARY KEY,
    title VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE author
(
    id        BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE book_author
(
    book_id   BIGINT REFERENCES book (id),
    author_id BIGINT REFERENCES author (id)
);

SELECT book.title, author.full_name
FROM book
         JOIN book_author ba on book.id = ba.book_id
         JOIN author on author.id = ba.author_id;

CREATE TABLE car
(
    number      VARCHAR(10) NOT NULL,
    state       VARCHAR(3)  NOT NULL,
    brand       VARCHAR(20) NOT NULL,
    model       VARCHAR(20) NOT NULL,
    description TEXT        NOT NULL,
    PRIMARY KEY (state, number)
)