package com.estrategias_desarollo.repository;

import com.estrategias_desarollo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad "Usuario".
 * //usado para indicar que la clase es un repositorio,
 * //que se encarga de realizar operaciones de persistencia.|
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
