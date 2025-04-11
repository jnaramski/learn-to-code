import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../services/pokemon.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Pokemon } from '../models/pokemon.model';
import { Team } from '../models/team.model';

@Component({
  selector: 'app-pokedex',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css'],
})
export class PokedexComponent implements OnInit {
  teams: Team[] = []; 
  selectedTeam: Team | null = null;
  selectedPokemon: Pokemon | null = null; 

  constructor(private pokemonService: PokemonService) {}

  ngOnInit(): void {
    this.loadTeams();
  }

  loadTeams(): void {
    this.pokemonService.getTeams().subscribe(
      (data: Team[]) => {
        console.log('Teams with Pokemons:', data);
        this.teams = data; 
      },
      (error) => {
        console.error('Error fetching teams:', error);
      }
    );
  }

  showTeamDetails(team: Team): void {
    this.selectedTeam = this.selectedTeam === team ? null : team;
    console.log('Selected Team:', this.selectedTeam);
  }

  showPokemonDetails(pokemon: any): void {
    this.selectedPokemon = this.selectedPokemon === pokemon ? null : pokemon;
    console.log('Selected Pokemon:', this.selectedPokemon);
  }
}