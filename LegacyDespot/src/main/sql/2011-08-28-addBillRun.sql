-- FIXME: enddate will be the BEGINNING of the last day of month
-- so only valid for date part joins - comparisons need it a day larger.
CREATE TABLE billrun
(
   id serial NOT NULL,
   startdate timestamp with time zone NOT NULL DEFAULT date_trunc('month'::text, now()) - '1 mon'::interval,
   enddate timestamp with time zone NOT NULL DEFAULT date_trunc('month'::text, now()) - '1 day'::interval,
   status integer NOT NULL DEFAULT 0,
   CONSTRAINT pk_billrun PRIMARY KEY (id)
) WITH (OIDS=FALSE)
;
ALTER TABLE billrun OWNER TO tutorials;
