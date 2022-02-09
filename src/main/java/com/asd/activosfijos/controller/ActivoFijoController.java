package com.asd.activosfijos.controller;


import com.asd.activosfijos.model.ActivoFijo;
import com.asd.activosfijos.payload.ActivoFijoRequest;
import com.asd.activosfijos.service.ActivoFijoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activo-fijo")
public class ActivoFijoController {

    private final ActivoFijoService service;

    public ActivoFijoController(ActivoFijoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAll() {

        List<ActivoFijo> activoFijos = this.service.getAll();

        if(CollectionUtils.isEmpty(activoFijos)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }{
            return ResponseEntity.ok(this.service.getAll());
        }
    }

    @GetMapping("/by-serial/{serial}")
    public ResponseEntity<List<ActivoFijo>> getActivoFijoBySerial(@PathVariable(name = "serial") String serial) {

        List<ActivoFijo> activoFijos = this.service.getBySerial(serial);

        if(!CollectionUtils.isEmpty(activoFijos)) {
            return ResponseEntity.ok(activoFijos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-fecha/{fecha}")
    public ResponseEntity<List<ActivoFijo>> getActivoFijoByFecha(
            @PathVariable(name = "fecha") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha) {

        List<ActivoFijo> activoFijos = this.service.getByFechaCompra(fecha);

        if(!CollectionUtils.isEmpty(activoFijos)) {
            return ResponseEntity.ok(activoFijos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-tipo/{tipo}")
    public ResponseEntity<List<ActivoFijo>> getActivoFijoByTipo(@PathVariable(name = "tipo") String tipo) {

        List<ActivoFijo> activoFijos = this.service.getByType(tipo);

        if(!CollectionUtils.isEmpty(activoFijos)) {
            return ResponseEntity.ok(activoFijos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ActivoFijo> save(@RequestBody @Valid ActivoFijoRequest activoFijoRequest) {

        Optional<ActivoFijo> optionalActivoFijo = this.service.save(activoFijoRequest);

        if(optionalActivoFijo.isPresent()) {
            return ResponseEntity.ok(optionalActivoFijo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
