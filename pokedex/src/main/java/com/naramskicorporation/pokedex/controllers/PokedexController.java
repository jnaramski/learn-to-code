package com.naramskicorporation.pokedex.controllers;

import com.naramskicorporation.pokedex.model.Pokemon;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.hibernate.sql.results.internal.ResolvedSqlSelection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PokedexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PokedexController.class);

    private List<Pokemon> pokemons = new ArrayList<>();

    public PokedexController(){
        pokemons.add(new Pokemon (1, "Bulbasaur", "Grass/Poison"));
        pokemons.add(new Pokemon (2, "Ivysaur", "Grass/Poison"));
        pokemons.add(new Pokemon (3, "Venusaur", "Grass/Poison"));
        pokemons.add(new Pokemon (4, "Charmander", "Fire"));
        pokemons.add(new Pokemon (5, "Charmeleon", "Fire"));
        pokemons.add(new Pokemon (6, "Charizard", "Fire/Flying"));
        pokemons.add(new Pokemon (7, "Squirtle", "Water"));
        pokemons.add(new Pokemon (8, "Wartortle", "Water"));
        pokemons.add(new Pokemon (9, "Blastoise", "Water"));
    }
    @GetMapping(value = "/")
    public String hello() {
        return "un méga Pokedex !";
    }
    
    @GetMapping(value = "/pokemons")
    public List<Pokemon> getAllPokemons() {
        return pokemons;
    }

    @GetMapping("/pokemons/{id}")
    public Pokemon getPokemonByNumber(@PathVariable() int id) throws ResourceNotFoundException{
        for (Pokemon pokemon :  pokemons) {
            if (pokemon.getNumber() == id){
                return pokemon;
            }
        }
        throw new ResourceNotFoundException(); 
    }


    @PutMapping("pokemons/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Pokemon updatedPokemon) throws ResourceNotFoundException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getNumber() == id) {
                pokemon.setName(updatedPokemon.getName());
                pokemon.setType(updatedPokemon.getType());
                return "Pokemon updated";
            }
        }
        
        throw new ResourceNotFoundException();
    }

    @PostMapping("/pokemons")
    public String addPokemon(@RequestBody Pokemon newPokemon) throws PokemonAlreadyExist {
    
        for (Pokemon pokemon : pokemons){
            if (pokemon.getNumber() == newPokemon.getNumber()){
                throw new PokemonAlreadyExist();
            }
        }
        pokemons.add(newPokemon);
        return "Pokemon added";
    }

    @DeleteMapping("/pokemons/{id}")
    public String deletePokemon(@PathVariable int id) throws ResourceNotFoundException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getNumber() == id) {
                pokemons.remove(pokemon);
                return "Pokemon deleted";
            }
        }
        throw new ResourceNotFoundException();
    }
}


  
