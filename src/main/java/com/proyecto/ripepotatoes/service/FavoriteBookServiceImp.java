package com.proyecto.ripepotatoes.service;

import com.proyecto.ripepotatoes.domain.FavoriteBook;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.repository.FavoriteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteBookServiceImp implements FavoriteBookService {

    @Autowired
    FavoriteBookRepository favoriteBookRepository;

    @Override
    public void save(Usuario user, String id, String title, String autor, String desc) {
        FavoriteBook favorito = new FavoriteBook();
        favorito.setIdusuario(user.getId());
        favorito.setIdLibroApi(id);
        favorito.setTitle(title);
        favorito.setAutor(autor);
        favorito.setDesc(desc);
        favoriteBookRepository.save(favorito);
    }
    @Override
    public Boolean isFavoriteBookAlreadyAdded(String isbn,Usuario usuario) {
        Boolean isAlreadyAdded = false;
        System.out.println(isbn);
        FavoriteBook existing = favoriteBookRepository.findByIdLibroApiAndIdusuario(isbn,usuario.getId());
        if(existing != null && existing.getIdusuario() == usuario.getId()){
            isAlreadyAdded = true;
        }
        return isAlreadyAdded;
    }

    @Override
    public List<FavoriteBook> findByIdusuario(Integer id) {
        return favoriteBookRepository.findByIdusuario(id);
    }
}
