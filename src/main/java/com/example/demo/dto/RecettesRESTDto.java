package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;


public class RecettesRESTDto implements Serializable {

    private RecettesDto recettesDto;

    private List<IngredientsRESTDto> ingredientsRESTDtos;

}
