CREATE TABLE users
(
  user_id integer NOT NULL,
  login text,
  password text,
  name text,
  age smallint,
  town text,
  email text,
  phone text,
  CONSTRAINT users_pkey PRIMARY KEY (user_id),
  CONSTRAINT user_email_key UNIQUE (email)
);


CREATE  UNIQUE INDEX index_login
ON users (login);


CREATE TABLE type_name
(
  type_id integer NOT NULL,
  type_name text,
  CONSTRAINT Type_Name_pkey PRIMARY KEY (type_id)
);

CREATE TABLE user_type
(
  type_id integer,
  user_id integer NOT NULL,
  CONSTRAINT User_Type_pkey PRIMARY KEY (user_id),
  CONSTRAINT User_Type_type_id_fkey FOREIGN KEY (type_id)
  REFERENCES type_name (type_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT User_Type_user_id_fkey FOREIGN KEY (user_id)
  REFERENCES users (user_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE excursion
(
  excurs_id integer NOT NULL,
  place text,
  town text,
  max_tourists integer,
  price double precision,
  duration_tour_minutes integer,
  description text,
  CONSTRAINT excursion_pkey PRIMARY KEY (excurs_id)
);

CREATE TABLE excurs_guide
(
  seq_excurs_guide integer NOT NULL,
  excurs_id integer,
  user_guide_id integer,
  date_excurs bigint,
  tourist_quantity integer,
  CONSTRAINT Excurs_Guide_pkey PRIMARY KEY (seq_excurs_guide),
  CONSTRAINT Excurs_Guide_excurs_id_fkey FOREIGN KEY (excurs_id)
  REFERENCES excursion (excurs_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT Excurs_Guide_user_id_fkey FOREIGN KEY (user_guide_id)
  REFERENCES users (user_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE excurs_tourist
(
  sequence_id integer NOT NULL,
  user_id integer,
  excurs_guide_seq integer,
  CONSTRAINT Excurs_Tourist_pkey PRIMARY KEY (sequence_id),
  CONSTRAINT Excurs_Tourist_excurs_guide_seq_fkey FOREIGN KEY (excurs_guide_seq)
  REFERENCES excurs_guide (seq_excurs_guide) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT Excurs_Tourist_user_id_fkey FOREIGN KEY (user_id)
  REFERENCES users (user_id) MATCH SIMPLE
  ON UPDATE CASCADE ON DELETE CASCADE
);




CREATE TABLE rating
(
  excurs_id integer NOT NULL,
  user_id integer NOT NULL,
  rating double precision,
  CONSTRAINT rating_pkey PRIMARY KEY (excurs_id, user_id),
  CONSTRAINT rating_excurs_id_fkey FOREIGN KEY (excurs_id)
  REFERENCES excursion (excurs_id) MATCH SIMPLE
  ON UPDATE SET NULL ON DELETE CASCADE,
  CONSTRAINT rating_user_id_fkey FOREIGN KEY (user_id)
  REFERENCES users (user_id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE logs
(
  excursion text,
  added timestamp without time zone
);

CREATE OR REPLACE FUNCTION add_to_log() RETURNS TRIGGER AS $$
DECLARE
  operation varchar(30);
  town      varchar(100);
  place      varchar(200);
  result    varchar(254);
BEGIN
  IF TG_OP = 'INSERT'
  THEN
    town = NEW.town;
    place = NEW.place;
    operation := 'Add new excursion ';
    result := operation || town || ' ' || place;
    INSERT INTO logs (excursion, added) values (result, NOW());
    RETURN NEW;
  ELSIF TG_OP = 'UPDATE'
    THEN
      town = NEW.town;
      place = NEW.place;
      operation := 'Update excursion ';
      result := operation || town || ' ' ||  place;
      INSERT INTO logs (excursion, added) values (result, NOW());
      RETURN NEW;
  ELSIF TG_OP = 'DELETE'
    THEN
      town = OLD.town;
      place = OLD.place;
      operation := 'Remove excursion ';
      result := operation || town || ' ' ||  place;
      INSERT INTO logs (excursion, added) values (result, NOW());
      RETURN OLD;
  END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_trigger
AFTER INSERT OR UPDATE OR DELETE ON excursion
FOR EACH ROW EXECUTE PROCEDURE add_to_log();