CREATE TABLE Users
(
  user_id integer NOT NULL,
	login text,
	password text,
	name text,
	age smallint,
	town text,
	email text,
	phone text,
	CONSTRAINT Users_pkey PRIMARY KEY (user_id),
	CONSTRAINT user_email_key UNIQUE (email),
  CONSTRAINT user_login_key UNIQUE (login)
);


CREATE TABLE Type_Name
(
  type_id integer NOT NULL,
 	type_name text,
 	CONSTRAINT Type_Name_pkey PRIMARY KEY (type_id)
);

CREATE TABLE User_Type
(
  type_id integer,
	user_id integer NOT NULL,
	CONSTRAINT User_Type_pkey PRIMARY KEY (user_id),
	CONSTRAINT User_Type_type_id_fkey FOREIGN KEY (type_id)
  REFERENCES Type_Name (type_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT User_Type_user_id_fkey FOREIGN KEY (user_id)
  REFERENCES Users (user_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE Excursion
(
  excurs_id integer NOT NULL,
  place text,
  town text,
  max_tourists integer,
  price double precision,
  duration_tour_minutes integer ,
	CONSTRAINT Excursion_pkey PRIMARY KEY (excurs_id)
);

CREATE TABLE Excurs_Guide
(
 seq_excurs_guide integer NOT NULL,
excurs_id integer,
user_guide_id integer,
date_excurs timestamp without time zone,
tourist_quantity integer,
CONSTRAINT Excurs_Guide_pkey PRIMARY KEY (seq_excurs_guide),
CONSTRAINT Excurs_Guide_excurs_id_fkey FOREIGN KEY (excurs_id)
REFERENCES Excursion (excurs_id) MATCH SIMPLE
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT Excurs_Guide_user_id_fkey FOREIGN KEY (user_guide_id)
REFERENCES Users (user_id) MATCH SIMPLE
ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE Excurs_Tourist
(
  sequence_id integer NOT NULL,
	user_id integer,
	excurs_guide_seq integer,
	CONSTRAINT Excurs_Tourist_pkey PRIMARY KEY (sequence_id),
	CONSTRAINT Excurs_Tourist_excurs_guide_seq_fkey FOREIGN KEY (excurs_guide_seq)
  REFERENCES Excurs_Guide (seq_excurs_guide) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT Excurs_Tourist_user_id_fkey FOREIGN KEY (user_id)
  REFERENCES Users (user_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE CASCADE
);




CREATE TABLE rating
(
  excurs_id integer NOT NULL,
	user_id integer NOT NULL,
	rating double precision,
	CONSTRAINT rating_pkey PRIMARY KEY (excurs_id, user_id),
  CONSTRAINT rating_excurs_id_fkey FOREIGN KEY (excurs_id)
  REFERENCES Excursion (excurs_id) MATCH SIMPLE
  ON UPDATE SET NULL ON DELETE CASCADE,
  CONSTRAINT rating_user_id_fkey FOREIGN KEY (user_id)
  REFERENCES Users (user_id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);


