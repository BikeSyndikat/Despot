package org.ifbma.legacy.despot.service;

import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("System")
@Singleton
@ManagedBean
public class Version {

    private static final Logger LOG = Logger.getLogger(Version.class.getCanonicalName());

    private final String version;

    private final String info;

    public Version() {
        LOG.severe("started..");
        org.ifbma.legacy.despot.entities.Version v = new org.ifbma.legacy.despot.entities.Version();
        version = v.getVersion();
        info = v.getInfo();
    }

    /**
     * Get the implementation version. This one was available on my JBoss AS
     * 7.2 under
     * http://localhost.:8080/location-enricher-0.0.1-SNAPSHOT/REST/System/Version
     * So basically host/artifact/ApplicationPath/Path(class)/Path(Method).
     * <p>
     * @return
     */
    @GET
    @Path("Version")
    public String getVersion() {
        return version;
    }

    @GET
    @Path("Info")
    public String getInfo() {
        return info;
    }
}
