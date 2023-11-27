package edu.cesur.fullstack.Services;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cesur.fullstack.dtos.LibroDTO;
import edu.cesur.fullstack.mappers.LibroMapper;
import edu.cesur.fullstack.persistence.entities.AutorEntity;
import edu.cesur.fullstack.persistence.entities.LibroEntity;
import edu.cesur.fullstack.persistence.repositories.AutorRepository;
import edu.cesur.fullstack.persistence.repositories.LibroRepository;
import jakarta.transaction.Transactional;

public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroRepository libroRepository;
	@Autowired
	LibroMapper libroMapper;
	@Autowired
	AutorRepository autorRepository;

	@Override
	@Transactional
	public LibroDTO createLibro(LibroDTO libroDTO) {
		LibroEntity libro = libroMapper.toEntity(libroDTO);

		if (libroDTO.getAutorId() != null) {
			AutorEntity autor = autorRepository.findById(libroDTO.getAutorId())
					.orElseThrow(() -> new RuntimeException("El autor con ID " + libroDTO.getAutorId() + " no existe"));

			libro.setAutor(autor);
		}
		
		libro = libroRepository.save(libro);
		return libroMapper.toDto(libro);
	}

}
