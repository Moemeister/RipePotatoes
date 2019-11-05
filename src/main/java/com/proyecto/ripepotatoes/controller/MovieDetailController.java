package com.proyecto.ripepotatoes.controller;

import com.proyecto.ripepotatoes.domain.Favorito;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.models.MovieDetails;
import com.proyecto.ripepotatoes.service.FavoriteService;
import com.proyecto.ripepotatoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class MovieDetailController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FavoriteService favoriteService;

    RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @PostMapping("/movieDetail")
    public ModelAndView profile(@RequestParam(name = "id_peli") Integer id_peli, Principal usuario){
        ModelAndView mav = new ModelAndView();
        Usuario user = usuarioService.findByUsername(usuario.getName());
        MovieDetails movie = new MovieDetails();

        String url = "https://api.themoviedb.org/3/movie/{id_peli}?api_key="+apiKey+"&language=es-ES";
        movie = restTemplate.getForObject(url,MovieDetails.class,id_peli);

        mav.addObject("movie",movie);
        mav.addObject("user",user);
        mav.setViewName("/home/moviedetail");
        return mav;
    }
}
