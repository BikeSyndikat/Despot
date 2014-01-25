package org.ifbma.legacy.despot.jsfbeans;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.ifbma.legacy.despot.entities.LegacyCustomer;
import org.primefaces.model.SortOrder;

@Stateless
public class CustomerFacade extends AbstractFacade<LegacyCustomer> {

    @PersistenceContext(unitName = "LegacyDespot_1_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(LegacyCustomer.class);
    }

    /**
     * Count according to filter expression.
     * <p/>
     * @param filters
     * @return
     */
    public int count(Map<String, String> filters) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<LegacyCustomer> rt = cq.from(entityClass);
        if (filters != null && filters.size() > 0) {
            Expression p = getFilterCondition(cb, rt, filters);
            if (p != null) {
                cq.where(p);
            }
        }

        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }

    /**
     * Find range according to filter expression.
     * <p/>
     * @param range
     * @param sortField
     * @param sortOrder
     * @param filters
     * @return
     */
    public List<LegacyCustomer> findRange(int[] range, String sortField,
            final SortOrder sortOrder, Map<String, String> filters) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery();
        final Root<LegacyCustomer> rootQuery = cq.from(entityClass);

        cq.select(rootQuery);
        if (sortField != null) {
            Order sortExpression = getSortExpression(sortOrder, cb, rootQuery, sortField);
            cq.orderBy(sortExpression);
        }

        if (filters != null && filters.size() > 0) {
            Expression p = getFilterCondition(cb, rootQuery, filters);
            if (p != null) {
                cq.where(p);
            }
        }

        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * Create a sort expression out of primefaces sorting parameters. Used for
     * ajax calls from primefaces jsf tags.
     * <p/>
     * @param sortOrder
     * @param cb
     * @param rootQuery
     * @param sortField
     * @return
     */
    protected Order getSortExpression(final SortOrder sortOrder,
            CriteriaBuilder cb, final Root<LegacyCustomer> rootQuery, String sortField) {

        final Order sortExpression;
        if (sortOrder.equals(SortOrder.ASCENDING)) {
            sortExpression = cb.asc(rootQuery.get(sortField));
        } else {
            sortExpression = cb.desc(rootQuery.get(sortField));
        }
        return sortExpression;
    }

    /**
     * Get filter conditions. Does seed out globalFilter as a reserved
     * primefaces identifier used with ajax.
     * <p/>
     * @param cb
     * @param myObj
     * @param filters
     * @return
     */
    protected Expression getFilterCondition(CriteriaBuilder cb, Root<LegacyCustomer> myObj, Map<String, String> filters) {
        Expression<Boolean> filterCondition = null;
        final String WILDCARD = "%";

        for (Map.Entry<String, String> filter : filters.entrySet()) {
            String value = WILDCARD + filter.getValue() + WILDCARD;
            if (!filter.getValue().isEmpty()) {
                if (!filter.getKey().equals("globalFilter")) {
                    Path<String> path = myObj.get(filter.getKey());
                    Predicate newStatement = cb.like(path, value);

                    if (filterCondition == null) {
                        filterCondition = newStatement;
                    } else {
                        filterCondition = cb.or(filterCondition, newStatement);
                    }
                }
            }
        }
        return filterCondition;
    }

}
