package com.asd.activosfijos.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Table
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String nombre;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "area_ciudad",
            joinColumns = { @JoinColumn(name = "area_id") },
            inverseJoinColumns = { @JoinColumn(name = "ciudad_id") }
    )
    private List<Ciudad> ciudad;

}
