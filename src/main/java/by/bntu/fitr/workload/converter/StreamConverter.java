package by.bntu.fitr.workload.converter;

import by.bntu.fitr.workload.converter.util.AbstractModelMapperConverter;
import by.bntu.fitr.workload.model.StreamDto;
import by.bntu.fitr.workload.repository.entity.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreamConverter extends AbstractModelMapperConverter<StreamDto, Stream> {

    @Autowired
    private GroupConverter groupConverter;

    public StreamConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Stream convertToEntity(StreamDto streamDto) {
        if (streamDto == null) {
            return null;
        }
        Stream entity = new Stream();
        entity.setId(streamDto.getId());
        entity.setName(streamDto.getName());
        entity.setGroups(groupConverter.convertToEntityList(streamDto.getGroups()));
        return entity;
    }
}
