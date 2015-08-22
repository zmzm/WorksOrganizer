package by.intexsoft.config;

import by.intexsoft.controller.*;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class Base extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(CategoryController.class);
        s.add(FieldController.class);
        s.add(MetaFieldController.class);
        s.add(ProcessController.class);
        s.add(ProcessStepController.class);
        s.add(ReportController.class);
        s.add(RoleController.class);
        s.add(UserController.class);
        s.add(CORSResponseFilter.class);
        s.add(ContainerResponseFilter.class);
        s.add(JacksonFeature.class);
        return s;
    }
}
