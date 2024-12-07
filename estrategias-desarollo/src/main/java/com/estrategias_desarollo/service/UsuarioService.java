package com.estrategias_desarollo.service;

import com.estrategias_desarollo.entity.Usuario;
import com.estrategias_desarollo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que encapsula la lógica de negocio relacionada con "Usuario".
 */
@Service
public class UsuarioService { //clase que encapsula la lógica de negocio
    // relacionada con "Usuario".

    @Autowired
    private UsuarioRepository usuarioRepository;
    //metodo para obtener todos los usuarios
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
    //metodo para obtener un usuario por su id
    public Optional<Usuario> getById(String id) {
        return usuarioRepository.findById(id);
    }
    //metodo para guardar un usuario
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    //metodo para eliminar un usuario|
    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }
}
