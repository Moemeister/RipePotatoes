package com.proyecto.ripepotatoes.controller;

import com.proyecto.ripepotatoes.domain.Usuario;
import com.proyecto.ripepotatoes.service.FavoriteService;
import com.proyecto.ripepotatoes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FavoriteService favoriteService;

    @GetMapping("/profile")
    public ModelAndView profile(Principal usuario){
        ModelAndView mav = new ModelAndView();
        Usuario user = usuarioService.findByUsername(usuario.getName());
        mav.addObject("user",user);
        mav.setViewName("/home/profile");
        return mav;
    }

}
