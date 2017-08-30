package com.pranav.dropApi.resources;

import com.codahale.metrics.annotation.Timed;
import com.pranav.dropApi.pojo.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying hello(@QueryParam("value") Optional<String> content) {
        return new Saying(counter.incrementAndGet(), String.format(template, content.orElse(defaultName)));
    }

    @GET
    @Timed
    @Path("/getRandomTodo")
    public Response hello() {
        return Response.ok(new Saying(1, "test" + String.valueOf(Math.random()))).build();
    }
}
