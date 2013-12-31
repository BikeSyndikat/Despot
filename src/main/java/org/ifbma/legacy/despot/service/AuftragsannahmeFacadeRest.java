package org.ifbma.legacy.despot.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public Auftragsannahme find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path(value = "{from}/{to}")
    @Produces(value = {"application/xml", "application/json"})
    public List<Auftragsannahme> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    @Override
    public String countREST() {
        return super.countREST();
    }

}
