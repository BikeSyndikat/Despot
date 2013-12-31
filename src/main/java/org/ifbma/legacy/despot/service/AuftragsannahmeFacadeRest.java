package org.ifbma.legacy.despot.service;

import javax.ws.rs.Path;
import org.ifbma.legacy.despot.entities.Auftragsannahme;

@Path("auftrag")
public class AuftragsannahmeFacadeRest extends AbstractFacade<Auftragsannahme> {

    public AuftragsannahmeFacadeRest() {
        super(Auftragsannahme.class);
    }

}
