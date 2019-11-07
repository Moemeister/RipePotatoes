package com.proyecto.ripepotatoes.service;


import com.proyecto.ripepotatoes.domain.Rating;

public interface RatingService {
    public void save(Integer id_peli, Integer id_usuario, Integer rating_value);
}
