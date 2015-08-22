package by.intexsoft.controller;

import by.intexsoft.model.Process;
import by.intexsoft.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("process")
public class ProcessController implements AbstractController<Process>{
    @Autowired
    private ProcessService processService;

    @Override
    public Response list() {
        return Response.status(200).entity(processService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        Process c = processService.findById(id);
        return Response.status(200).entity(c).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(Process process) {
        processService.create(process);
    }

    @Override
    public void delete(Integer id) {
        processService.delete(id);
    }

    @Override
    public void update(Process process) {
        processService.update(process);
    }
}
