package org.ifbma.legacy.despot.jsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import org.ifbma.legacy.despot.service.Version;

@ApplicationScoped
@ManagedBean
public class VersionFooter {

    @Inject
    Version v;

    public String getInfo() {
        return v.getVersion();
    }

}
