package org.ifbma.legacy.despot.jsfbeans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import org.ifbma.legacy.despot.entities.Workorder;

@Stateless
public class WorkorderFacade extends AbstractFacade<Workorder> {

    private static final Logger LOG = Logger.getLogger(WorkorderFacade.class.getCanonicalName());

    @PersistenceContext(unitName = "LegacyDespot_1_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PostConstruct
    public void initialize() {
        em.setProperty("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS.name());
        LOG.info("set retrieveMode to " + CacheRetrieveMode.BYPASS.name());
    }

    public WorkorderFacade() {
        super(Workorder.class);
    }

    /**
     * Find range method that explicitly reads in values from the database.
     * <p>
     * @param range
     * @return
     */
    @Override
    public List<Workorder> findRange(int[] range) {
        evictCache();
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        q.setHint("javax.persistence.cache.retrieveMode", CacheStoreMode.BYPASS.name());
        return q.getResultList();
    }

    public void evictCache() {
        Cache cache = getEntityManager().getEntityManagerFactory().getCache();
        cache.evict(entityClass);
        LOG.info("evicted cache");
    }

    /**
     * Find range method that goes through the result list that has every
     * (hopefully few) entity refreshed that meets certain criteria.
     * <p>
     * Right here we expect the brand new entities be interesting for just one
     * change of internal state we do not want to miss.
     * <p>
     * @param range
     * @return
     */
    @Override
    public List<Workorder> findNewestRange(int[] range) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        TypedQuery<Workorder> q = getEntityManager()
                .createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        refresh(q.getResultList());
        return q.getResultList();
    }

    /**
     * Method to call on return list of query, like the find* methods. This
     * will filter and refresh entities. If there are very few entities
     * expected to be refreshed by criteria this method is useful.
     * <p>
     * @param resultList
     */
    private void refresh(List<Workorder> resultList) {
        for (Workorder workorder : resultList) {
            if (workorder.getFahrernr() < 2) {
                LOG.log(Level.INFO, "refreshing workorder {0}", workorder.getId());
                getEntityManager().refresh(workorder);
            }
        }
    }

    public void testLogLevel() {
        LOG.finest(Level.FINEST.getLocalizedName());
        LOG.finer(Level.FINER.getLocalizedName());
        LOG.fine(Level.FINE.getLocalizedName());
        LOG.config(Level.CONFIG.getLocalizedName());
        LOG.info(Level.INFO.getLocalizedName());
        LOG.warning(Level.WARNING.getLocalizedName());
        LOG.severe(Level.SEVERE.getLocalizedName());
    }
}
