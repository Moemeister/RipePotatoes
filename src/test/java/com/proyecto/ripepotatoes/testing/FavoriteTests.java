package com.proyecto.ripepotatoes.testing;

import com.proyecto.ripepotatoes.domain.Favorito;
import com.proyecto.ripepotatoes.domain.Rol;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.repository.RolRepository;
import com.proyecto.ripepotatoes.service.FavoriteBookService;
import com.proyecto.ripepotatoes.service.FavoriteBookServiceImp;
import com.proyecto.ripepotatoes.service.FavoriteService;
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
public class FavoriteTests {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    FavoriteBookService favoriteBookService;

    @Test
    public void addFavoriteMovieTest() {

        Usuario usuario= new Usuario();
        //Rol rol = new Rol();
        usuario.setNombre("dTester");
        usuario.setApellido("dTester");
        usuario.setUsername("d");
        usuario.setStatus("VERIFIED");
        usuario.setPass(encoder.encode("154"));
        Rol rol = rolRepository.findByRol("USER");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        usuarioService.save(usuario);
        Usuario userTest = usuarioService.findByUsername("d");

        Integer id_peli = 123;
        String isbn = "123";

        boolean favoriteExists = favoriteService.isFavoriteAlreadyAdded(id_peli,userTest);
        assertThat(favoriteExists).isFalse();
        favoriteService.save(userTest,id_peli);
        Favorito favorite = favoriteService.findByIdPeliApi(123);
        assertThat(favorite).isNotNull();
        favoriteService.remove(favorite);

        boolean favoriteBookExists = favoriteBookService.isFavoriteBookAlreadyAdded(isbn,userTest);
        assertThat(favoriteBookExists).isFalse();

        usuarioService.remove(userTest);
    }


}
