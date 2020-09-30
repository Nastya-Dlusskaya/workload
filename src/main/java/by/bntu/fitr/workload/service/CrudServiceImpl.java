package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.Converter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CrudServiceImpl<DTO, ENTITY, REPOSITORY extends JpaRepository<ENTITY, Long>, CONVERTER extends Converter<DTO, ENTITY>> implements CrudService<DTO>{

    private REPOSITORY repository;
    private CONVERTER converter;


    @Override
    public DTO find(Long id) {
        return converter.convertToDto((ENTITY) repository.findById(id));
    }

    @Override
    public List<DTO> findAll() {
        return repository.findAll().stream().map(e -> converter.convertToDto(e)).collect(Collectors.toList());
    }

    @Override
    public DTO create(DTO dto) {
        ENTITY entity = converter.convertToEntity(dto);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public DTO update(Long id, DTO dto) {
        ENTITY entity = converter.convertToEntity(dto);
        //ToDO setId
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
