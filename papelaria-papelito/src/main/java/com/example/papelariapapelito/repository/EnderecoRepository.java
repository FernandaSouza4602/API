package com.example.papelariapapelito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.papelariapapelito.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
