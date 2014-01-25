CREATE TABLE bill
(
  id serial NOT NULL,
  customer integer NOT NULL,
  startdate timestamp with time zone NOT NULL DEFAULT (date_trunc('month'::text, now()) - '1 mon'::interval),
  enddate timestamp with time zone NOT NULL DEFAULT (date_trunc('month'::text, now()) - '1 day'::interval),
  amount_due double precision NOT NULL DEFAULT 0.0,
  bill_type integer NOT NULL DEFAULT 0,
  state integer NOT NULL DEFAULT 0,
  CONSTRAINT pk_bill PRIMARY KEY (id),
  CONSTRAINT fk_bill_customer FOREIGN KEY (customer)
      REFERENCES customer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT ck_amount_due CHECK (amount_due <> 0.0::double precision)
)
WITH (OIDS=FALSE);
