package by.intexsoft.controller;

import by.intexsoft.model.ProcessStep;
import by.intexsoft.service.ProcessStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("processstep")
public class ProcessStepController implements AbstractController<ProcessStep> {

    @Autowired
    private ProcessStepService processStepService;

    @Override
    public Response list() {
        return Response.status(200).entity(processStepService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        ProcessStep p = processStepService.findById(id);
        return Response.status(200).entity(p).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(ProcessStep value) {
        processStepService.create(value);
    }

    @Override
    public void delete(Integer id) {
        processStepService.delete(id);
    }

    @Override
    public void update(ProcessStep value) {
        processStepService.update(value);
    }
}
