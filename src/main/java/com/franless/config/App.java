package com.franless.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.franless.dao.IStudentDAO;
import com.franless.dao.StudentDAOImpl;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;

@Configuration
@ComponentScan(basePackages = { "com.franless" })
@EnableWebMvc
public class App implements WebMvcConfigurer {

    private ServletContext servletContext;

    @Bean
    public IStudentDAO studentDAO() {
        IStudentDAO studentDAO = new StudentDAOImpl();
        return studentDAO;
    }


    @PostConstruct
    public void a() {
        System.out.println(this);
    }

}
