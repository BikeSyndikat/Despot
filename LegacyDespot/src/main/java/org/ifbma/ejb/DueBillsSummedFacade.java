package org.ifbma.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.entity.DueBillsSummed;

/**
 *
 * @author norbert
 */
@Stateless
public class DueBillsSummedFacade extends AbstractFacade<DueBillsSummed> {

    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DueBillsSummedFacade() {
        super(DueBillsSummed.class);
    }
}
