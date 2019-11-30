package com.proyecto.ripepotatoes.service;

import com.proyecto.ripepotatoes.domain.FavoriteBook;
import com.proyecto.ripepotatoes.domain.Usuario;

import java.util.List;

public interface FavoriteBookService {

    public void save(Usuario user, String id, String title, String autor, String desc);
    public Boolean isFavoriteBookAlreadyAdded(String isbn,Usuario usuario);
    public List<FavoriteBook> findByIdusuario(Integer id);

}
