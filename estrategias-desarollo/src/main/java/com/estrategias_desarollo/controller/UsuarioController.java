package com.estrategias_desarollo.controller;

import com.estrategias_desarollo.entity.Usuario;
import com.estrategias_desarollo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manejar las operaciones CRUD de "Usuario".
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //metodo para obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }
    //metodo para obtener un usuario por su id
    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable String id) {
        return usuarioService.getById(id);
    }
    //metodo para guardar un usuario
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
    //metodo para actualizar un usuario
    @PutMapping("/{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario usuario) {
        usuario.setCedula(id);
        return usuarioService.save(usuario);
    }
    //metodo para eliminar un usuario
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        usuarioService.delete(id);
    }
}
