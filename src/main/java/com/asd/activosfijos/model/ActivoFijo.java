package com.asd.activosfijos.model;


import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.time.LocalDate;


@Data
@Table
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActivoFijo {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String descripcion;

    private String tipo;

    private String serial;

    private String numeroInternoInventario;

    private Integer peso;

    private LocalDate fechaCompra;

    private Float valorCompra;

    private Integer alto;

    private Integer largo;

    private Integer ancho;

}
