
CREATE TABLE IF NOT EXISTS genre (
    id int AUTO_INCREMENT PRIMARY KEY,
    name text
);

CREATE TABLE IF NOT EXISTS emprunt (
    id int AUTO_INCREMENT PRIMARY KEY,
    name text
);

CREATE TABLE IF NOT EXISTS borrower (
    id int AUTO_INCREMENT PRIMARY KEY,
    name text
);

CREATE TABLE IF NOT EXISTS book (
    id int AUTO_INCREMENT PRIMARY KEY,
    name text,
    author varchar(255),
    emprunt_id int,
    borrower_id int,
    CONSTRAINT fk_emprunt_id FOREIGN KEY (emprunt_id) REFERENCES emprunt(id) ON DELETE CASCADE,
    CONSTRAINT fk_borrower_id FOREIGN KEY (borrower_id) REFERENCES borrower(id) ON DELETE CASCADE
);