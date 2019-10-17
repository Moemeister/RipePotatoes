package com.proyecto.ripepotatoes.service;

import com.proyecto.ripepotatoes.domain.Favorito;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImp implements FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

    @Override
    public void save(Usuario user, Integer id) {
        Favorito favorito = new Favorito();
        favorito.setIdusuario(user.getId());
        favorito.setIdPeliApi(id);
        favoriteRepository.save(favorito);
    }

    @Override
    public Favorito findOne(Integer id) {
        return favoriteRepository.getOne(id);
    }

    @Override
    public Boolean isFavoriteAlreadyAdded(Integer id_peli,Usuario usuario) {
        Boolean isAlreadyAdded = false;
        Favorito existing = favoriteRepository.findByIdPeliApi(id_peli);
        if(existing != null && existing.getIdusuario() == usuario.getId()){
            isAlreadyAdded = true;
        }
        return isAlreadyAdded;
    }

    @Override
    public Favorito findByIdPeliApi(Integer id) {
        return favoriteRepository.findByIdPeliApi(id);
    }

    @Override
    public List<Favorito> findByIdusuario(Integer id) {
        return favoriteRepository.findByIdusuario(id);
    }
}
