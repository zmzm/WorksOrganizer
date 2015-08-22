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
        return Response.status(200).entity(processService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        Process c = processService.findById(id);
        return Response.status(200).entity(c).build();
    }

    @Override
    public Response create(Process process) {

        return Response.status(200).entity(processService.create(process)).build();
    }

    @Override
    public Response delete(Integer id) {
        return Response.status(200).entity(processService.delete(id)).build();
    }

    @Override
    public Response update(Process process) {

        return Response.status(200).entity(processService.update(process)).build();
    }
}
