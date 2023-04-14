package com.example.demo.controller;

import com.example.demo.dto.IngredientsDto;
import com.example.demo.dto.RecettesDto;
import com.example.demo.service.impl.RecetteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecettesViewModelController {
    @Autowired
    private RecetteServiceImpl _recetteService;
    @GetMapping("/recettes")
    public ModelAndView home() {
        // C'est la view "home" qui sera utilisée pour constuire la réponse => fichier home.mustache
        ModelAndView modelAndView = new ModelAndView("recettes");

        List<RecettesDto> recettes = _recetteService.findAll();
        modelAndView.addObject("recettes",recettes);

        return modelAndView;
    }
}
