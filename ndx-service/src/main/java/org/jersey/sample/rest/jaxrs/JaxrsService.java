package org.jersey.sample.rest.jaxrs;


import org.springframework.stereotype.Service;

import java.lang.annotation.*;

//~--- JDK imports ------------------------------------------------------------

/**
 * This annotation marks a JAX-RS artifact.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface JaxrsService {
    String value() default "";
}
