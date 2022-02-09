package com.asd.activosfijos.model;

import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class Ciudad {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String nombre;

}

