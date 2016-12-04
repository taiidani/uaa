-- Medical-related database containing patients, practitioners and treatment plans
CREATE TABLE ct_gender (
	id CHAR(1) PRIMARY KEY,
	name VARCHAR(10) NOT NULL
);

CREATE TABLE ct_illness (
	id CHAR(1) PRIMARY KEY,
	category VARCHAR(25) NOT NULL,
	name VARCHAR(10) NOT NULL
);

CREATE TABLE patient (
	id INTEGER PRIMARY KEY,
	first VARCHAR(100) NOT NULL,
	last VARCHAR(100) NOT NULL,
	dob DATE NOT NULL,
	gender_id CHAR(1) NOT NULL,
	FOREIGN KEY (gender_id) REFERENCES ct_gender(id)
);

-- This is in a 1:1 relationship with patient (this should probably not make it to the final database)
CREATE TABLE patient_terminal (
	patient_id INTEGER PRIMARY KEY,
	expected_date_of_death DATE NOT NULL,
	FOREIGN KEY (patient_id) REFERENCES patient(id)
);

CREATE TABLE practitioner (
	id INTEGER PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	first VARCHAR(100) NOT NULL,
	last VARCHAR(100) NOT NULL,
	bio TEXT
);

CREATE TABLE diagnosis (
	id INTEGER PRIMARY KEY,
	patient_id INT NOT NULL,
	disease_id INT NOT NULL,
	FOREIGN KEY (patient_id) REFERENCES patient(id),
	FOREIGN KEY (disease_id) REFERENCES ct_illness(id)
);

-- This still needs what the patient is being treated with
CREATE TABLE treatment (
	id INTEGER PRIMARY KEY,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	patient_id INT NOT NULL,
	practitioner_id INT NOT NULL,
	FOREIGN KEY (patient_id) REFERENCES patient(id),
	FOREIGN KEY (practitioner_id) REFERENCES practitioner(id)
);



-- A Rollerball derby tracking database tracking players, referees and games

-- Referee, Jammer, Blocker, etc.
CREATE TABLE ct_position (
	id CHAR(1) PRIMARY KEY,
	name VARCHAR(10) NOT NULL
);

-- Home, Guest
CREATE TABLE ct_role (
	id CHAR(1) PRIMARY KEY,
	name VARCHAR(10) NOT NULL
);

-- Blue, black, green, etc.
CREATE TABLE ct_color (
	id CHAR(1) PRIMARY KEY,
	name VARCHAR(10) NOT NULL
);

CREATE TABLE location (
	id INTEGER PRIMARY KEY,
	streetno INT NOT NULL,
	street VARCHAR(100) NOT NULL,
	city VARCHAR(100) NOT NULL,
	state CHAR(2) NOT NULL,
	zip INT NOT NULL,
	CONSTRAINT unq_address UNIQUE (streetno, street, city, state)
);

CREATE TABLE person (
	id INTEGER PRIMARY KEY,
	first VARCHAR(100) NOT NULL,
	last VARCHAR(100) NOT NULL
);

CREATE TABLE team (
	id INTEGER PRIMARY KEY,
	name VARCHAR(100)
);

CREATE TABLE game (
	id INTEGER PRIMARY KEY,
	location_id INT NOT NULL,
	season INT NOT NULL,
	FOREIGN KEY (location_id) REFERENCES location(id)
);

-- Players that are in a game (referee or otherwise)
CREATE TABLE game_participant (
	id INTEGER PRIMARY KEY,
	person_id INT NOT NULL,
	position_id CHAR(1) NOT NULL,
	FOREIGN KEY (person_id) REFERENCES person(id),
	FOREIGN KEY (position_id) REFERENCES ct_position(id)
);

-- Teams that are in a game
CREATE TABLE team_registration (
	id INTEGER PRIMARY KEY,
	game_id INT NOT NULL,
	team_id INT NOT NULL,
	role_id INT NOT NULL,
	color_id INT NOT NULL,
	FOREIGN KEY (game_id) REFERENCES game(id),
	FOREIGN KEY (team_id) REFERENCES team(id),
	FOREIGN KEY (role_id) REFERENCES ct_role(id),
	FOREIGN KEY (color_id) REFERENCES ct_team_color(id),
	CONSTRAINT unq_registration UNIQUE (game_id, team_id)
);