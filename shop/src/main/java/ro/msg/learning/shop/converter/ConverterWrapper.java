package ro.msg.learning.shop.converter;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ConverterWrapper<Entity, Dto> implements IConverter<Entity, Dto> {

    public Collection<Entity> convertDtoToEntity(Collection<Dto> dtos){
        return dtos.stream()
                .map(this::getEntity)
                .collect(Collectors.toList());
    }

    public Collection<Dto> convertEntityToDto(Collection<Entity> entities){
        return entities.stream()
                .map(this::getDto)
                .collect(Collectors.toList());
    }
}
