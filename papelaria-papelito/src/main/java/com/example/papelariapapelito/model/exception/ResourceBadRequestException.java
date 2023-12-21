package com.example.papelariapapelito.model.exception;

public class ResourceBadRequestException extends RuntimeException {
    
    public ResourceBadRequestException (String mensagem){
        super(mensagem);
    }
}
