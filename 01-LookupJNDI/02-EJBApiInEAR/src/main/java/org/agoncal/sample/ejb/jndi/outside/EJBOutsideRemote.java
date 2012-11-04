package org.agoncal.sample.ejb.jndi.outside;

import javax.ejb.Remote;

@Remote
public interface EJBOutsideRemote {

    public String sayHello();
}
