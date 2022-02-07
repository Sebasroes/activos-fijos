package com.asd.activosfijos.payload;

import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CiudadRequest {

    @NotNull
    private String nombre;

}
