package by.bntu.fitr.workload.controller.util;

import by.bntu.fitr.workload.service.util.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class CrudRestImpl<DTO, SERVICE extends CrudService<DTO>> implements CrudRest<DTO> {

    @Autowired
    protected SERVICE service;

    @Override
    public DTO find(Long id) {
        return service.find(id);
    }

    @Override
    public List<DTO> findAll() {
        return service.findAll();
    }

    @Override
    public Page<DTO> findPage(Pageable pageable) {
        return service.findPage(pageable);
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
