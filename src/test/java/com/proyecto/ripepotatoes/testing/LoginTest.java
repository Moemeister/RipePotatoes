package com.proyecto.ripepotatoes.testing;

import com.proyecto.ripepotatoes.domain.Rol;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.repository.RolRepository;
import com.proyecto.ripepotatoes.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolRepository rolRepository;

    @Test
    public void createUser(){
        Usuario usuario= new Usuario();
        //Rol rol = new Rol();
        usuario.setNombre("JuanTester");
        usuario.setApellido("PerezTester");
        usuario.setUsername("juancho");
        usuario.setStatus("VERIFIED");
        usuario.setPass(encoder.encode("juan"));
        Rol rol = rolRepository.findByRol("USER");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        usuarioService.save(usuario);
        Usuario userTest = usuarioService.findByUsername("juancho");
        assertThat(userTest).isNotNull();
        usuarioService.remove(userTest);
    }

    @Test
    public void isUserAlreadyPresent(){
        Usuario usuario = new Usuario();
        usuario.setUsername("sara");
        boolean isUserAlreadyExists = false;
        Usuario existingUser = usuarioService.findByUsername(usuario.getUsername());
        // If user is found in database, then then user already exists.
        if(existingUser != null){
            isUserAlreadyExists = true;
        }
        assertThat(isUserAlreadyExists).isTrue();

    }

}
