package org.YadMary.service;

import org.YadMary.dao.IGenericDAO;

import java.util.List;

public interface IGenericService<T> extends IGenericDAO<T> {
   List<T> findAll();
//    T getById(long id);
//    List<T> getAll();

    List<T> getAll();
    void deleteAll();
    T getById (int i);
    T getId (Long i);
    T getByName(String name);

}
