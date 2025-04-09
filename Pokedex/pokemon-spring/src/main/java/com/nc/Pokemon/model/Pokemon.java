package com.nc.Pokemon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pokemon {

    @Id
    @Column(name = "pokemon_number")
    private int pokemonNumber;

    @Column(name = "pokemon_name")
    private String pokemonName;

    @Column(name = "pokemon_type")
    private String pokemonType;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private PokemonTeam pokemonTeam;

    public Pokemon(){

    }

    public Pokemon(int pokemonNumber, String pokemonName, String pokemonType, PokemonTeam pokemonTeam){
        this.pokemonNumber = pokemonNumber;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.pokemonTeam = pokemonTeam;
    }

    public int getPokemonNumber(){
        return this.pokemonNumber;
    }

    public void setPokemonNumber(int pokemonNumber){
        this.pokemonNumber = pokemonNumber;
    }

    public String getPokemonName(){
        return this.pokemonName;
    }

    public void setPokemonName(String pokemonName){
        this.pokemonName = pokemonName;
    }

    public String getPokemonType(){
        return this.pokemonType;
    }

    public void setPokemonType(String pokemonType){
        this.pokemonType = pokemonType;
    }

    public PokemonTeam getPokemonTeam() {
        return pokemonTeam;
    }

    public void setPokemonTeam(PokemonTeam pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }
}