package com.asd.activosfijos.service;

import com.asd.activosfijos.model.Ciudad;
import com.asd.activosfijos.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<Ciudad> getAll() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> getByName(String nombre) {
        return ciudadRepository.findByNombre(nombre);
    }

    public Optional<Ciudad> save(String nombre) {
        Ciudad ciudadAguardar = Ciudad.builder().nombre(nombre).build();
        Ciudad ciudadGuardada = ciudadRepository.save(ciudadAguardar);
        return Optional.ofNullable(ciudadGuardada);
    }




}
