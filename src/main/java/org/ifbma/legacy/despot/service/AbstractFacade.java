package org.ifbma.legacy.despot.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.constraints.NotNull;

public abstract class AbstractFacade<T> {

    @PersistenceContext(unitName = "LegacyDespot_1_PU")
    protected EntityManager em;

    protected final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

//    @POST
//    @Consumes({"application/xml", "application/json"})
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

//    @PUT
//    @Path("{id}")
//    @Consumes({"application/xml", "application/json"})
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

//    @DELETE
//    @Path("{id}")
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

//    @GET
//    @Produces({"application/xml", "application/json"})
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

//    @GET
//    @Path("count")
//    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(count());
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @NotNull
    protected CriteriaQuery<Object> createQuery() {
        return getCriteriaBuilder().createQuery();
    }

    @NotNull
    protected CriteriaBuilder getCriteriaBuilder() {
        return getEntityManager().getCriteriaBuilder();
    }

    @NotNull
    protected EntityManager getEntityManager() {
        return em;
    }
}
