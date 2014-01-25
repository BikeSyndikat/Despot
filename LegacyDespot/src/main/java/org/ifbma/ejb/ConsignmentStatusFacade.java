package org.ifbma.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.entity.ConsignmentStatus;

/**
 *
 * @author norbert
 */
@Stateless
public class ConsignmentStatusFacade extends AbstractFacade<ConsignmentStatus> {
    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsignmentStatusFacade() {
        super(ConsignmentStatus.class);
    }

}
