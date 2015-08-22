package by.intexsoft.controller;

import by.intexsoft.model.MetaField;
import by.intexsoft.service.MetaFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("metafield")
public class MetaFieldController implements AbstractController<MetaField> {

    @Autowired
    private MetaFieldService metaFieldService;

    @Override
    public Response list() {
        return Response.status(200).entity(metaFieldService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        MetaField c = metaFieldService.findById(id);
        return Response.status(200).entity(c).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(MetaField field) {
        metaFieldService.create(field);
    }

    @Override
    public void delete(Integer id) {
        metaFieldService.delete(id);
    }

    @Override
    public void update(MetaField field) {
        metaFieldService.update(field);
    }
}
