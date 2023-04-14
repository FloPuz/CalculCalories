package com.example.demo.service.impl;

import com.example.demo.dto.RecettesDto;
import com.example.demo.entity.Recettes;
import com.example.demo.repository.RecettesRepository;
import com.example.demo.service.RecettesService;
import com.example.demo.service.mapper.RecetteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class RecetteServiceImpl implements RecettesService {

    @Autowired
    private RecettesRepository _recettesRepository;

    @Autowired
    private RecetteMapper _recetteMapper;
    @Override
    public List<RecettesDto> findAll() {
        return _recettesRepository.findAll().stream().map(x -> _recetteMapper.recettesDto(x)).collect(toList());
    }
}
