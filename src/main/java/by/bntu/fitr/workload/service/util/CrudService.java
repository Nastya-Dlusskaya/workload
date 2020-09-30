package by.bntu.fitr.workload.service.util;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService<T> {

    T find(Long id);

    List<T> findAll();

    T create(T dto);

    T update(Long id, T dto);

    void delete(Long id);

}
