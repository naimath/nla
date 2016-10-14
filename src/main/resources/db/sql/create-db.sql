--DROP TABLE users IF EXISTS;

CREATE TABLE person (
  id         INTEGER PRIMARY KEY,
  name       VARCHAR(30),
  phone      INTEGER,
  email      VARCHAR(50)
);
CREATE TABLE book (
  id         INTEGER PRIMARY KEY,
  title      VARCHAR(30),
  author     VARCHAR(30),
  isbn       VARCHAR(50),
  person_id  INTEGER,
  FOREIGN KEY (person_id)
   REFERENCES person(id)
);
