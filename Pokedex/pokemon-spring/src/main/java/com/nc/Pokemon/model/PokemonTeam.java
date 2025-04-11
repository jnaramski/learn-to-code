package com.nc.Pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PokemonTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "team_name")
    private String teamName;

    @OneToMany(mappedBy = "pokemonTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pokemon> pokemons;

    public PokemonTeam(){

    }

    public PokemonTeam(Long teamNumber, String teamName){
        this.teamName = teamName;
    
    }
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public String getTeamName(){
        return teamName;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
  
}
