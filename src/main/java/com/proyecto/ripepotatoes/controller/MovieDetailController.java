package com.proyecto.ripepotatoes.controller;

import com.proyecto.ripepotatoes.domain.RatingDTO;
import com.proyecto.ripepotatoes.domain.Response;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.models.MovieDetails;
import com.proyecto.ripepotatoes.service.RatingService;
import com.proyecto.ripepotatoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    RatingService ratingService;

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

    @PostMapping("/saveRating")

    public @ResponseBody
    Response
    save(@RequestBody RatingDTO rating ){
        ratingService.save(rating.getIdPeliApi(), rating.getIdUsuario(),rating.getRating_value());
        return new Response(200, "OK");
    }
}
