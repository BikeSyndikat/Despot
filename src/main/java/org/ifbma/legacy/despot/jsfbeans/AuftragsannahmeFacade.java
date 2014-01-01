/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ifbma.legacy.despot.jsfbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ifbma.legacy.despot.entities.Auftragsannahme;

/**
 *
 * @author norbert
 */
@Stateless
public class AuftragsannahmeFacade extends AbstractFacade<Auftragsannahme> {
    @PersistenceContext(unitName = "LegacyDespot_1_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuftragsannahmeFacade() {
        super(Auftragsannahme.class);
    }

}