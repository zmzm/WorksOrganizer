package by.intexsoft.controller;

import by.intexsoft.model.Category;
import by.intexsoft.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Component
@Path("category")
public class CategoryController implements AbstractController<Category> {

    @Autowired(required = true)
    private CategoryService categoryService;

    @Override
    public Response list() {
        return Response.status(200).entity(categoryService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        Category c = categoryService.findById(id);
        return Response.status(200).entity(c).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(Category category) {
        categoryService.create(category);
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryService.update(category);
    }
}