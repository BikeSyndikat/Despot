package org.ifbma.ejb.debug;

import javax.ejb.Local;

@Local
public interface UpBeanLocal {

    String sayEjbUp(final String parameter);
}
