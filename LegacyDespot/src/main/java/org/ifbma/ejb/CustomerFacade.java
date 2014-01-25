package org.ifbma.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.ifbma.entity.Customer;

/**
 *
 * @author norbert
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public List<Customer> findReservedCashEntry() {
        Query query = getEntityManager().createNamedQuery("Customer.findReservedCashEntry");
        return query.getResultList();
    }
}
