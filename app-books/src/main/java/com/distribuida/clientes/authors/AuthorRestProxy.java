package com.distribuida.clientes.authors;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@RegisterRestClient(baseUri="http://localhost:8080")
@RegisterRestClient(configKey = "author")
public interface AuthorRestProxy {

    @GET
    @Path("/{id}")
    @Timeout(value = 3,unit = ChronoUnit.SECONDS)
    @Retry(retryOn = Exception.class,maxRetries = 5,
            maxDuration = 3,
            durationUnit = ChronoUnit.SECONDS,
            delayUnit = ChronoUnit.SECONDS)
    @Fallback(AuthorsClienteFallback.class)
    AuthorsCliente findById(@PathParam("id") Long id);

    @GET
    @Timeout(value = 3,unit = ChronoUnit.SECONDS)
    @Retry(retryOn = Exception.class,maxRetries = 5,
            maxDuration = 3,
            durationUnit = ChronoUnit.SECONDS,
            delay = 1,
            delayUnit = ChronoUnit.SECONDS)
    @Fallback(AuthorsClienteFallback.class)
    List<AuthorsCliente> findAll();

    @POST
    @Timeout(value = 3,unit = ChronoUnit.SECONDS)
    @Retry(retryOn = Exception.class,maxRetries = 5,
            maxDuration = 3,
            durationUnit = ChronoUnit.SECONDS,
            delay = 1,
            delayUnit = ChronoUnit.SECONDS)
    @Fallback(AuthorsClienteFallback.class)
    void insert(AuthorsCliente obj);

    @PUT
    @Path("/{id}")
    @Timeout(value = 3,unit = ChronoUnit.SECONDS)
    @Retry(retryOn = Exception.class,maxRetries = 5,
            maxDuration = 3,
            durationUnit = ChronoUnit.SECONDS,
            delay = 1,
            delayUnit = ChronoUnit.SECONDS)
    @Fallback(AuthorsClienteFallback.class)
    void update(AuthorsCliente obj, @PathParam("id") Long id);

    @DELETE
    @Path("/{id}")
    @Timeout(value = 3,unit = ChronoUnit.SECONDS)
    @Retry(retryOn = Exception.class,maxRetries = 5,
            maxDuration = 3,
            durationUnit = ChronoUnit.SECONDS,
            delay = 1,
            delayUnit = ChronoUnit.SECONDS)
    @Fallback(AuthorsClienteFallback.class)
    void delete( @PathParam("id") Long id );
}
