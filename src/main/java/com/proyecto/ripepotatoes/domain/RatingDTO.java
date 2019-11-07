package com.proyecto.ripepotatoes.domain;

import lombok.Getter;
import lombok.Setter;

public class RatingDTO {

    private int idPeliApi;

    private int idUsuario;

    private int rating_value;

    public RatingDTO() {
    }

    public RatingDTO(int idPeliApi, int idUsuario, int rating_value) {
        this.idPeliApi = idPeliApi;
        this.idUsuario = idUsuario;
        this.rating_value = rating_value;
    }

    public int getIdPeliApi() {
        return idPeliApi;
    }

    public void setIdPeliApi(int idPeliApi) {
        this.idPeliApi = idPeliApi;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getRating_value() {
        return rating_value;
    }

    public void setRating_value(int rating_value) {
        this.rating_value = rating_value;
    }
}
