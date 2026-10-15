CREATE TABLE IF NOT EXISTS film
(
    id           uuid PRIMARY KEY,
    created_date timestamp,
    name         varchar(255),
    release_year int,
    comment      varchar(1000),
    director     varchar(255),
    duration     int
    );