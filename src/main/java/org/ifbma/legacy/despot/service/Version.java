package org.ifbma.legacy.despot.service;

import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("System")
public class Version {

    private static final Logger LOG = Logger.getLogger(Version.class.getCanonicalName());

    private final String version;

    private final String info;

    public Version() {
        LOG.severe("started");
        final Package pkg = getClass().getPackage();
        this.version = pkg.getImplementationVersion();
        LOG.severe(this.version);
        StringBuilder sb = new StringBuilder(this.version);
        sb.append("\nImplementationTitle: ").append(pkg.getImplementationTitle());
        sb.append("\nImplementationVendor: ").append(pkg.getImplementationVendor());
        sb.append("\nImplementationVersion: ").append(pkg.getImplementationVersion());
        sb.append("\nSpecificationTitle: ").append(pkg.getSpecificationTitle());
        sb.append("\nSpecificationVendor: ").append(pkg.getSpecificationVendor());
        sb.append("\nSpecificationVersion: ").append(pkg.getSpecificationVersion());
        sb.append("\nName: ").append(pkg.getName());
        this.info = sb.toString();
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
        return this.version;
    }

    @GET
    @Path("Info")
    public String getInfo() {
        return this.info;
    }
}
