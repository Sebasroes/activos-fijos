package com.asd.activosfijos.service;

import com.asd.activosfijos.model.Area;
import com.asd.activosfijos.repository.AreaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
public class AreaService {

    //se crea el metodo por solicitud de AreaControl


    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    public Optional<Area> getByName(String nombre) {
        return areaRepository.findByNombre(nombre);
    }

    public Optional<Area> save(String nombre) {

        Area areaAguardar = Area.builder().nombre(nombre).build();
        Area areaGuardada = areaRepository.save(areaAguardar);
        return Optional.ofNullable(areaGuardada);
    }

