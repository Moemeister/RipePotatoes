package com.proyecto.ripepotatoes.controller;

import com.proyecto.ripepotatoes.domain.Rating;
import com.proyecto.ripepotatoes.domain.RatingDTO;
import com.proyecto.ripepotatoes.domain.Response;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.models.Movie;
import com.proyecto.ripepotatoes.models.MovieDetails;
import com.proyecto.ripepotatoes.service.RatingService;
import com.proyecto.ripepotatoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class MovieDetailController {
    Logger logger = Logger.getLogger(MovieDetailController.class.getSimpleName());

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
        System.out.println(usuario.getName());
        Usuario user = null;
        try {
            user = usuarioService.findByUsername(usuario.getName());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error obteniendo usuario: ", e);
        }
        MovieDetails movie;
        Integer percentage = ratingService.getPercentage(id_peli);

        String url = "https://api.themoviedb.org/3/movie/{id_peli}?api_key="+apiKey+"&language=es-ES";
        movie = restTemplate.getForObject(url,MovieDetails.class,id_peli);

        mav.addObject("movie",movie);
        mav.addObject("user",user);
        mav.addObject("percentage",(percentage != -1 )? percentage + "%": "N/A");
        mav.setViewName("/home/moviedetail");
        return mav;
    }

    @PostMapping("/saveRating")

    public @ResponseBody
    Response
    save(@RequestBody RatingDTO rating ){
        if(ratingService.isAlreadyVoted(rating.getIdPeliApi(),rating.getIdUsuario() )){
            Rating rating1 = ratingService.findByIdPeliApiAndIdUsuario(rating.getIdPeliApi(),rating.getIdUsuario());
            ratingService.save(rating1.getId_rating(), rating.getIdPeliApi(), rating.getIdUsuario(),rating.getRating_value());
        }else{
            ratingService.save(rating.getIdPeliApi(), rating.getIdUsuario(),rating.getRating_value());
        }

        //incluir metodo que recibira porcentaje calculado

        return new Response(200, "OK");
    }
}
