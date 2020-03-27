package dev.rinaldo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.cache.CacheResult;

@Path("fruits/")
@RegisterRestClient
public interface FruitsRestClient {

    @GET
    @Path("expensive")
    @CacheResult(cacheName = "expensive")
    String expensive();

}