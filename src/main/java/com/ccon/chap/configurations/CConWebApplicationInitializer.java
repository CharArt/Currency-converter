package com.ccon.chap.configurations;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class CConWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatchar =servletContext.addServlet("SpringDispatchar", new DispatcherServlet(context));
        dispatchar.setLoadOnStartup(1);
        dispatchar.addMapping("/");
    }
}
