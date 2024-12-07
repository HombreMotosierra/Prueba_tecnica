package com.estrategias_desarollo.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa la tabla "usuario".
 */
@Entity //usado para indicar que la clase es una entidad
@Data  //usado para generar los metodos get y set
@Table(name = "usuario") //usado para indicar el nombre de la tabla
public class Usuario {

    @Id  //usado para indicar que el atributo es una llave primaria
    @Column(name = "cedula") //usado para indicar el nombre de la columna|
    private String cedula;

    @Column(name = "primernombre")
    private String primerNombre;

    @Column(name = "segundonombre")
    private String segundoNombre;

    @Column(name = "primerapellido")
    private String primerApellido;

    @Column(name = "segundoapellido")
    private String segundoApellido;

    @Column(name = "clave")
    private String clave;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "nitempresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "rol")
    private Rol rol;

    @Column(name = "estado")
    private Integer estado;
}
