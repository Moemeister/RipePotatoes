package com.proyecto.ripepotatoes.service;


import com.proyecto.ripepotatoes.domain.Rating;

public interface RatingService {
    public void save(Integer id_peli, Integer id_usuario, Integer rating_value);
    public void save(Integer idrate, Integer id_peli, Integer id_usuario, Integer rating_value);
    public Boolean isAlreadyVoted(Integer idpeli, Integer iduser);
    public Rating findByIdPeliApiAndIdUsuario(Integer idpeli, Integer iduser);
    public Integer getPercentage(Integer id_peli);
}
