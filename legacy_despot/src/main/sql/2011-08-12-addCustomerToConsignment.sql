 -- FIXME
-- Set the following to the dummy cash user id, currently 7
ALTER TABLE consignment ADD COLUMN customer integer NOT NULL DEFAULT 7;
ALTER TABLE consignment ADD CONSTRAINT fk_consignment_customer
 FOREIGN KEY (customer) REFERENCES customer (id)
 MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
