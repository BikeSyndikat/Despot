package org.ifbma.legacy.despot.service;

import java.text.DateFormat;
import java.util.Date;
import javax.ejb.Singleton;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("System")
@Singleton
@ManagedBean
public class Version {

    private final String version = org.ifbma.legacy.despot.entities.Version.getVersion();
    private final String info = org.ifbma.legacy.despot.entities.Version.getInfo();

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

    @GET
    @Path("Timestamp")
    public String getTimestamp() {
        return DateFormat.getTimeInstance(DateFormat.LONG).format(new Date());
    }
}
