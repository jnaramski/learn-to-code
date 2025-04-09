package com.nc.Pokemon.controller;

import com.nc.Pokemon.model.Pokemon;
import com.nc.Pokemon.model.PokemonTeam;
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

public class PokemonTeamController {
    
    @Autowired
    private PokemonTeamRepository pokemonTeamRepository;

    @GetMapping("/api/teams/{id}")
    public PokemonTeam getTeamById(@PathVariable Long id){
        return pokemonTeamRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Team not found with id " + id));
    }

    @GetMapping("/api/teams")
    public List<PokemonTeam> getAllTeams() {
    return pokemonTeamRepository.findAll();
}

    @PostMapping("/api/teams")
    public PokemonTeam createTeam(@RequestBody PokemonTeam team){
        return pokemonTeamRepository.save(team); 
    }


    @PutMapping("/api/teams/{id}")
    public PokemonTeam updateTeam(@PathVariable Long id, @RequestBody PokemonTeam teamDetails) {
        PokemonTeam existingTeam = pokemonTeamRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Team not found with id " + id));
      
        existingTeam.setTeamName(teamDetails.getTeamName());

        return pokemonTeamRepository.save(existingTeam);
    }

    @DeleteMapping("/api/team/{id}")
    public void deleteTeam(@PathVariable Long id) {
        PokemonTeam team = pokemonTeamRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Team not found with id " + id));
        
        pokemonTeamRepository.delete(team);
    }
}
