package by.bntu.fitr.workload.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
public interface CrudRest<T> {

    @GetMapping("/{id}")
    T find(@PathVariable Long id);

    @GetMapping
    List<T> findAll();

    @PostMapping
    T create(@RequestBody T dto);

    @PutMapping("/{id}")
    T update(@PathVariable Long id, @RequestBody T dto);

    @DeleteMapping(("/{id}"))
    void delete(@PathVariable Long id);

}