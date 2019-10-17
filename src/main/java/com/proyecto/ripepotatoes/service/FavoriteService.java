package com.proyecto.ripepotatoes.service;

import com.proyecto.ripepotatoes.domain.Favorito;
import com.proyecto.ripepotatoes.domain.Usuario;

public interface FavoriteService {

    public void save(Usuario fav, Integer id);
    public Boolean isFavoriteAlreadyAdded(Integer id_peli,Usuario usuario);
    public Favorito findOne(Integer id);
    public Favorito findByIdPeliApi(Integer id);
}
