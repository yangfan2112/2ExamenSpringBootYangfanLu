package edu.cesur.fullstack.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cesur.fullstack.persistence.entities.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

}
