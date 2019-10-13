package com.proyecto.ripepotatoes.repository;

import com.proyecto.ripepotatoes.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    public Rol findByRol(String rol);
}
