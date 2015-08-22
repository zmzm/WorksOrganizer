package by.intexsoft.controller;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public interface AbstractController<T> {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void create(T value);

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void update(T value);
}
