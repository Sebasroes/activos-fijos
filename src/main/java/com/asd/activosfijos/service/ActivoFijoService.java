package com.asd.activosfijos.service;

import com.asd.activosfijos.model.ActivoFijo;
import com.asd.activosfijos.payload.ActivoFijoRequest;
import com.asd.activosfijos.repository.ActivoFijoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivoFijoService {

    private final ActivoFijoRepository activoFijoRepository;


    public ActivoFijoService(ActivoFijoRepository activoFijoRepository) {
        this.activoFijoRepository = activoFijoRepository;
    }

    public List<ActivoFijo> getAll(){
        return activoFijoRepository.findAll();
    }

    public List<ActivoFijo> getByType (String tipo){
        return activoFijoRepository.findAllByTipo(tipo);

    }

    public List<ActivoFijo> getByFechaCompra (LocalDate fecha){
        return activoFijoRepository.findAllByFechaCompra(fecha);

    }

    public List<ActivoFijo> getBySerial (String serial){
        return activoFijoRepository.findAllBySerial(serial);

    }

    public Optional<ActivoFijo> save(ActivoFijoRequest activoFijoRequest) {
        ActivoFijo activoFijoAguardar = ActivoFijo.builder()
                .descripcion(activoFijoRequest.getDescripcion())
                .alto(activoFijoRequest.getAlto())
                .ancho(activoFijoRequest.getAncho())
                .largo(activoFijoRequest.getLargo())
                .serial(activoFijoRequest.getSerial())
                .tipo(activoFijoRequest.getTipo())
                .peso(activoFijoRequest.getPeso())
                .fechaCompra(activoFijoRequest.getFechaCompra())
                .numeroInternoInventario(activoFijoRequest.getNumeroInternoInventario())
                .valorCompra(activoFijoRequest.getValorCompra())
                .build();
        ActivoFijo activoFijoGuardado = activoFijoRepository.save(activoFijoAguardar);
        return Optional.ofNullable(activoFijoGuardado);
    }

}

