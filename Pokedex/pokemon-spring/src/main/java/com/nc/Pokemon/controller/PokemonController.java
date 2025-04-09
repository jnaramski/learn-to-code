package com.nc.Pokemon.controller;

import com.nc.Pokemon.model.Pokemon;
import com.nc.Pokemon.model.PokemonTeam;
import com.nc.Pokemon.repository.PokemonRepository;
import com.nc.Pokemon.repository.PokemonTeamRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
public class PokemonController {
    
    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonTeamRepository pokemonTeamRepository;

    @GetMapping("/api/pokemon/{pokemonNumber}")
    public Pokemon getPokemonByNumber(@PathVariable int pokemonNumber){
        return pokemonRepository.findById(pokemonNumber)
        .orElseThrow(() -> new RuntimeException("Pokemon not found"));
    }

    @GetMapping("/api/pokemons")
    public List<Pokemon> getAllPokemons(){
        return pokemonRepository.findAll();
    }


    @PostMapping("/api/pokemons")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        // Vérifie si une équipe est associée et si oui, l'ajoute au Pokémon
        if (pokemon.getPokemonTeam() != null && pokemon.getPokemonTeam().getId() != null) {
            PokemonTeam team = pokemonTeamRepository.findById(pokemon.getPokemonTeam().getId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            pokemon.setPokemonTeam(team); // Associer l'équipe
        }

        return pokemonRepository.save(pokemon);
    }

    @PutMapping("/api/pokemon/{pokemonNumber}")
    public Pokemon updatePokemonAndAssignTeam(@PathVariable int pokemonNumber, @RequestBody Pokemon pokemonDetails) {
        Pokemon existingPokemon = pokemonRepository.findById(pokemonNumber)
            .orElseThrow(() -> new RuntimeException("Pokemon not found"));
    
        existingPokemon.setPokemonName(pokemonDetails.getPokemonName());
        existingPokemon.setPokemonType(pokemonDetails.getPokemonType());
    
        if (pokemonDetails.getPokemonTeam() != null && pokemonDetails.getPokemonTeam().getId() != null) {
            PokemonTeam team = pokemonTeamRepository.findById(pokemonDetails.getPokemonTeam().getId())
                .orElseThrow(() -> new RuntimeException("Team not found"));
            existingPokemon.setPokemonTeam(team);  // Associer à l'équipe
        }
    
        // Sauvegarder le Pokémon mis à jour
        return pokemonRepository.save(existingPokemon);
    }

    @DeleteMapping("/api/pokemon/{pokemonNumber}")
    public void deletePokemon(@PathVariable int pokemonNumber){
        Pokemon pokemon = pokemonRepository.findById(pokemonNumber)
            .orElseThrow(() -> new RuntimeException("Pokemon not found"));

        pokemonRepository.delete(pokemon);
    }

}
