package edu.cesur.fullstack.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import edu.cesur.fullstack.dtos.LibroDTO;
import edu.cesur.fullstack.persistence.entities.AutorEntity;
import edu.cesur.fullstack.persistence.entities.LibroEntity;

@Mapper(componentModel = "spring")
public interface LibroMapper {

	@Mapping(source = "autor", target = "id", qualifiedByName = "mapAutorId")
    LibroDTO toDto(LibroEntity libro);

    LibroEntity toEntity(LibroDTO libroDTO);

    @Named("mapAutorId")
    default Long mapAutorId(AutorEntity autor) {
        if (autor == null) {
            return null;
        }
        return autor.getId();
    }
}
