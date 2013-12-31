package org.ifbma.legacy.despot.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.ifbma.legacy.despot.entities.Auftragsannahme;

@Stateless
@Path("auftrag")
public class AuftragsannahmeFacadeRest extends AbstractFacade<Auftragsannahme> {

    public AuftragsannahmeFacadeRest() {
        super(Auftragsannahme.class);
    }

    @GET
    @Path(value = "{id}")
    @Produces(value = {"application/xml", "application/json"})
    @Override
    public Auftragsannahme find(Object id) {
        return super.find(id);
    }

    @GET
    @Path(value = "{from}/{to}")
    @Produces(value = {"application/xml", "application/json"})
    @Override
    public List<Auftragsannahme> findRange(int[] range) {
        return super.findRange(range);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    @Override
    public String countREST() {
        return super.countREST();
    }

}
