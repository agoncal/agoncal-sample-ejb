package org.agoncal.sample.ejb.jndi.outside;

import javax.ejb.Remote;

@Remote
public interface EJBOutsideLocal {

    public String sayHello();
}
