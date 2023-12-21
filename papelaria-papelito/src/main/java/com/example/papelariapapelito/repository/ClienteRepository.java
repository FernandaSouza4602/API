package com.example.papelariapapelito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.papelariapapelito.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
