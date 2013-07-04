package org.jersey.sample.rest.impl;

import org.jersey.sample.rest.Service;
import org.jersey.sample.rest.jaxrs.JaxrsService;
import org.jersey.sample.service.Manager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */

@JaxrsService("myresource")
public class MyResource implements Service {

    private Manager manager;

    @Autowired
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public Response getIt() {
        return Response.status(Response.Status.OK).entity("Got it! : ".concat(manager.getIt())).build();
        //return Response.status(Response.Status.OK).entity("Got it! : ").build();
    }
}
