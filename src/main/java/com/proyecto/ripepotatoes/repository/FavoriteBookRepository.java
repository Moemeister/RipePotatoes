package com.proyecto.ripepotatoes.repository;

import com.proyecto.ripepotatoes.domain.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook,Integer> {
    public FavoriteBook findByIdLibroApiAndIdusuario(String id, Integer idusuario);
    public List<FavoriteBook> findByIdusuario(Integer id);
}
