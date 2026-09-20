CREATE TABLE IF NOT EXISTS book (
                      id UUID PRIMARY KEY,
                      created_date TIMESTAMP,
                      name VARCHAR(255) NOT NULL,
                      release_year INT,
                      comment VARCHAR(1000),
                      pages INT,
                      author VARCHAR(255)
);