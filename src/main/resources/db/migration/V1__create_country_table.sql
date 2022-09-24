DROP TABLE IF EXISTS public.country;

CREATE TABLE IF NOT EXISTS public.country
(
    iso character(2) COLLATE pg_catalog."default" NOT NULL,
    iso3 character(3) COLLATE pg_catalog."default" NOT NULL,
    iso_numeric character(3) COLLATE pg_catalog."default" NOT NULL,
    fips character(2) COLLATE pg_catalog."default",
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    capital character varying(128) COLLATE pg_catalog."default",
    area double precision,
    population integer,
    continent character(2) COLLATE pg_catalog."default" NOT NULL,
    tld character(3) COLLATE pg_catalog."default",
    currency_code character(3) COLLATE pg_catalog."default",
    currency_name character varying(128) COLLATE pg_catalog."default",
    phone character varying(128) COLLATE pg_catalog."default",
    postal_code_format character varying(128) COLLATE pg_catalog."default",
    postal_code_regex character varying(255) COLLATE pg_catalog."default",
    languages character varying(16)[] COLLATE pg_catalog."default",
    geonameid integer,
    neighbours character(2)[] COLLATE pg_catalog."default",
    equivalent_fips_code character(2) COLLATE pg_catalog."default",
    CONSTRAINT country_pkey PRIMARY KEY (iso),
    CONSTRAINT country_iso3_key UNIQUE (iso3),
    CONSTRAINT country_iso_numeric_key UNIQUE (iso_numeric)
)
