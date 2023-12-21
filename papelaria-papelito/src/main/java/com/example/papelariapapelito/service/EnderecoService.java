package com.example.papelariapapelito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.papelariapapelito.model.Endereco;
import com.example.papelariapapelito.model.exception.ResourceNotFoundException;
import com.example.papelariapapelito.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired 
    private EnderecoRepository enderecoRepository;

    public Endereco Adicionar(Endereco endereco){

        endereco.setId(null);

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterTodos(){

        return enderecoRepository.findAll();
    }

    public Endereco obterPorId(Long id){
        Optional<Endereco> optEndereco = enderecoRepository.findById(id);

        if(optEndereco.isEmpty()){
            throw new ResourceNotFoundException("Não existe endereco com o ID " + id);
        }

        return optEndereco.get();
    }

    public Endereco atualizar(Long id, Endereco endereco){

        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id){
        enderecoRepository.deleteById(id);
    }
}
