package org.ifbma.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.ifbma.entity.Property;

/**
 *
 * @author norbert
 */
@Stateless
public class PropertyFacade extends AbstractFacade<Property> {

    private static final Logger log = Logger.getLogger(ConsignmentFacade.class.getName());
    public static final int MAX_RESULTS = 2000;
    @PersistenceContext(unitName = "org.ifbma_Despot-web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropertyFacade() {
        super(Property.class);
    }

    public List<Property> findAllOrdered(int[] range) {
        Query query = getEntityManager().createNamedQuery("Property.findAllOrdered");
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
}
