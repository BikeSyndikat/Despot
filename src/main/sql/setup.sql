\c $dbname
set role ${dbname}_owner;
set search_path to ${schema}
BEGIN;

DROP VIEW IF EXISTS workorder;
CREATE OR REPLACE VIEW workorder AS
 SELECT "Auftragsannahme"."Id" AS id,
        date_part('day'::text, "Auftragsannahme"."Dat") AS dat,
        "Auftragsannahme"."Uhr" AS uhr,
        "Auftragsannahme"."Von" AS von,
        "Auftragsannahme"."Ueber" AS ueber,
        "Auftragsannahme"."Nach" AS nach,
        "Auftragsannahme"."Job" AS job,
        "Auftragsannahme"."FahrscheckNr" AS fahrschecknr,
        "Auftragsannahme"."Preis" AS preis,
        "Auftragsannahme"."FahrerNr" AS fahrernr,
        "Auftragsannahme"."Typ" AS typ,

        -- possibly redundant:
        "Auftragsannahme"."PreisCheck" AS preischeck,
        "Auftragsannahme"."FahrscheckCheck" AS fahrscheckcheck,
        "Auftragsannahme"."Sonderkonditionen" AS sonderkonditionen,
        "Auftragsannahme"."Summe" AS summe,
        "Rechnungskunden"."Kuerzel" AS kuerzel,

        -- info from joined table(s):
        "Rechnungskunden"."Firmierung1" AS firmierung1

   FROM "Auftragsannahme"
   JOIN "Rechnungskunden" ON "Auftragsannahme"."Kuerzel" = "Rechnungskunden"."ID"
  WHERE "Auftragsannahme"."Dat" >= (date_trunc('day'::text, now()) - '00:00:00'::interval)
  ORDER BY "Auftragsannahme"."Dat" DESC, "Auftragsannahme"."Uhr" DESC;

DROP VIEW IF EXISTS customer;
CREATE OR REPLACE VIEW customer AS
 SELECT "Rechnungskunden"."ID" AS id,
        "Rechnungskunden"."Kuerzel" AS kuerzel,
        "Rechnungskunden"."Firmierung1" AS firmierung1,
        "Rechnungskunden"."Firmierung2" AS firmierung2,
        "Rechnungskunden"."Straße" AS strasse,
        "Rechnungskunden"."PLZ" AS plz,
        "Rechnungskunden"."Ort" AS ort,
        "Rechnungskunden"."Kd-Nr" AS kundennummer,
        "Rechnungskunden"."Telefon" AS telefon,
        "Rechnungskunden"."Durchwahl" AS durchwahl

   FROM "Rechnungskunden"
  ORDER BY "Rechnungskunden"."Kuerzel" ASC;

COMMIT;
