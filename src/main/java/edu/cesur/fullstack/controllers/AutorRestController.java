package edu.cesur.fullstack.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.Services.AutorService;
import edu.cesur.fullstack.dtos.AutorDTO;

@RestController
@RequestMapping("/autores")
public class AutorRestController {

	@Autowired
	AutorService autorService;

	@PostMapping
	ResponseEntity<?> createAutor(@RequestBody AutorDTO autorDTO) {

		AutorDTO autor = autorService.createAutor(autorDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + autor.getId())
				.buildAndExpand(autor.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping
	public ResponseEntity<List<AutorDTO>> getAllAutoresWithLibros() {
		List<AutorDTO> autores = autorService.getAllAutoresWithLibros();

		if (autores.isEmpty()) {
			// Si la lista de autores está vacía, retornar HttpStatus.NO_CONTENT
			return ResponseEntity.noContent().build();
		} else {
			// Si hay autores, retornar la lista con HttpStatus.OK
			return ResponseEntity.ok(autores);
		}
	}
}
