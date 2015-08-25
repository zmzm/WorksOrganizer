package by.intexsoft.controller;

import by.intexsoft.model.*;
import by.intexsoft.service.ProcessStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("processstep")
public class ProcessStepController implements AbstractController<ProcessStep> {

    @Autowired
    private ProcessStepService processStepService;

    @Override
    public Response list() {
        return Response.status(200).entity(processStepService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        ProcessStep p = processStepService.findById(id);
        return Response.status(200).entity(p).build();
    }

    @Override
    public Response create(ProcessStep value) {

        return Response.status(200).entity(processStepService.create(value)).build();
    }

    @Override
    public Response delete(Integer id) {

        return Response.status(200).entity(processStepService.delete(id)).build();
    }

    @Override
    public Response update(ProcessStep value) {

        return Response.status(200).entity(processStepService.update(value)).build();
    }

    @POST
    @Path("/process")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProcessStep> getByProcess(by.intexsoft.model.Process process){
        return processStepService.getByProcess(process);
    }
}
