package com.example.papelariapapelito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.papelariapapelito.model.Categoria;
import com.example.papelariapapelito.model.exception.ResourceNotFoundException;
import com.example.papelariapapelito.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired 
    private CategoriaRepository categoriaRepository;

    public Categoria Adicionar(Categoria categoria){

        categoria.setId(null);

        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){

        return categoriaRepository.findAll();
    }

    public Categoria obterPorId(Long id){
        Optional<Categoria> optCategorias = categoriaRepository.findById(id);

        if(optCategorias.isEmpty()){
            throw new ResourceNotFoundException("Não existe categoria com o ID " + id);
        }

        return optCategorias.get();
    }

    public Categoria atualizar(Long id, Categoria categoria){

        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }
}
