DROP TABLE IF EXISTS rider;

CREATE TABLE rider
(
   id SERIAL PRIMARY KEY,
   rider_number integer NOT NULL,
   anzahltouren integer NOT NULL DEFAULT 0,
   letztetour date DEFAULT '1970-01-02 00:00:00+01',
   full_name character varying(63) NOT NULL DEFAULT '',
   status integer NOT NULL DEFAULT 0,
   CONSTRAINT idx_rider_number UNIQUE (rider_number)
)
WITH (
  OIDS = FALSE
);
ALTER TABLE rider OWNER TO legacy_dispo;

INSERT INTO rider
  (rider_number, anzahltouren, letztetour)

 SELECT COALESCE("FahrerNr",-1) AS id,
  COUNT("Id") AS anzahltouren,
  MAX("Dat") AS letztetour

  FROM "Auftragsannahme"
  GROUP BY "FahrerNr"
  ORDER BY letztetour DESC;
