package edu.cesur.fullstack.dtos;

import java.util.ArrayList;
import java.util.List;

public class AutorDTO {

	private Long id;

	private String nombre;

	private String nacionalidad;

	private List<LibroDTO> libros = new ArrayList<>();
}
