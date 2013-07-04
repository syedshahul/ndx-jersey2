package org.jersey.sample.rest.jaxrs;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.ImmutableSet.Builder;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.server.filter.HttpMethodOverrideFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.ws.rs.core.MediaType;
import java.util.Map;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import static com.google.common.collect.ImmutableMap.of;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.glassfish.jersey.server.ServerProperties.MEDIA_TYPE_MAPPINGS;


/**
 * This class defines the components of a JAX-RS application and supplies
 * additional meta-data.
 *
 * @author  $author$
 * @version $Revision$, $Date$
 */
public class JaxrsApplication extends ResourceConfig {
  public JaxrsApplication() {
    this(ContextLoader.getCurrentWebApplicationContext());
  }

  public JaxrsApplication(ApplicationContext ctx) {
    super();

    /* Map URI extensions to media types. */
    addProperties(of(MEDIA_TYPE_MAPPINGS, (Object) extensions()));

    /*
     *  Configure support for input and output compression, as well as method
     *  override via HTTP POST.
     */
    registerClasses(EncodingFilter.class, GZipEncoder.class,
                    DeflateEncoder.class, HttpMethodOverrideFilter.class);

    /* Assume that JAX-RS services are compatible with singleton scope. */
    registerInstances(
        new Builder<>().addAll(
          ctx.getBeansWithAnnotation(JaxrsService.class).values()).add(
          new JacksonJsonProvider(mapper())).build());
  }

  private static Map<String, MediaType> extensions() {
    return of("json", APPLICATION_JSON_TYPE);
  }

  private static ObjectMapper mapper() {
    return new ObjectMapper().enable(INDENT_OUTPUT);
  }
}
