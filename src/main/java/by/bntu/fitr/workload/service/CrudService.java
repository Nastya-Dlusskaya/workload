package by.bntu.fitr.workload.service;

import java.util.List;

public interface CrudService<T> {

    T find(Long id);

    List<T> findAll();

    T create(T dto);

    T update(Long id, T dto);

    void delete(Long id);

}
