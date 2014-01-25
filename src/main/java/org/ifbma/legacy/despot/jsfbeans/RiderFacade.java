package org.ifbma.legacy.despot.jsfbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.legacy.despot.entities.LegacyRider;

@Stateless
public class RiderFacade extends AbstractFacade<LegacyRider> {

    @PersistenceContext(unitName = "LegacyDespot_1_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RiderFacade() {
        super(LegacyRider.class);
    }

}
