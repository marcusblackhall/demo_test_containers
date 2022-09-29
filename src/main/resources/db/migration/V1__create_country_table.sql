

CREATE TABLE public.country
(
    iso character varying (2)  NOT NULL,

    country_name character varying(128) NOT NULL,
    capital character varying(128) ,

    CONSTRAINT country_iso_pk PRIMARY KEY (iso)

);
