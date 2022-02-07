package com.asd.activosfijos.payload;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class AreaRequest {

    @NotNull String nombre;
}
