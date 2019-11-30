package com.proyecto.ripepotatoes.repository;

import com.proyecto.ripepotatoes.domain.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorito,Integer> {

    public Favorito findByIdPeliApiAndIdusuario(Integer id,Integer idusuario);
    public List<Favorito> findByIdusuario(Integer id);
    public Favorito findByIdPeliApi(Integer id);

    @Query(nativeQuery = true, value = "DELETE FROM pelicula_favorita WHERE idusuario = ?1 ")
    public void remove(Integer id);
}
