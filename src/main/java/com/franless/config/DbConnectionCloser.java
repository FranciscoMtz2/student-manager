package com.franless.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class DbConnectionCloser {

    @Autowired
    private DataSource dataSource;

    @PreDestroy
    public void destroy() throws SQLException {
        dataSource.getConnection().close();
    }
}
