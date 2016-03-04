-- Show new riders, that is ones with bookings that are not in the
-- riders table.

WITH rider_hitlist AS (

SELECT COALESCE("FahrerNr", -1) AS id, COUNT("Id") AS anzahltouren,
 MAX("Dat") AS letztetour
 FROM "Auftragsannahme"
 GROUP BY "FahrerNr")

 SELECT rider_hitlist.id AS rider_number, rider_hitlist.anzahltouren,
  rider_hitlist.letztetour
  FROM rider_hitlist LEFT OUTER JOIN rider
       ON (rider_hitlist.id=rider.rider_number)
  WHERE rider.rider_number IS NULL;
