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
  duration_tour integer,
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
  tourist_quantity integer,
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

CREATE SEQUENCE hibernate_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 5;

INSERT INTO public.type_name (type_id, type_name) VALUES (1, 'admin');
INSERT INTO public.type_name (type_id, type_name) VALUES (2, 'guide');
INSERT INTO public.type_name (type_id, type_name) VALUES (3, 'user');


insert into excursion(excurs_id,place,town,max_tourists,price,duration_tour,description) values

  (1,'Центр города','Москва',20,1500,1,'Подробный рассказ опытного гида о центральной части города. Городские легенды, реальные истории и достопримечательности.'),
  (2,'Оружейная палата','Москва',10,1000,1,'Оружейная палата – известный во всем мире музей-сокровищница. Здесь хранятся около 4 тысяч памятников прикладного искусства России, стран Европы и Востока, в их числе – шапка Мономаха, символ самодержавия в России.'),
  (3,'Третьяковская галлерея','Москва',15,1300,1,'Третьяковская галерея — самый известный художественный музей в столице, основанный купцом Павлом Третьяковым в 1856 г. Сегодня это крупное государственное учреждение культуры, в состав которого входят несколько музеев, главным из которых остается музейный комплекс в Лаврушинском переулке.'),
  (4,'Автобусная экскурсия','Москва',40,900,1,'Автобусная экскурсия по городу, которая включает в себя 4 остановки и подробный рассказ о встречающихся на пути достопримечательностях.'),
  (5,'Псковский Кремль','Псков',20,600,1,'Сердце древнего Пскова, насчитывающего более тысячи лет истории, Псковский Кремль, или, как его называют, Кром, расположен на высоком холме при слиянии рек Псковы и Великой. На площади в 3 гектара можно увидеть примечательное количество древних памятников и сооружений.'),
  (6,'Храмы и монастыри Пскова','Псков',40,1000,2,'Только в границах Пскова находятся более 50 церквей, в основном 14-15 веков. Часть из них были отреставрированы еще в советские годы, а часть отреставрировали только в наши дни. Псковская земля традиционно привлекает множество паломников, желающих посетить местные монастыри. Экскурсия включает в себя посещение всех крупнейших псковских обителей. Передвежение по городу в комфортабельных автобусах.'),
  (7,'Новгородский кремль и кремлёвский парк','Великий Новгород',15,800,1,'Новгородский кремль (или, как его еще называют, Новгородский детинец) — самый древний из ныне сохранившихся кремлей России. Время его строительства датируется серединой 11 века.'),
  (8,'Памятник Тысячелетие России','Великий Новгород',20,500,1,'Великий Новгород славен не только своей многовековой историей и ролью в становлении государства Российского, но и памятниками, которые притягивают внимание туристов. Один из таких — «Тысячелетие России», созданный в 1862 году в честь тысячелетия с момента провозглашения Рюрика как князя Руси. Опытный гид подробно расскажет о истории создания памятника и о его символике.'),
  (9,'Нижегородский Кремль','Нижний Новгород',25,1000,1,'Нижегородский Кремль — главная достопримечательность города. Его начали возводить в начале 16 века, в итоге получился целый город, который должен был защищать от набегов татар. Двухкилометровая стена Кремля была укреплена 13 башнями — остались только двенадцать.'),
  (10,'Достопримечательности Нижнего Новгорода','Нижний Новгород',38,2000,3,'Автобусная экскурсия, включающая  себя посещение всех самых популярных туристических мест города.'),
  (11,'Большой тур по Крыму','Крым',38,3500,4,'Мы посетим основные курорты Крыма: Большая Ялта (Ялта, Алупка, Ливадия, Мисхор, Гурзуф и др.), Большая Алушта (Алушта, Партенит и др.), Евпатория, Судак и Новый Свет, Большая Феодосия (Феодосия, Коктебель, Орджоникидзе и др.), Керчь, Щёлкино, Саки, Николаевка, Черноморское.'),
  (12,'Аллея бардов в Новосибирске','Новосибирск',15,500,1,'Новосибирск может похвастаться собственной аллеей звезд — в столице Сибири восемь лет назад была открыта гранитная Аллея бардов. Стоит отметить, что такой достопримечательности нет ни в одном российском городе.');