ALTER TABLE bill ADD CONSTRAINT chk_start_b4_end CHECK (startdate<enddate);
