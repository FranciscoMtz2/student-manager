package com.franless.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class<?>[] configClasses = { App.class };
        return configClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] mappings = { "/" };
        return mappings;
    }

}