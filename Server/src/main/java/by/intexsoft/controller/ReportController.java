package by.intexsoft.controller;

import by.intexsoft.model.Report;
import by.intexsoft.service.ReportService;
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
        return Response.status(200).entity(reportService.findAll()).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response get(Integer id) {
        Report r = reportService.findById(id);
        return Response.status(200).entity(r).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public void create(Report value) {
        reportService.create(value);
    }

    @Override
    public void delete(Integer id) {
        reportService.delete(id);
    }

    @Override
    public void update(Report value) {
        reportService.update(value);
    }
}
