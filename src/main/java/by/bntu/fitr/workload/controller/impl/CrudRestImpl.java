package by.bntu.fitr.workload.controller.impl;

import by.bntu.fitr.workload.controller.CrudRest;
import by.bntu.fitr.workload.service.CrudService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrudRestImpl<DTO, SERVICE extends CrudService<DTO>> implements CrudRest<DTO> {

    private SERVICE service;

    @Override
    public DTO find(Long id) {
        return service.find(id);
    }

    @Override
    public List<DTO> findAll() {
        return service.findAll();
    }

    @Override
    public DTO create(DTO dto) {
        return service.create(dto);
    }

    @Override
    public DTO update(Long id, DTO dto) {
        return service.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
