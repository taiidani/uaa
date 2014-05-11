DROP TABLE IF EXISTS person;
CREATE TABLE person (
	id INT PRIMARY KEY,
	first varchar(20) NOT NULL,
	last varchar(20) NOT NULL,
	age INT
);

INSERT INTO person VALUES (6, 'Christopher', 'Garden', 46);
INSERT INTO person VALUES (4, 'Albert', 'Wesker', 41);
INSERT INTO person VALUES (1, 'Jacob', 'Williams', 37);
INSERT INTO person VALUES (3, 'Nathan', 'Drake', NULL);
INSERT INTO person VALUES (5, 'Alexandra', 'Vance', 29);
INSERT INTO person VALUES (2, 'Emma', 'Emmerich', 25);