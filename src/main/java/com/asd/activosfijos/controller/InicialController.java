package com.asd.activosfijos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicial")
@CrossOrigin(origins = "*")
public class InicialController {

    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("No pares sigue aprendiendo");


    }
}
