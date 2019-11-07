package com.proyecto.ripepotatoes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(generator = "rating_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "rating_id_seq", sequenceName = "public.rating_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id_rating;

    @Column(name = "id_peli")
    private int idPeliApi;

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "rating")
    private int rating_value;

    public int getId_rating() {
        return id_rating;
    }

    public void setId_rating(int id_rating) {
        this.id_rating = id_rating;
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

    public void setRating_value(int rating) {
        this.rating_value = rating;
    }
}
