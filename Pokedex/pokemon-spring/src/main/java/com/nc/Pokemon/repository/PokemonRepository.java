package com.nc.Pokemon.repository;

import com.nc.Pokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PokemonRepository extends JpaRepository <Pokemon, Integer>{
    
}
