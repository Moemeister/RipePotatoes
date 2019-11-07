package com.proyecto.ripepotatoes.repository;

import com.proyecto.ripepotatoes.domain.Rating;
import com.proyecto.ripepotatoes.domain.RatingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    public Rating findByIdPeliApiAndIdUsuario(Integer idpeli, Integer iduser);
}
