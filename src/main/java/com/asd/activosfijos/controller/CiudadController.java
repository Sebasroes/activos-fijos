package com.asd.activosfijos.controller;

import com.asd.activosfijos.model.Ciudad;
import com.asd.activosfijos.payload.CiudadRequest;
import com.asd.activosfijos.service.CiudadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ciudad")
public class CiudadController {

    private final CiudadService service;

    public CiudadController(CiudadService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAll() {

        List<Ciudad> ciudades = this.service.getAll();

        if(CollectionUtils.isEmpty(ciudades)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }{
            return ResponseEntity.ok(this.service.getAll());
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Ciudad> getCiudadByNombre(@PathVariable(name = "nombre") String nombre) {


        Optional<Ciudad> optionalCiudad = this.service.getByName(nombre);

        if(optionalCiudad.isPresent()) {
            return ResponseEntity.ok(optionalCiudad.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ciudad> save(@RequestBody @Valid CiudadRequest ciudadRequest) {

        Optional<Ciudad> optionalCiudad = this.service.save(ciudadRequest.getNombre());

        if(optionalCiudad.isPresent()) {
            return ResponseEntity.ok(optionalCiudad.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
