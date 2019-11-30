package com.proyecto.ripepotatoes.domain;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="libro_favorito")
@Getter
@Setter
public class FavoriteBook {

    @Id
    @GeneratedValue(generator = "libro_favorito_id_favorito_seq1", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "libro_favorito_id_favorito_seq1", sequenceName = "public.libro_favorito_id_favorito_seq1", allocationSize = 1)
    @Column(name = "id_favorito")
    private int id_favorito;

    @Column(name = "idlibroapi")
    private String idLibroApi;

    @Column(name = "idusuario")
    private int idusuario;

    @Column(name = "title")
    private String title;

    @Column(name = "autor")
    private String autor;

    @Column(name = "descripcion")
    private String desc;
}
