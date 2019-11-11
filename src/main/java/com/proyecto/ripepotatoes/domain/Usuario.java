package com.proyecto.ripepotatoes.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(generator = "usuario_idusuario_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "usuario_idusuario_seq", sequenceName = "public.usuario_idusuario_seq", allocationSize = 1)
    @Column(name = "idusuario")
    private int id;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name="nombre")
    private String nombre;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name="apellido")
    private String apellido;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name="username")
    private String username;

    @NotBlank(message = "Este campo es obligatorio")
    //@Length(min = 8, message = "La contraseña debe contener 8 caracteres")
    @Column(name="pass")
    private String pass;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles;

    public int getId() {
        return id;
    }
}

