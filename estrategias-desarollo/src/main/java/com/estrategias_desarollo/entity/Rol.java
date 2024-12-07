package com.estrategias_desarollo.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa la tabla "rol".
 */
@Entity    //usado para indicar que la clase es una entidad
@Data     //usado para generar los metodos get y set
@Table(name = "roles") //usado para indicar el nombre de la tabla
public class Rol {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name ="rol")
    private String rol;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "descripcion")
    private String descripcion;


}
