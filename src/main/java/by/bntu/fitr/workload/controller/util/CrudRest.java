package by.bntu.fitr.workload.controller.util;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin
public interface CrudRest<T> {

    @GetMapping
    List<T> findAll();

    @GetMapping("/{id}")
    T find(@PathVariable Long id);

    @PostMapping
    T create(@RequestBody T dto);

    @PutMapping("/{id}")
    T update(@PathVariable Long id, @RequestBody T dto);

    @DeleteMapping(("/{id}"))
    void delete(@PathVariable Long id);

}