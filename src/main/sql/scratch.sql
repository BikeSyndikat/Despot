
 select count(c.id) from consignment c
 inner join billrun br on(c.scheduled >= br.startdate and c.scheduled < br.enddate and br.state = 0)

-- select count(id) from consignment where scheduled > date_trunc('month'::text, now()) - '1 day'::interval

-- select scheduled from consignment order by scheduled asc limit 1 offset 1000
