package by.bntu.fitr.workload.service.util;

import by.bntu.fitr.workload.converter.util.CollectionConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.entity.BaseEntity;
import by.bntu.fitr.workload.resolver.util.AbstractResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudServiceImpl<
        DTO,
        ENTITY extends BaseEntity,
        REPOSITORY extends JpaRepository<ENTITY, Long>,
        CONVERTER extends CollectionConverter<DTO, ENTITY>,
        RESOLVER extends AbstractResolver<ENTITY, REPOSITORY>> implements CrudService<DTO> {

    @Autowired
    protected REPOSITORY repository;
    @Autowired
    protected CONVERTER converter;
    @Autowired
    protected RESOLVER resolver;

    @Override
    public DTO find(Long id) {
        ENTITY entity = resolver.resolve(new ObjectRef(id));
        return converter.convertToDto(entity);
    }

    @Override
    public List<DTO> findAll() {
        return converter.convertToDtoList(repository.findAll());
    }

    @Override
    public DTO create(DTO dto) {
        ENTITY entity = converter.convertToEntity(dto);
        entity.setId(null);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public DTO update(Long id, DTO dto) {
        resolver.resolve(new ObjectRef(id));
        ENTITY entity = converter.convertToEntity(dto);
        entity.setId(id);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public void delete(Long id) {
        resolver.resolve(new ObjectRef(id));
        repository.deleteById(id);
    }

    @Override
    public Page<DTO> findPage(Pageable pageable) {
        return converter.convertToDtoPage(repository.findAll(pageable));
    }
}
