package de.kernwestfale;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;




@Path("/calc")
public class CalculatorResource {

    @Inject
    WasmBean bean;

    @Inject
    Logger LOG;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@QueryParam("a") int first, @QueryParam("b") int second) {
        LOG.info("call"+first +"+"+second);
        Object[] results =bean.invoke("add", first, second);
        StringBuilder b = new StringBuilder();
        for (Object o : results) {
            b.append(o.toString());
        }   
        return b.toString();
    }

    @GET
    @Path("/div")
    @Produces(MediaType.TEXT_PLAIN)
    public String div(@QueryParam("a") int first, @QueryParam("b") int second) {
        LOG.info("call"+first +"+"+second);
        Object[] results =bean.invoke("div", first, second);
        StringBuilder b = new StringBuilder();
        for (Object o : results) {
            b.append(o.toString());
        }   
        return b.toString();
    }

    @GET
    @Path("/sub")
    @Produces(MediaType.TEXT_PLAIN)
    public String sub(@QueryParam("a") int first, @QueryParam("b") int second) {
        LOG.info("call"+first +"+"+second);
        Object[] results =bean.invoke("sub", first, second);
        StringBuilder b = new StringBuilder();
        for (Object o : results) {
            b.append(o.toString());
        }   
        return b.toString();
    }

    @GET
    @Path("/mul")
    @Produces(MediaType.TEXT_PLAIN)
    public String mul(@QueryParam("a") int first, @QueryParam("b") int second) {
        LOG.info("call"+first +"+"+second);
        Object[] results =bean.invoke("mul", first, second);
        StringBuilder b = new StringBuilder();
        for (Object o : results) {
            b.append(o.toString());
        }   
        return b.toString();
    }
}