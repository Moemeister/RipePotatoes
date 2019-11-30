package com.proyecto.ripepotatoes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="libro_favorito")
@Getter
@Setter
public class FavoriteBook {

    @Id
    @GeneratedValue(generator = "libro_favorito_idlibro_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "libro_favorito_idlibro_seq", sequenceName = "public.libro_favorito_idlibro_seq", allocationSize = 1)
    @Column(name = "idlibro")
    private int id_favorito;

    @Column(name = "id_libro_api")
    private String idLibroApi;

    @Column(name = "idusuario")
    private int idusuario;
}
