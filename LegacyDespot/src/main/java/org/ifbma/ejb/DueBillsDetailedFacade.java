package org.ifbma.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.entity.DueBillsDetailed;

/**
 *
 * @author norbert
 */
@Stateless
public class DueBillsDetailedFacade extends AbstractFacade<DueBillsDetailed> {

    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DueBillsDetailedFacade() {
        super(DueBillsDetailed.class);
    }
}
