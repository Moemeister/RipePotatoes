package com.proyecto.ripepotatoes.controller;

import com.proyecto.ripepotatoes.domain.FavoriteBook;
import com.proyecto.ripepotatoes.domain.Favorito;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.models.Movie;
import com.proyecto.ripepotatoes.models.MovieDetails;
import com.proyecto.ripepotatoes.service.FavoriteBookService;
import com.proyecto.ripepotatoes.service.FavoriteService;
import com.proyecto.ripepotatoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {
    @Value("${api.key}")
    private String apiKey;
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    FavoriteBookService favoriteBookService;

    RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @GetMapping("/profile")
    public ModelAndView profile(Principal usuario){
        ModelAndView mav = new ModelAndView();
        Usuario user = usuarioService.findByUsername(usuario.getName());
        ArrayList<MovieDetails> favMovies = new ArrayList<MovieDetails>();
        List<Favorito> favs = favoriteService.findByIdusuario(user.getId());
        Favorito lastValue = null;
        for(Favorito i: favs) {
            Integer sort = i.getIdPeliApi();
            String url = "https://api.themoviedb.org/3/movie/{sort}?api_key="+apiKey+"&language=es-ES";
            favMovies.add(restTemplate.getForObject(url,MovieDetails.class,sort));
            lastValue = i;
        }
        mav.addObject("favMovies",favMovies);
        mav.addObject("user",user);
        mav.setViewName("/home/profile");
        return mav;
    }


    @GetMapping("/profileBooks")
    public ModelAndView profileBooks(Principal usuario){
        ModelAndView mav = new ModelAndView();
        Usuario user = usuarioService.findByUsername(usuario.getName());

        List<FavoriteBook> libros = favoriteBookService.findByIdusuario(user.getId());
        mav.addObject("libros",libros);
        mav.addObject("user",user);
        mav.setViewName("/home/favoriteBooks");
        return mav;
    }



}
