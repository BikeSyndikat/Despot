-- Update and fill up the rider table.
-- New riders that have bookings are inserted with stats.
-- Existing riders hav their stats updated.

BEGIN;

WITH rider_hitlist AS (
SELECT COALESCE("FahrerNr", -1) AS id, COUNT("Id") AS anzahltouren,
       MAX("Dat") AS letztetour
 FROM "Auftragsannahme"
 GROUP BY "FahrerNr"),

insert_rider_hitlist AS (INSERT INTO rider
 (rider_number, anzahltouren, letztetour)
 SELECT rider_hitlist.id AS rider_number, rider_hitlist.anzahltouren,
        rider_hitlist.letztetour
  FROM rider_hitlist LEFT OUTER JOIN rider
    ON (rider_hitlist.id=rider.rider_number)
  WHERE rider.rider_number IS NULL
  ),

update_rider_hitlist AS (UPDATE rider AS r
 SET anzahltouren=h.anzahltouren, letztetour=h.letztetour
 FROM rider_hitlist AS h
 WHERE r.rider_number=h.id)

SELECT 1;
COMMIT;
