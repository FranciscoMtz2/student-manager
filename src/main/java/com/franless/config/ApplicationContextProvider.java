package com.franless.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.web.context.ServletContextAware;

import jakarta.servlet.ServletContext;

public class ApplicationContextProvider implements ApplicationContextAware, ServletContextAware {
    private static ApplicationContext aContext;
    private static ServletContext sContext;

    public static ApplicationContext getApplicationContext() {
        return aContext;
    }

    public static ServletContext getServletContext() {
        return sContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        aContext = applicationContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        sContext = servletContext;
    }

}
