package org.ifbma.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.entity.Billrun;

@Stateless
public class BillrunFacade extends AbstractFacade<Billrun> {

    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillrunFacade() {
        super(Billrun.class);
    }
}
