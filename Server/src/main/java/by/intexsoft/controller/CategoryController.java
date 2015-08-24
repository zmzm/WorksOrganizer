package by.intexsoft.controller;

import by.intexsoft.model.Category;
import by.intexsoft.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("category")
@Consumes("application/json")
@Produces("application/json")
public class CategoryController implements AbstractController<Category> {

    @Autowired(required = true)
    private CategoryService categoryService;

    @Override
    public Response list() {
        return Response.status(200).entity(categoryService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        Category c = categoryService.findById(id);
        return Response.status(200).entity(c).build();
    }

    @Override
    public Response create(Category category) {
        return Response.status(200).entity(categoryService.create(category)).build();
    }

    @Override
    public Response delete(Integer id) {
        return Response.status(200).entity(categoryService.delete(id)).build();
    }

    @Override
    public Response update(Category category) {
        return Response.status(200).entity(categoryService.update(category)).build();
    }
}