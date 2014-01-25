CREATE TABLE property
(
  id serial NOT NULL,
  pkey character varying(255) NOT NULL,
  pvalue character varying(1023),
  CONSTRAINT pk_property PRIMARY KEY (id),
  CONSTRAINT key_property_pkey UNIQUE (pkey)
)
WITH (OIDS=FALSE);
