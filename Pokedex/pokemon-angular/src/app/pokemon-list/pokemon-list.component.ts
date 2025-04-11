import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../services/pokemon.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Pokemon } from '../models/pokemon.model';

@Component({
  selector: 'app-pokemon-list',
  imports: [CommonModule, FormsModule],
  templateUrl: './pokemon-list.component.html',
  styleUrl: './pokemon-list.component.css'
})
export class PokemonListComponent {
    allPokemon : Pokemon [] = [];
    selectedPokemon: Pokemon | null = null;
    sortBy: string = 'number';
    

    constructor(private pokemonService: PokemonService) {}

    ngOnInit(): void {
      this.loadAllPokemons(); 
    }

  loadAllPokemons(): void {
    this.pokemonService.getAllPokemons().subscribe(
      (data: Pokemon[]) => {
        console.log('All Pokemons:', data);
        this.allPokemon = data;
      },
      (error) => {
        console.error('Error fetching all pokemons:', error);
      }
    );
  }

  selectPokemon(pokemon: Pokemon): void {
    this.selectedPokemon = pokemon; 
  }

  clearSelection(): void { 
    this.selectedPokemon = null;
  }

  
}


