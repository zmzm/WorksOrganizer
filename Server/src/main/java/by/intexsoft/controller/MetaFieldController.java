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
        return Response.status(200).entity(metaFieldService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        MetaField c = metaFieldService.findById(id);
        return Response.status(200).entity(c).build();
    }

    @Override
    public Response create(MetaField field) {

        return Response.status(200).entity(metaFieldService.create(field)).build();
    }

    @Override
    public Response delete(Integer id) {

        return Response.status(200).entity(metaFieldService.delete(id)).build();
    }

    @Override
    public Response update(MetaField field) {

        return Response.status(200).entity(metaFieldService.update(field)).build();
    }
}
