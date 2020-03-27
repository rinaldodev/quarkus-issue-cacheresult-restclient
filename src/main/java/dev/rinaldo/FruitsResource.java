package dev.rinaldo;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/fruits")
@ApplicationScoped
public class FruitsResource {

    private FruitsRestClient fruitsRestClient;

    @Inject
    public FruitsResource(@RestClient FruitsRestClient fruitsRestClient) {
        this.fruitsRestClient = fruitsRestClient;
    }

    @GET
    public Response get() {
        String expensive = fruitsRestClient.expensive();
        return Response.ok(expensive).build();
    }

    // not to be called directly.
    // it is called in the restclient to show that the random result is not cached.
    @GET
    @Path("/expensive")
    public String getExpensive() {
        int nextInt = new Random().nextInt();
        return "OK " + nextInt;
    }

}
