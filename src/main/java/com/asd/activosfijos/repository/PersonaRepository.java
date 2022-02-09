package com.asd.activosfijos.repository;

import com.asd.activosfijos.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository  extends JpaRepository<Persona, String> {

    Optional<Persona> findByNombre(String nombre);

}
