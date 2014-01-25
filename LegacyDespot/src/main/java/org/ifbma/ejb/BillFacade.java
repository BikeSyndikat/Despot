package org.ifbma.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.entity.Bill;

@Stateless
public class BillFacade extends AbstractFacade<Bill> {

    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillFacade() {
        super(Bill.class);
    }
}
