package com.proyecto.ripepotatoes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="libro_favorito")
@Getter
@Setter
public class Favorito {

    @Id
    @GeneratedValue(generator = "libro_favorito_id_favorito_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "libro_favorito_id_favorito_seq", sequenceName = "public.libro_favorito_id_favorito_seq", allocationSize = 1)
    @Column(name = "id_favorito")
    private int id_favorito;

    @Column(name = "id_peli_api")
    private int idPeliApi;

    @Column(name = "idusuario")
    private int idusuario;

    public int getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }

    public int getIdPeliApi() {
        return idPeliApi;
    }

    public void setIdPeliApi(int idPeliApi) {
        this.idPeliApi = idPeliApi;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
}
