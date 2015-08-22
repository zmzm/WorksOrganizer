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
        return Response.status(200).entity(roleService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        Role r = roleService.findById(id);
        return Response.status(200).entity(r).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(Role value) {
        roleService.create(value);
    }

    @Override
    public void delete(Integer id) {
        roleService.delete(id);
    }

    @Override
    public void update(Role value) {
        roleService.update(value);
    }
}
