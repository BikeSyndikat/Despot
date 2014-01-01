package org.ifbma.legacy.despot.jsfbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.legacy.despot.entities.Workorder;

@Stateless
public class WorkorderFacade extends AbstractFacade<Workorder> {
    @PersistenceContext(unitName = "LegacyDespot_1_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkorderFacade() {
        super(Workorder.class);
    }

}
