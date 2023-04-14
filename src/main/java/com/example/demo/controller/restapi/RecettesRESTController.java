package com.example.demo.controller.restapi;

import com.example.demo.dto.RecettesDto;
import com.example.demo.dto.RecettesRESTDto;
import com.example.demo.service.impl.RecetteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/recettes")
public class RecettesRESTController {

    @Autowired
    private RecetteServiceImpl _recetteService;


    @GetMapping
    public List<RecettesDto> getAllRecettes(){
        return _recetteService.findAll();
    }

    @PostMapping
    public void postARecipe(@RequestBody RecettesRESTDto recettesRESTDto){
        _recetteService.insertPostedRecette(recettesRESTDto);
    }
}
