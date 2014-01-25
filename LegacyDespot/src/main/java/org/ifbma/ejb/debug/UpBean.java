package org.ifbma.ejb.debug;

import javax.ejb.Stateless;

@Stateless
public class UpBean implements UpBeanLocal {

    @Override
    public String sayEjbUp(final String parameter) {
        return this.getClass().getCanonicalName() + " says EJB is up and ->"
                + parameter + "<- was the parameter.";
    }
}
