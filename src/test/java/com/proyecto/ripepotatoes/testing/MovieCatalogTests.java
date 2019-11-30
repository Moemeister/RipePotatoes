package com.proyecto.ripepotatoes.testing;

import com.proyecto.ripepotatoes.domain.Rating;
import com.proyecto.ripepotatoes.models.MovieDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MovieCatalogTests {

    @Value("${api.key}")
    private String apiKey;
    Integer id_peli = 475557;
    RestTemplate restTemplate = new RestTemplate();
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Test
    public void fetchMoviefromAPITest() {
        assertThat(makeAPICall()).isNotNull();
    }


    @Test
    public void reviewTest() {
        assertThat(makeAPICall().getOverview()).isNotNull();

    }

    public MovieDetails makeAPICall(){
        String url = "https://api.themoviedb.org/3/movie/{id_peli}?api_key="+apiKey+"&language=es-ES";
        MovieDetails movie = restTemplate.getForObject(url,MovieDetails .class,id_peli);

        return movie;
    }
}
