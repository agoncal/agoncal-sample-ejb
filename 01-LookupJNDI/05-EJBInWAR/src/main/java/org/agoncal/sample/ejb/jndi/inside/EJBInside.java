package org.agoncal.sample.ejb.jndi.inside;

import javax.ejb.Stateless;

@Stateless
public class EJBInside {

    public String sayHello() {
        return "Say Hello EJB Inside";
    }
}
