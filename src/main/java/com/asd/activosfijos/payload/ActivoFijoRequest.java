package com.asd.activosfijos.payload;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActivoFijoRequest {

    @NotNull
    private String tipo;

    @NotNull
    private String serial;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaCompra;

    private String descripcion;

    private String numeroInternoInventario;

    private Integer peso;

    private Float valorCompra;

    private Integer alto;

    private Integer largo;

    private Integer ancho;


}
