package com.example.papelariapapelito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.papelariapapelito.model.Produto;
import com.example.papelariapapelito.model.exception.ResourceBadRequestException;
import com.example.papelariapapelito.model.exception.ResourceNotFoundException;
import com.example.papelariapapelito.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired 
    private ProdutoRepository produtoRepository;

    public Produto Adicionar(Produto produto){

        produto.setId(null);

        if (produto.getEstoque() < 10) {
            throw new ResourceBadRequestException("O mínimo para montar estoque é de 10 unidades.");
        }

        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos(){

        return produtoRepository.findAll();
    }

    public Produto obterPorId(Long id){
        Optional<Produto> optProduto = produtoRepository.findById(id);

        if(optProduto.isEmpty()){
            throw new ResourceNotFoundException("Não existe produto com o ID " + id);
        }

        return optProduto.get();
    }

    public List<Produto> obterPorCategoria(String nome){
        return produtoRepository.findByCategoria_Nome(nome);
    }

    public Produto atualizar(Long id, Produto produto){

        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }
}
