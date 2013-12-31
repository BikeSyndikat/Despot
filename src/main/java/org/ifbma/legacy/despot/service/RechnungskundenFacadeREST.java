package org.ifbma.legacy.despot.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import org.ifbma.legacy.despot.entities.Rechnungskunden;

@Stateless
@Path("rechnungskunde")
public class RechnungskundenFacadeREST extends AbstractFacade<Rechnungskunden> {

    public RechnungskundenFacadeREST() {
        super(Rechnungskunden.class);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Rechnungskunden find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Rechnungskunden> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Rechnungskunden> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    @Override
    public String countREST() {
        return String.valueOf(super.count());
    }

}
