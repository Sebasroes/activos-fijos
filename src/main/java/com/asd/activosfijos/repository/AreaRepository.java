package com.asd.activosfijos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asd.activosfijos.model.Area;
import java.util.Optional;

    public interface AreaRepository extends JpaRepository<Area, String> {

        Optional<Area> findByNombre(String nombre);
}
