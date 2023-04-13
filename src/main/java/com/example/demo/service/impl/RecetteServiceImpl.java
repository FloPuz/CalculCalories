package com.example.demo.service.impl;

import com.example.demo.repository.RecettesRepository;
import com.example.demo.service.RecettesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecetteServiceImpl implements RecettesService {

    private RecettesRepository recettesRepository;

}
