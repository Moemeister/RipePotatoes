package com.proyecto.ripepotatoes.controller;

import com.proyecto.ripepotatoes.domain.Favorito;
import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.service.FavoriteBookService;
import com.proyecto.ripepotatoes.service.FavoriteService;
import com.proyecto.ripepotatoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class FavoriteController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    FavoriteBookService favoriteBookService;

    @PostMapping("/addFavorites")
    public ModelAndView addFavorite(@RequestParam(name = "id_peli") Integer id_peli, Principal principal){
        ModelAndView mav = new ModelAndView();
        Usuario user = usuarioService.findByUsername(principal.getName());
        if(favoriteService.isFavoriteAlreadyAdded(id_peli,user)){
            mav.addObject("successMessage","Esta pelicula ya esta en favoritos");
        }else{
            favoriteService.save(user,id_peli);
        }


        mav.setViewName("redirect:/profile");
        return mav;
    }
    @PostMapping("/addFavoritesBook")
    public ModelAndView addFavoriteBook(@RequestParam(name = "isbn") String isbn, Principal principal){
        ModelAndView mav = new ModelAndView();
        Usuario user = usuarioService.findByUsername(principal.getName());
        if(favoriteBookService.isFavoriteBookAlreadyAdded(isbn,user)){
            mav.addObject("successMessage","Este libro ya esta en favoritos");
        }else{
            favoriteBookService.save(user,isbn);
        }


        mav.setViewName("redirect:/profile");
        return mav;
    }

}
