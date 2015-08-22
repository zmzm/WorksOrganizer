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
        return Response.status(200).entity(userService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        User u = userService.findById(id);
        return Response.status(200).entity(u).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(User value) {
        userService.create(value);
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }

    @Override
    public void update(User value) {
        userService.update(value);
    }
}
