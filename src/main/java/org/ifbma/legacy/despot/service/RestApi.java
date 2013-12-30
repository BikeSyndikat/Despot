package org.ifbma.legacy.despot.service;

import java.util.Set;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApi extends Application {
    private static final Logger LOG = Logger.getLogger(RestApi.class.getCanonicalName());

    public RestApi() {
        LOG.severe("started");
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.ifbma.legacy.despot.service.Version.class);
    }

}
