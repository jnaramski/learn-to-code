package com.nc.Pokemon.repository;

import com.nc.Pokemon.model.PokemonTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PokemonTeamRepository extends JpaRepository <PokemonTeam, Long>{

}
    

