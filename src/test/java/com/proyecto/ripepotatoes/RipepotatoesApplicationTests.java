package com.proyecto.ripepotatoes;

import com.proyecto.ripepotatoes.controller.AuthController;
import com.proyecto.ripepotatoes.controller.FavoriteController;
import com.proyecto.ripepotatoes.controller.MovieDetailController;
import com.proyecto.ripepotatoes.controller.ProfileController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RipepotatoesApplicationTests {

    @Autowired
    AuthController authController;

    @Autowired
    FavoriteController favoriteController;

    @Autowired
    MovieDetailController movieDetailController;

    @Autowired
    ProfileController profileController;

    @Test
    public void contextLoads() {
        assertThat(authController).isNotNull();
        assertThat(favoriteController).isNotNull();
        assertThat(movieDetailController).isNotNull();
        assertThat(profileController).isNotNull();
    }

}
