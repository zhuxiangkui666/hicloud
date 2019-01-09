CREATE USER test WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;


CREATE DATABASE test
    WITH 
    OWNER = test
    ENCODING = 'UTF8'
    LC_COLLATE = 'Chinese (Simplified)_China.936'
    LC_CTYPE = 'Chinese (Simplified)_China.936'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT TEMPORARY, CONNECT ON DATABASE test TO PUBLIC;

GRANT CREATE, CONNECT ON DATABASE test TO test;
GRANT TEMPORARY ON DATABASE test TO test WITH GRANT OPTION;



CREATE TABLE public.t_goods0
(
    id bigint NOT NULL,
    name character varying(128) COLLATE pg_catalog."default",
    price numeric(20,3),
    num bigint,
    CONSTRAINT t_goods0_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_goods0
    OWNER to test;

GRANT ALL ON TABLE public.t_goods0 TO test WITH GRANT OPTION;


INSERT INTO public.t_goods0(
	id, name, price, num)
	VALUES (10, 'ÈÙÒ«', 1599.000, 100);


CREATE TABLE public.t_goods1
(
    id bigint NOT NULL,
    name character varying(128) COLLATE pg_catalog."default",
    price numeric(20,3),
    num bigint,
    CONSTRAINT t_goods1_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_goods1
    OWNER to test;

GRANT ALL ON TABLE public.t_goods1 TO test WITH GRANT OPTION;


CREATE TABLE public.t_user0
(
    id bigint NOT NULL,
    name character varying(64) COLLATE pg_catalog."default",
    money money,
    CONSTRAINT t_user0_pkey PRIMARY KEY (id),
    CONSTRAINT t_user0_uk UNIQUE (name)
        INCLUDE(name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_user0
    OWNER to test;


CREATE TABLE public.t_user1
(
    id bigint NOT NULL,
    name character varying(64) COLLATE pg_catalog."default",
    money money,
    CONSTRAINT t_user1_pkey PRIMARY KEY (id),
    CONSTRAINT t_user1_uk UNIQUE (name)
        INCLUDE(name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_user1
    OWNER to test;


