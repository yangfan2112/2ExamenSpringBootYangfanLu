package edu.cesur.fullstack.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.cesur.fullstack.dtos.AutorDTO;
import edu.cesur.fullstack.persistence.entities.AutorEntity;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface AutorMapper {

	AutorDTO toDto(AutorEntity autor);
	AutorEntity toEntity(AutorDTO autorDTO);
	List<AutorDTO> mapEntityListToDToList(List<AutorEntity> autores);
	
}
