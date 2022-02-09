package com.asd.activosfijos.service;

import com.asd.activosfijos.model.Persona;
import com.asd.activosfijos.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonaService {

    private final PersonaRepository  personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAll (){
        return personaRepository.findAll();
    }

    public Optional<Persona> getByNombre(String nombre) {

        return personaRepository.findByNombre(nombre);
    }


    public Optional<Persona> save(String nombre){

        Persona personaAguardar = Persona.builder().nombre(nombre).build();
        Persona personaGuardada = personaRepository.save(personaAguardar);
        return Optional.ofNullable(personaGuardada);


    }

}
