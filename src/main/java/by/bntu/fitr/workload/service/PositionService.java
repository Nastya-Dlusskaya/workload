package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.PositionConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.repository.dataaccess.PositionRepository;
import by.bntu.fitr.workload.repository.entity.Position;
import by.bntu.fitr.workload.resolver.PositionResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PositionService extends CrudServiceImpl<ObjectRef,
        Position,
        PositionRepository,
        PositionConverter,
        PositionResolver> {
}
