package com.asd.activosfijos.repository;

import com.asd.activosfijos.model.ActivoFijo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface ActivoFijoRepository extends JpaRepository<ActivoFijo, String> {

    Optional<ActivoFijo> findByTipo(String tipo);

    Optional<ActivoFijo> findByFechaCompra(String fechaCompra);

    Optional<ActivoFijo> findBySerial(String serial);

    List<ActivoFijo> findAllByTipo(String tipo);

    List<ActivoFijo> findAllByFechaCompra(LocalDate fechaCompra);

    List<ActivoFijo> findAllBySerial(String serial);


    //List<ActivoFijo> findAllByNombre(String nombre);


}
