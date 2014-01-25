package org.ifbma.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.entity.Rider;

/**
 *
 * @author norbert
 */
@Stateless
public class RiderFacade extends AbstractFacade<Rider> {
    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RiderFacade() {
        super(Rider.class);
    }

}
