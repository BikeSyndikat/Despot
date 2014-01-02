package org.ifbma.legacy.despot.entities;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public final class Version {

    private static final Logger LOG = Logger.getLogger(Version.class.getCanonicalName());

    private static final String defaultVersion = "-";
    private static final String LF = "%n";

    private String version;

    private String info;

    public Version() {
        LOG.severe("started..");
        readVersion();
    }

    /**
     * Get the implementation version. This one was available on my JBoss AS
     * 7.2 under
     * http://localhost.:8080/location-enricher-0.0.1-SNAPSHOT/REST/System/Version
     * So basically host/artifact/ApplicationPath/Path(class)/Path(Method).
     * <p>
     * @return
     */
    public String getVersion() {
        return version;
    }

    public String getInfo() {
        return info;
    }

    /**
     * @TODO: alternatively use getServletContext().getResourceAsStream()
     */
    public synchronized void readVersion() {
        if (version != null) {
            return;
        }

        // try to load from maven properties first
        try {
            Properties p = new Properties();
            InputStream is = getClass().getResourceAsStream(
                    "/META-INF/maven/org.ifbma.legacy/LegacyDespot/pom.properties");
            if (is == null) {
                is = getClass().getResourceAsStream(
                        "/META-INF/MANIFEST.MF");
            }

            p.load(is);
            version = p.getProperty("version", "");
            StringBuilder sb = new StringBuilder(version);
            sb.append("\nImplementationTitle: ").append(p.getProperty("Implementation-Title")).append(LF);
            sb.append("\nImplementationVendor: ").append(p.getProperty("Implementation-Vendor")).append(LF);
            sb.append("\nImplementationVersion: ").append(p.getProperty("Implementation-Version")).append(LF);
            sb.append("\nSpecificationTitle: ").append(p.getProperty("Specification-Title")).append(LF);
            sb.append("\nSpecificationVendor: ").append(p.getProperty("Specification-Vendor")).append(LF);
            sb.append("\nSpecificationVersion: ").append(p.getProperty("Specification-Version")).append(LF);
            sb.append("\nName: ").append(p.getProperty("getName")).append(LF); // Implementation-Title??
            info = sb.toString();
        } catch (Exception e) { // IOException, NPE
            final Package pkg = getClass().getPackage();
            version = pkg.getImplementationVersion();
            if (version == null) {
                version = defaultVersion;
            }
            LOG.severe(version);
            StringBuilder sb = new StringBuilder(version);
            sb.append("\nImplementationTitle: ").append(pkg.getImplementationTitle());
            sb.append("\nImplementationVendor: ").append(pkg.getImplementationVendor());
            sb.append("\nImplementationVersion: ").append(pkg.getImplementationVersion());
            sb.append("\nSpecificationTitle: ").append(pkg.getSpecificationTitle());
            sb.append("\nSpecificationVendor: ").append(pkg.getSpecificationVendor());
            sb.append("\nSpecificationVersion: ").append(pkg.getSpecificationVersion());
            sb.append("\nName: ").append(pkg.getName());
            info = sb.toString();
        }
    }

}
