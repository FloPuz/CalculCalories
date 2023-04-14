package com.example.demo.controller;


import com.example.demo.dto.IngredientsDto;
import com.example.demo.dto.RecettesDto;
import com.example.demo.service.impl.IngredientsServiceImpl;
import com.example.demo.service.impl.RecetteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeViewModelController {
    @Autowired
    private IngredientsServiceImpl _ingredientsService;
    @Autowired
    private RecetteServiceImpl _recetteService;

    /**
     * Point d'entrée lorsque url http://localhost:8080/ sera déclenchée.
     */
    @GetMapping("/")
    public ModelAndView home() {
        // C'est la view "home" qui sera utilisée pour constuire la réponse => fichier home.mustache
        ModelAndView modelAndView = new ModelAndView("home");

        List<RecettesDto> recettes = _recetteService.findAll();
        modelAndView.addObject("recettes",recettes);

        List<IngredientsDto> ingredients = _ingredientsService.findAll();
        modelAndView.addObject("ingredients",ingredients);

        return modelAndView;
    }

}
