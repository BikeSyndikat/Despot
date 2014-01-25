CREATE OR REPLACE VIEW due_bills_summed AS
 SELECT count(c.id), c.customer, sum(c.price)
   FROM consignment c
   INNER JOIN billrun br ON(c.scheduled >= br.startdate AND c.scheduled < br.enddate AND br.state = 0)
   GROUP BY c.customer;

CREATE OR REPLACE VIEW due_bills_detailed AS
 SELECT c.id, c.customer, c.pickup, c.delivery, c.comment, c.status, c.price
   FROM consignment c
   INNER JOIN billrun br ON c.scheduled >= br.startdate AND c.scheduled < br.enddate AND br.state = 0
  ORDER BY c.customer, c.scheduled;
