package org.agoncal.sample.ejb.jndi.web;

import javax.ejb.Stateless;

@Stateless
public class EJBWeb {

    public String sayHello() {
        return "Say Hello EJB Web";
    }
}
