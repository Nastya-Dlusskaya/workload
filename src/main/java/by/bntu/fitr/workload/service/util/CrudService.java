package by.bntu.fitr.workload.service.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService<T> {

    T find(Long id);

    List<T> findAll();

    Page<T> findPage(Pageable pageable);

    T create(T dto);

    T update(Long id, T dto);

    void delete(Long id);

}
