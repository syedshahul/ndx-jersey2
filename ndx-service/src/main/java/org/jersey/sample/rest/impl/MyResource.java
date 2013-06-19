package org.jersey.sample.rest.impl;

import org.jersey.sample.rest.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
//@org.springframework.stereotype.Service("myResource")
@Path("myresource")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_ATOM_XML ,
        MediaType.TEXT_PLAIN})
public class MyResource implements Service {

  //private Manager manager;

 /* @Autowired
  public void setManager(Manager manager) {
    this.manager = manager;
  }*/

  /**
   * Method handling HTTP GET requests. The returned object will be sent
   * to the client as "text/plain" media type.
   *
   * @return String that will be returned as a text/plain response.
   */
  @GET
  public Response getIt() {
    //return Response.status(Response.Status.OK).entity("Got it! : ".concat( manager.getIt())).build();
    return Response.status(Response.Status.OK).entity("Got it! : ").build();
  }
}
