package com.asd.activosfijos.controller;



import com.asd.activosfijos.model.Persona;
import com.asd.activosfijos.service.PersonaService;
import com.asd.activosfijos.payload.PersonaRequest;
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
@RequestMapping("/persona")
public class PersonaController {

    private PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity getAll() {

        List<Persona> personas = this.service.getAll();

        if(CollectionUtils.isEmpty(personas)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }{
            return ResponseEntity.ok(this.service.getAll());
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity getPersonaByNombre (@PathVariable(name = "nombre") String nombre){

        Optional<Persona> optionalPersona = this.service.getByNombre(nombre);
        if(optionalPersona.isPresent()) {
            return ResponseEntity.ok(optionalPersona.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody @Valid PersonaRequest personaRequest) {
        Optional<Persona> optionalPersona = this.service.save(personaRequest.getNombre());

        if(optionalPersona.isPresent()) {
            return ResponseEntity.ok(optionalPersona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
