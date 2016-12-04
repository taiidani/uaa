DROP TABLE IF EXISTS ct_type;
CREATE TABLE ct_type (
	id CHAR(1) PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS assignment;
CREATE TABLE assignment (
	id INTEGER PRIMARY KEY,
	type_id CHAR(1) NOT NULL,
	name VARCHAR(100) NOT NULL,
	points DECIMAL(10, 1) NOT NULL,
	FOREIGN KEY (type_id) REFERENCES ct_type(id)
);

DROP TABLE IF EXISTS student;
CREATE TABLE student (
	id INTEGER PRIMARY KEY,
	first VARCHAR(100) NOT NULL,
	last VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS grade;
CREATE TABLE grade (
	id INTEGER PRIMARY KEY,
	student_id INT NOT NULL,
	assignment_id INT NOT NULL,
	points DECIMAL(10, 1),
	FOREIGN KEY (student_id) REFERENCES student(id),
	FOREIGN KEY (assignment_id) REFERENCES assignment(id)
);

INSERT INTO ct_type (id, name) VALUES('A', 'Assignment');
INSERT INTO ct_type (id, name) VALUES('T', 'Test');

INSERT INTO assignment (type_id, name, points) VALUES('T', 'Test 1', 100);

INSERT INTO student (first, last) VALUES('Colin', 'Mobley');
INSERT INTO student (first, last) VALUES('Regena', 'Frank');
INSERT INTO student (first, last) VALUES('Evelyn', 'Hopkins');
INSERT INTO student (first, last) VALUES('Angelo', 'Lewis');
INSERT INTO student (first, last) VALUES('Isabella', 'Bennett');
INSERT INTO student (first, last) VALUES('Tammara', 'Simmons');
INSERT INTO student (first, last) VALUES('Allen', 'Smith');
INSERT INTO student (first, last) VALUES('Sean', 'Naylor');
INSERT INTO student (first, last) VALUES('Vicki', 'West');
INSERT INTO student (first, last) VALUES('Catherine', 'Perez');
INSERT INTO student (first, last) VALUES('Harry', 'Davis');
INSERT INTO student (first, last) VALUES('Gregory', 'Fisher');
INSERT INTO student (first, last) VALUES('Alyssa', 'Langley');
INSERT INTO student (first, last) VALUES('Barbara', 'Aldrich');
INSERT INTO student (first, last) VALUES('Milton', 'Green');
INSERT INTO student (first, last) VALUES('Charles', 'Brown');
INSERT INTO student (first, last) VALUES('Barbara', 'Gray');
INSERT INTO student (first, last) VALUES('Hazel', 'Hill');
INSERT INTO student (first, last) VALUES('Corey', 'Pagano');
INSERT INTO student (first, last) VALUES('Christopher', 'Gonzalez');
INSERT INTO student (first, last) VALUES('Marty', 'Hall');
INSERT INTO student (first, last) VALUES('Lisa', 'Preciado');
INSERT INTO student (first, last) VALUES('Mathew', 'Adams');
INSERT INTO student (first, last) VALUES('Jaime', 'Hallman');
INSERT INTO student (first, last) VALUES('Linda', 'Evans');
INSERT INTO student (first, last) VALUES('Michael', 'Frizzell');
INSERT INTO student (first, last) VALUES('Mary', 'Jackson');
INSERT INTO student (first, last) VALUES('Walter', 'Emanuel');

INSERT INTO grade (student_id, assignment_id, points) VALUES(1, 1, 89);
INSERT INTO grade (student_id, assignment_id, points) VALUES(2, 1, 75);
INSERT INTO grade (student_id, assignment_id, points) VALUES(3, 1, 76);
INSERT INTO grade (student_id, assignment_id, points) VALUES(4, 1, 85);
INSERT INTO grade (student_id, assignment_id, points) VALUES(5, 1, 98);
INSERT INTO grade (student_id, assignment_id, points) VALUES(6, 1, 75);
INSERT INTO grade (student_id, assignment_id, points) VALUES(7, 1, 103);
INSERT INTO grade (student_id, assignment_id, points) VALUES(8, 1, 83);
INSERT INTO grade (student_id, assignment_id, points) VALUES(9, 1, 86);
INSERT INTO grade (student_id, assignment_id, points) VALUES(10, 1, 79);
INSERT INTO grade (student_id, assignment_id, points) VALUES(11, 1, 53);
INSERT INTO grade (student_id, assignment_id, points) VALUES(12, 1, 92);
INSERT INTO grade (student_id, assignment_id, points) VALUES(13, 1, 73);
INSERT INTO grade (student_id, assignment_id, points) VALUES(14, 1, 81);
INSERT INTO grade (student_id, assignment_id, points) VALUES(15, 1, 83);
INSERT INTO grade (student_id, assignment_id, points) VALUES(16, 1, 49);
INSERT INTO grade (student_id, assignment_id, points) VALUES(17, 1, 96);
INSERT INTO grade (student_id, assignment_id, points) VALUES(18, 1, 81);
INSERT INTO grade (student_id, assignment_id, points) VALUES(19, 1, 79);
INSERT INTO grade (student_id, assignment_id, points) VALUES(20, 1, 80);
INSERT INTO grade (student_id, assignment_id, points) VALUES(21, 1, 97);
INSERT INTO grade (student_id, assignment_id, points) VALUES(22, 1, 70);
INSERT INTO grade (student_id, assignment_id, points) VALUES(23, 1, NULL);
INSERT INTO grade (student_id, assignment_id, points) VALUES(24, 1, NULL);
INSERT INTO grade (student_id, assignment_id, points) VALUES(25, 1, 65);
INSERT INTO grade (student_id, assignment_id, points) VALUES(26, 1, 91);
INSERT INTO grade (student_id, assignment_id, points) VALUES(27, 1, NULL);
INSERT INTO grade (student_id, assignment_id, points) VALUES(28, 1, 102);