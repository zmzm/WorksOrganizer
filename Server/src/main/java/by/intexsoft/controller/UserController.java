package by.intexsoft.controller;

import by.intexsoft.model.User;
import by.intexsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("user")
public class UserController implements AbstractController<User>{

    @Autowired
    private UserService userService;

    @Override
    public Response list() {
        return Response.status(200).entity(userService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        User u = userService.findById(id);
        return Response.status(200).entity(u).build();
    }

    @Override
    public Response create(User value) {

        return Response.status(200).entity(userService.create(value)).build();
    }

    @Override
    public Response delete(Integer id) {

        return Response.status(200).entity(userService.delete(id)).build();
    }

    @Override
    public Response update(User value) {
        return Response.status(200).entity(userService.update(value)).build();
    }
}
