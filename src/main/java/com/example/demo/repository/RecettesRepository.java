package com.example.demo.repository;

import com.example.demo.entity.Recettes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecettesRepository extends JpaRepository<Recettes,Long> {
}
