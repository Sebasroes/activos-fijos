package com.asd.activosfijos.repository;

import com.asd.activosfijos.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CiudadRepository extends JpaRepository<Ciudad, String> {

    Optional<Ciudad> findByNombre(String nombre);

    List<Ciudad> findAllByNombre(String nombre);
}
