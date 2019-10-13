package com.proyecto.ripepotatoes.resources;

import com.proyecto.ripepotatoes.models.Movie;
import com.proyecto.ripepotatoes.models.MovieWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/allmovies")
public class MoviesCatalogResource {
    @Value("${api.key}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @GetMapping("")
    public ModelAndView getCatalog(){
        ModelAndView mav = new ModelAndView();
        //returns one movie
        //Integer movieId =550;
        //return (restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey+"&language=en-US",Movie.class));
        //returns all movies
        Integer page =1;
        MovieWrapper movieWrapper= restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key="+apiKey+"&language=es-ES&page="+page, MovieWrapper.class);
        List<Movie> allMovies= movieWrapper.getResults();
        mav.addObject("catalog",allMovies);
        mav.setViewName("home/catalog");
        return mav;
    }
}
