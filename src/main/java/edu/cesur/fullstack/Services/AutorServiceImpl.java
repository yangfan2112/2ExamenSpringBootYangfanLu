package edu.cesur.fullstack.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cesur.fullstack.dtos.AutorDTO;
import edu.cesur.fullstack.mappers.AutorMapper;
import edu.cesur.fullstack.persistence.entities.AutorEntity;
import edu.cesur.fullstack.persistence.repositories.AutorRepository;

public class AutorServiceImpl implements AutorService{

	@Autowired
	public AutorRepository autorRepository;
	@Autowired
	public AutorMapper autorMapper;
	
	@Override
	public AutorDTO createAutor(AutorDTO autorDTO) {
		
		return autorMapper.toDto(autorRepository.save(autorMapper.toEntity(autorDTO)));
	}

	@Override
	public List<AutorDTO> getAllAutoresWithLibros() {
		 // Obtener todos los autores con sus libros desde el repositorio
        List<AutorEntity> autores = autorRepository.findAll();
                

        // Retornar la lista de autores con sus libros
        return autorMapper.mapEntityListToDToList(autores);
	}
	
	

}
