package com.naramskicorporation.pokedex.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PokemonAlreadyExist extends RuntimeException {
    public PokemonAlreadyExist() {
        super("Pokemon already exists");
    }
    
    public PokemonAlreadyExist(String message) {
        super(message);
    }
    
}
    

