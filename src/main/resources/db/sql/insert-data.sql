INSERT INTO person(id,name,phone,email) VALUES (1, 'naimath', 111222333,'naimath@gmail.com');
INSERT INTO person(id,name,phone,email) VALUES (2, 'raj',333111222, 'raj@yahoo.com');
INSERT INTO person(id,name,phone,email) VALUES (3, 'mat',444222111, 'mat@gmail.com');

INSERT INTO book(id,title,author,isbn) VALUES (1, 'Java','james', 'Java123');
INSERT INTO book(id,title,author,isbn) VALUES (2, 'Oracle','darien', 'oracle123');
INSERT INTO book(id,title,author,isbn) VALUES (3, 'Javascript','scott', 'Javascript123');
INSERT INTO book(id,title,author,isbn) VALUES (4, 'Angular1','ben', 'Angular123');
INSERT INTO book(id,title,author,isbn) VALUES (5, 'Spring','sam', 'Spring123');
INSERT INTO book(id,title,author,isbn) VALUES (6, 'Hibernate','tarcia', 'Hibernate123');

INSERT INTO lend(id,person_id,book_id) VALUES (1,1,1);
INSERT INTO lend(id,person_id,book_id) VALUES (2,1,2);
INSERT INTO lend(id,person_id,book_id) VALUES (3,2,3);
INSERT INTO lend(id,person_id,book_id) VALUES (4,3,4);
INSERT INTO lend(id,person_id,book_id) VALUES (5,3,5);
INSERT INTO lend(id,person_id,book_id) VALUES (6,3,6);