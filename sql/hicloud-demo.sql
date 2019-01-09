
CREATE USER demo WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;

CREATE DATABASE demo
    WITH 
    OWNER = demo
    ENCODING = 'UTF8'
    LC_COLLATE = 'Chinese (Simplified)_China.936'
    LC_CTYPE = 'Chinese (Simplified)_China.936'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT CREATE, CONNECT ON DATABASE demo TO demo;
GRANT TEMPORARY ON DATABASE demo TO demo WITH GRANT OPTION;

GRANT TEMPORARY, CONNECT ON DATABASE demo TO PUBLIC;

CREATE TABLE public.t_order0
(
    id bigint NOT NULL,
    user_id bigint,
    goods text COLLATE pg_catalog."default",
    money numeric(20,3),
    create_time timestamp(4) without time zone,
    status character(1) COLLATE pg_catalog."default",
    CONSTRAINT t_order0_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_order0
    OWNER to demo;

GRANT ALL ON TABLE public.t_order0 TO demo WITH GRANT OPTION;

CREATE TABLE public.t_order1
(
    id bigint NOT NULL,
    user_id bigint,
    goods text COLLATE pg_catalog."default",
    money numeric(20,3),
    create_time timestamp(4) without time zone,
    status character(1) COLLATE pg_catalog."default",
    CONSTRAINT t_order1_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_order1
    OWNER to demo;

GRANT ALL ON TABLE public.t_order1 TO demo WITH GRANT OPTION;

CREATE TABLE public.t_user0
(
    id bigint NOT NULL,
    name character varying(64) COLLATE pg_catalog."default",
    money numeric(20,3),
    CONSTRAINT t_user0_pkey PRIMARY KEY (id),
    CONSTRAINT t_user0_uk UNIQUE (name)
        INCLUDE(name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_user0
    OWNER to demo;

CREATE TABLE public.t_user1
(
    id bigint NOT NULL,
    name character varying(64) COLLATE pg_catalog."default",
    money numeric(20,3),
    CONSTRAINT t_user1_pkey PRIMARY KEY (id),
    CONSTRAINT t_user1_uk UNIQUE (name)
        INCLUDE(name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_user1
    OWNER to demo;

