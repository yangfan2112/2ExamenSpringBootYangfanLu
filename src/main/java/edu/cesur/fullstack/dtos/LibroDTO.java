package edu.cesur.fullstack.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {

	private Long id;

	private String titulo;

	private String isbn;

	private BigDecimal precio;

	private Long autorId;
}
