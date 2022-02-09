package com.asd.activosfijos.controller;


import com.asd.activosfijos.payload.AreaRequest;
import com.asd.activosfijos.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import com.asd.activosfijos.model.Area;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/area")
public class AreaController {

    private final AreaService service;

    public AreaController(AreaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity getAll() {

        List<Area> areas = this.service.getAll();
        if(CollectionUtils.isEmpty(areas)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }{
            return ResponseEntity.ok(this.service.getAll());
        }
    }

    //Lo solicitamos por el nombre del area
    @GetMapping("/{nombre}")
    public ResponseEntity<Area> getByName(@PathVariable(name = "nombre") String nombre) {


        Optional<Area> optionalArea = this.service.getByName(nombre);

        if(optionalArea.isPresent()) {
            return ResponseEntity.ok(optionalArea.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Area> save(@RequestBody @Valid AreaRequest AreaRequest) {

        Optional<Area> optionalArea = this.service.save(AreaRequest.getNombre());

        if(optionalArea.isPresent()) {
            return ResponseEntity.ok(optionalArea.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
