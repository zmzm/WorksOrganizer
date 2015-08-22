package by.intexsoft.controller;

import by.intexsoft.model.Field;
import by.intexsoft.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("field")
public class FieldController implements AbstractController<Field> {

    @Autowired
    private FieldService fieldService;

    @Override
    public Response list() {
        return Response.status(200).entity(fieldService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        Field c = fieldService.findById(id);
        return Response.status(200).entity(c).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(Field field) {
        fieldService.create(field);
    }

    @Override
    public void delete(Integer id) {
        fieldService.delete(id);
    }

    @Override
    public void update(Field field) {
        fieldService.update(field);
    }
}
