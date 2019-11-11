package com.proyecto.ripepotatoes.service;

import com.proyecto.ripepotatoes.domain.Rol;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.repository.RolRepository;
import com.proyecto.ripepotatoes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RolRepository rolRepository;

    @Override
    public void save(Usuario usuario) {
        usuario.setPass(encoder.encode(usuario.getPass()));
        usuario.setStatus("VERIFIED");
        Rol rol = rolRepository.findByRol("USER");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        usuarioRepository.save(usuario);
    }

    @Override
    public Boolean isUserAlreadyPresent(Usuario usuario) {
        boolean isUserAlreadyExists = false;
        Usuario existingUser = usuarioRepository.findByUsername(usuario.getUsername());
        // If user is found in database, then then user already exists.
        if(existingUser != null){
            isUserAlreadyExists = true;
        }
        return isUserAlreadyExists;
    }
    @Override
    public Usuario findOne(Integer id) {
        return usuarioRepository.getOne(id);
    }
    @Override
    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void remove(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}