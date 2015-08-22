package by.intexsoft.config;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class AppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    public void onStartup(ServletContext servletContext)
            throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(DataConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new RequestContextListener());
        ctx.setServletContext(servletContext);

        Dynamic servletRegistration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new SpringServlet());
        servletRegistration.setInitParameter(DISPATCHER_SERVLET_NAME, ctx.getApplicationName());
        servletRegistration.addMapping("/*");
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.setInitParameter("javax.ws.rs.Application", Base.class.getName());

/*        Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);*/
    }

}