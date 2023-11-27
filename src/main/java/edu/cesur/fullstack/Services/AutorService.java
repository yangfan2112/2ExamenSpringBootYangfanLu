package edu.cesur.fullstack.services;

import java.util.List;

import edu.cesur.fullstack.dtos.AutorDTO;

public interface AutorService {

	AutorDTO createAutor(AutorDTO autorDTO);
	
	List<AutorDTO> getAllAutoresWithLibros();
}
