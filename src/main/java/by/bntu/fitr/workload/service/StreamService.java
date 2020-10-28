package by.bntu.fitr.workload.service;

import by.bntu.fitr.workload.converter.StreamConverter;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.model.StreamDto;
import by.bntu.fitr.workload.repository.dataaccess.StreamRepository;
import by.bntu.fitr.workload.repository.entity.Stream;
import by.bntu.fitr.workload.resolver.GroupResolver;
import by.bntu.fitr.workload.resolver.StreamResolver;
import by.bntu.fitr.workload.service.util.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamService extends CrudServiceImpl<StreamDto,
        Stream,
        StreamRepository,
        StreamConverter,
        StreamResolver> {

    @Autowired
    private GroupResolver groupResolver;

    @Override
    public StreamDto create(StreamDto streamDto) {
       // List<Group> group = groupResolver.resolve(streamDto.getGroups());
        Stream entity = converter.convertToEntity(streamDto);
        entity.setId(null);
        //entity.setGroups(group);
        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }

    @Override
    public StreamDto update(Long id, StreamDto streamDto) {
        resolver.resolve(new ObjectRef(id));

        Stream entity = converter.convertToEntity(streamDto);
   //     List<Group> groups = groupResolver.resolve(streamDto.getGroups());

        entity.setId(id);
    //    entity.setGroups(groups);

        entity = repository.save(entity);
        return converter.convertToDto(entity);
    }
}

