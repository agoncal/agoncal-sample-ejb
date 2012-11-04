package org.agoncal.sample.ejb.jndi.web;

import org.agoncal.sample.ejb.jndi.inside.EJBInside;
import org.agoncal.sample.ejb.jndi.outside.EJBOutsideLocal;
import org.agoncal.sample.ejb.jndi.outside.EJBOutsideRemote;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class RestService {

    @Inject
    protected EJBWeb ejbWeb;
    @Inject
    protected EJBInside ejbInside;
    @EJB(lookup = "java:global/lookup-jndi-ear/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideLocal")
    protected EJBOutsideLocal ejbOutsideLocal;
    @EJB(lookup = "java:global/lookup-jndi-ear/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideRemote")
    protected EJBOutsideRemote ejbOutsideRemote;

    @GET
    @Path("/injectEJBWeb")
    public String injectEJBWeb() {
        return "Inject EJB Web : " + ejbWeb.sayHello();
    }

    @GET
    @Path("/lookupGlobalEJBWeb")
    public String lookupGlobalEJBWeb() throws NamingException {
        EJBWeb ejbWeb = (EJBWeb) new InitialContext().lookup("java:global/lookup-jndi-web/EJBWeb!fr.bdf.center.demo.jndi.web.EJBWeb");
        return "Lookup Global EJB Web : " + ejbWeb.sayHello();
    }

    @GET
    @Path("/injectEJBInside")
    public String injectEJBInside() {
        return "Inject EJB Inside : " + ejbInside.sayHello();
    }

    @GET
    @Path("/lookupGlobalEJBInside")
    public String lookupGlobalEJBInside() throws NamingException {
        EJBInside ejbInside = (EJBInside) new InitialContext().lookup("java:global/lookup-jndi-web/EJBInside!fr.bdf.center.demo.jndi.inside.EJBInside");
        return "Lookup Global EJB Inside : " + ejbInside.sayHello();
    }

    @GET
    @Path("/injectEJBOutsideLocal")
    public String injectEJBOutsideLocal() {
        return "Inject EJB Outside Local : " + ejbOutsideLocal.sayHello();
    }

    @GET
    @Path("/injectEJBOutsideRemote")
    public String injectEJBOutsideRemote() {
        return "Inject EJB Outside Remote : " + ejbOutsideRemote.sayHello();
    }

    @GET
    @Path("/lookupGlobalEJBOutsideLocal")
    public String lookupGlobalEJBOutsideLocal() throws NamingException {
        EJBOutsideLocal ejbOutside = (EJBOutsideLocal) new InitialContext().lookup("java:global/lookup-jndi-ear/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideLocal");
        return "Lookup Global EJB Outside Local : " + ejbOutside.sayHello();
    }

    @GET
    @Path("/lookupGlobalEJBOutsideRemote")
    public String lookupGlobalEJBOutsideRemote() throws NamingException {
        EJBOutsideRemote ejbOutside = (EJBOutsideRemote) new InitialContext().lookup("java:global/lookup-jndi-ear/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideRemote");
        return "Lookup Global EJB Outside Remote : " + ejbOutside.sayHello();
    }

    @GET
    @Path("/lookupExportedEJBOutsideLocal")
    public String lookupExportedEJBOutsideLocal() throws NamingException {
        EJBOutsideLocal ejbOutside = (EJBOutsideLocal) new InitialContext().lookup("java:jboss/exported/lookup-jndi-ear/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideLocal");
        return "Lookup Exported EJB Outside Local : " + ejbOutside.sayHello();
    }

    @GET
    @Path("/lookupExportedEJBOutsideRemote")
    public String lookupExportedEJBOutsideRemote() throws NamingException {
        EJBOutsideRemote ejbOutside = (EJBOutsideRemote) new InitialContext().lookup("java:jboss/exported/lookup-jndi-ear/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideRemote");
        return "Lookup Exported EJB Outside Remote : " + ejbOutside.sayHello();
    }

    @GET
    @Path("/lookupAppEJBOutsideLocal")
    public String lookupAppEJBOutsideLocal() throws NamingException {
        EJBOutsideLocal ejbOutside = (EJBOutsideLocal) new InitialContext().lookup(" java:app/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideLocal");
        return "Lookup App EJB Outside Local : " + ejbOutside.sayHello();
    }

    @GET
    @Path("/lookupAppEJBOutsideRemote")
    public String lookupAppEJBOutsideRemote() throws NamingException {
        EJBOutsideRemote ejbOutside = (EJBOutsideRemote) new InitialContext().lookup("java:app/lookup-jndi-ear-ejb-impl/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideRemote");
        return "Lookup App EJB Outside Remote : " + ejbOutside.sayHello();
    }

    @GET
    @Path("/lookupModuleEJBOutsideLocal")
    public String lookupModuleEJBOutsideLocal() throws NamingException {
        EJBOutsideLocal ejbOutside = (EJBOutsideLocal) new InitialContext().lookup(" java:module/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideLocal");
        return "Lookup App EJB Outside Local : " + ejbOutside.sayHello();
    }

    @GET
    @Path("/lookupModuleEJBOutsideRemote")
    public String lookupModuleEJBOutsideRemote() throws NamingException {
        EJBOutsideRemote ejbOutside = (EJBOutsideRemote) new InitialContext().lookup("java:module/EJBOutsideImpl!fr.bdf.center.demo.jndi.outside.EJBOutsideRemote");
        return "Lookup App EJB Outside Remote : " + ejbOutside.sayHello();
    }
}