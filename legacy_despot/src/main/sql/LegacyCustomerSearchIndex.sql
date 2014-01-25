CREATE INDEX istrasse
  ON "Rechnungskunden"
  USING btree
  ("Straße" COLLATE pg_catalog."default" );

CREATE INDEX ifiermierung1
  ON "Rechnungskunden"
  USING btree
  ("Firmierung1" COLLATE pg_catalog."default" );

CREATE INDEX ikdnr
  ON "Rechnungskunden"
  USING btree
  ("Kd-Nr" COLLATE pg_catalog."default" );


