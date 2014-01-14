package org.ifbma.legacy.despot.jsfbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.legacy.despot.entities.Rider;

@Stateless
public class RiderFacade extends AbstractFacade<Rider> {

    @PersistenceContext(unitName = "LegacyDespot_1_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RiderFacade() {
        super(Rider.class);
    }

}
