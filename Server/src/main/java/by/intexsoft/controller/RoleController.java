package by.intexsoft.controller;

import by.intexsoft.model.Role;
import by.intexsoft.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("role")
public class RoleController implements AbstractController<Role>{

    @Autowired
    private RoleService roleService;

    @Override
    public Response list() {
        return Response.status(200).entity(roleService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        Role r = roleService.findById(id);
        return Response.status(200).entity(r).build();
    }

    @Override
    public Response create(Role value) {

        return Response.status(200).entity(roleService.create(value)).build();
    }

    @Override
    public Response delete(Integer id) {

        return Response.status(200).entity(roleService.delete(id)).build();
    }

    @Override
    public Response update(Role value) {

        return Response.status(200).entity(roleService.update(value)).build();
    }
}
