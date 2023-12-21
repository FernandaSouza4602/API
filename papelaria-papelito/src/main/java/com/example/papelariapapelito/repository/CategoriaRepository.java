package com.example.papelariapapelito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.papelariapapelito.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
