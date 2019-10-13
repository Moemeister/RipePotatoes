package com.proyecto.ripepotatoes.service;

import com.proyecto.ripepotatoes.domain.Usuario;

public interface UsuarioService {

    public void save(Usuario usuario);
    public Boolean isUserAlreadyPresent(Usuario usuario);
}
