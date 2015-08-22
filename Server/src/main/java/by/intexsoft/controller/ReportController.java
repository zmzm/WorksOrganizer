package by.intexsoft.controller;

import by.intexsoft.model.Report;
import by.intexsoft.service.ReportService;
import com.sun.jersey.core.spi.factory.ResponseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("report")
public class ReportController implements AbstractController<Report>{

    @Autowired
    private ReportService reportService;

    @Override
    public Response list() {
        return Response.status(200).entity(reportService.findAll()).build();
    }

    @Override
    public Response get(Integer id) {
        Report r = reportService.findById(id);
        return Response.status(200).entity(r).build();
    }

    @Override
    public Response create(Report value) {

        return Response.status(200).entity(reportService.create(value)).build();
    }

    @Override
    public Response delete(Integer id) {

        return Response.status(200).entity(reportService.delete(id)).build();
    }

    @Override
    public Response update(Report value) {

        return Response.status(200).entity(reportService.update(value)).build();
    }
}
