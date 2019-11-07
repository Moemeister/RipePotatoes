package com.proyecto.ripepotatoes.service;

import com.proyecto.ripepotatoes.domain.Rating;
import com.proyecto.ripepotatoes.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImp implements RatingService{
    @Autowired
    RatingRepository ratingRepository;


    @Override
    public void save(Integer id_peli, Integer id_usuario, Integer rating_value) {
        Rating rating = new Rating();
        rating.setIdPeliApi(id_peli);
        rating.setIdUsuario(id_usuario);
        rating.setRating_value(rating_value);
        ratingRepository.save(rating);
    }
    @Override
    public void save(Integer idrate, Integer id_peli, Integer id_usuario, Integer rating_value) {
        Rating rating = new Rating();
        rating.setId_rating(idrate);
        rating.setIdPeliApi(id_peli);
        rating.setIdUsuario(id_usuario);
        rating.setRating_value(rating_value);
        ratingRepository.save(rating);
    }

    @Override
    public Boolean isAlreadyVoted(Integer idpeli, Integer iduser) {
        Boolean isVoted = false;
        Rating rating = ratingRepository.findByIdPeliApiAndIdUsuario(idpeli,iduser);
        if(rating != null){
            isVoted = true;
        }
        return isVoted;
    }

    @Override
    public Rating findByIdPeliApiAndIdUsuario(Integer idpeli, Integer iduser) {
        return ratingRepository.findByIdPeliApiAndIdUsuario(idpeli,iduser);
    }
}
