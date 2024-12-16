package org.acme;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import org.jboss.resteasy.reactive.RestCookie;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestHeader;
import org.jboss.resteasy.reactive.RestMatrix;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/GutePfadName")
public class NiRaTestEndpoint {
    @GET
    @Produces
    public String Booking() {
        return "Type in the Name of the Route, you want to book";
    }
}
    /*
    public void bookRoute() {
        AppUser user = new AppUser("Joe", "1234", "jones@google.com", null);
        entityManager.persist(user);
    }
}
*/


/*
@Path("/cheeses/{type}")
public class NiRaTestEndpoint {

    @POST
    public String allParams(@RestPath String type,
                            @RestMatrix String variant,
                            @RestQuery String age,
                            @RestCookie String level,
                            @RestHeader("X-Cheese-Secret-Handshake")
                            String secretHandshake,
                            @RestForm String smell) {
        return type + "/" + variant + "/" + age + "/" + level + "/"
                + secretHandshake + "/" + smell;
    }
}
*/
