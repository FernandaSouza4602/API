package com.example.papelariapapelito.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.papelariapapelito.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria_Nome(String nome);
}
