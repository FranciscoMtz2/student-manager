package com.franless.services;

import java.util.List;


public interface IService<T> {
    /**
     * 
     * @return {@code List<T>}
     */
    List<T> findAll();

    T find(int id);

    /**
     * 
     * @param model
     * @return {@code int} id of the object crated
     */
    int create(T model);

    int update(T model);

    int destroy(int id);
}
