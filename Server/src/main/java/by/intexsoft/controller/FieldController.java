package by.intexsoft.controller;

import by.intexsoft.model.Field;
import by.intexsoft.model.ProcessStep;
import by.intexsoft.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("field")
public class FieldController implements AbstractController<Field> {

    @Autowired
    private FieldService fieldService;

    @Override
    public Response list() {
        return Response.status(200).entity(fieldService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        Field c = fieldService.findById(id);
        return Response.status(200).entity(c).build();
    }

    @Override
    public Response create(Field field) {

        return Response.status(200).entity(fieldService.create(field)).build();
    }

    @Override
    public Response delete(Integer id) {

        return Response.status(200).entity(fieldService.delete(id)).build();
    }

    @Override
    public Response update(Field field) {

        return Response.status(200).entity(fieldService.update(field)).build();
    }

    @POST
    @Path("/step")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Field> getByProcess(ProcessStep step){
        return fieldService.getByStep(step);
    }
}
