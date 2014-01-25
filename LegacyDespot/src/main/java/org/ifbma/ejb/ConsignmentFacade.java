package org.ifbma.ejb;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.ifbma.entity.Consignment;
import org.ifbma.entity.ConsignmentStatus;

/**
 *
 * @author norbert
 */
@Stateless
public class ConsignmentFacade extends AbstractFacade<Consignment> {

    private static final Logger log = Logger.getLogger(ConsignmentFacade.class.getName());
    public static final int MAX_RESULTS = 2000;
    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsignmentFacade() {
        super(Consignment.class);
    }

    public List<Consignment> findImportant(int[] range) {
        Query query = getEntityManager().createNamedQuery("Consignment.findImportant");
        int maxResults = range[1] - range[0];
        log.log(Level.FINE,
                "Loading the lazy consignment data between {0} and {1}",
                new Object[]{range[0], range[1]});
        // new Exception().getStackTrace()[1].getMethodName() + ": " + object
        if (maxResults > MAX_RESULTS) {
            log.log(Level.INFO,
                    "Capping output from {0} to MAX_RESULTS = {1}",
                    new Object[]{maxResults, MAX_RESULTS});
            maxResults = MAX_RESULTS;
        }
        query.setMaxResults(maxResults);
        query.setFirstResult(range[0]);
        return query.getResultList();
    }

    public List<Consignment> findImportant() {
        Query query = getEntityManager().createNamedQuery("Consignment.findImportant");
        log.log(Level.SEVERE,
                " ** THIS METHOD SHOULD NOT BE CALLED. "
                + "It operates on the biggest table and tries to do a full "
                + "read. Capping to {0} records.", MAX_RESULTS);
        query.setMaxResults(MAX_RESULTS);
        return query.getResultList();
    }

    public List<Consignment> findBillable(Date billingStart, Date billingEnd, ConsignmentStatus billableStatus) {
        Query query = getEntityManager().createNamedQuery("Consignment.findBillable");
        query.setParameter("startDate", billingStart, TemporalType.DATE);
        query.setParameter("endDate", billingEnd, TemporalType.DATE);
        query.setParameter("status", billableStatus);
        return query.getResultList();
    }
}
