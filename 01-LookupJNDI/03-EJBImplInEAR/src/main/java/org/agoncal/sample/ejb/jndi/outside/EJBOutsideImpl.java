package org.agoncal.sample.ejb.jndi.outside;

import javax.ejb.Stateless;

@Stateless
public class EJBOutsideImpl implements EJBOutsideLocal, EJBOutsideRemote {

    public String sayHello() {
        return "Say Hello EJB Outside";
    }
}
