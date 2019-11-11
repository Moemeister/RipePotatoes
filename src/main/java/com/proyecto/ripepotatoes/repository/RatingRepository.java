package com.proyecto.ripepotatoes.repository;

import com.proyecto.ripepotatoes.domain.Rating;
import com.proyecto.ripepotatoes.domain.RatingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    public Rating findByIdPeliApiAndIdUsuario(Integer idpeli, Integer iduser);

    @Query(value = "select ((avg(rating))/(5))*100 from rating where id_peli = ?1",
            nativeQuery = true)
    public Double getRatingPercentage(Integer id_peli);

    public Integer countByIdPeliApi(Integer id_peli);
}
