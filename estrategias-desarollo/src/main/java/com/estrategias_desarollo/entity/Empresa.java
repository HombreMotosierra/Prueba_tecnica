package com.estrategias_desarollo.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa la tabla "empresa".
 */
@Entity //usado para indicar que la clase es una entidad
@Data //usado para generar los metodos get y set
@Table(name = "empresa") //usado para indicar el nombre de la tabla
public class Empresa {

    public Empresa(String nit, String nombre, Integer estado) {
        this.nit = nit;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Empresa() {
    }

    @Id
    @Column(name = "nit")
    private String nit;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private Integer estado;
}
