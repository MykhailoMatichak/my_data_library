CREATE TABLE IF NOT EXISTS manga
(
    id           uuid PRIMARY KEY,
    created_date timestamp,
    name         varchar(255),
    release_year int,
    comment      varchar(1000),
    author       varchar(255)
    );