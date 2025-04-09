import { Component, OnInit } from '@angular/core';
import { PokemonService } from './services/pokemon.service';
import { CommonModule } from '@angular/common';
import { FormsModule, NgModel } from '@angular/forms';


@Component({
  selector: 'app-root',
  standalone:true,
  imports : [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'pokemon-angular';
  pokemons: any[] = [];
  teams: any[] = [];
  selectedPokemon: any= null;
  selectedTeam: any = null;
  pokemonsGroupedByTeam : {[key:string]: any[] } = {};


  newPokemon: any = {
    pokemonName: '',
    pokemonNumber: null,
    pokemonType: '',
    pokemonTeam: null,
  };

  newTeam: any = {
    teamName: '',

  };


  constructor(private pokemonService: PokemonService) {}

  ngOnInit(): void {
    this.pokemonService.getPokemons().subscribe(
      (data) => {
        console.log('Pokemons:', data); 
        this.pokemons = data;
      },
      (error) => {
        console.error('Error fetching pokemons:', error);
      }
    );

    this.pokemonService.getTeams().subscribe(
      (data) => {
        console.log('Teams:', data); 
        this.teams = data;
      },
      (error) => {
        console.error('Error fetching teams:', error);
      }
    );

    this.pokemonService.getPokemons().subscribe(
      (data) => {
        console.log('Pokemons:', data);
        this.pokemons = data;
        this.groupPokemonsByTeam(); // Regrouper les Pokémon par équipe après récupération
      },
      (error) => {
        console.error('Error fetching pokemons:', error);
      }
    );

  }

  showPokemonDetails(pokemon: any): void {
    if (this.selectedPokemon === pokemon) {
      this.selectedPokemon = null;
    } else {
      this.selectedPokemon = pokemon;
    }
    console.log('Selected Pokemon:', this.selectedPokemon);
  }

  showTeamDetails(team: any): void {
    if (this.selectedTeam === team) {
      this.selectedTeam = null;
    } else {
      this.selectedTeam = team;
    }
    console.log('Selected Team:', this.selectedTeam);
  }



  addPokemon(): void {
    const pokemonToAdd = {
      pokemonName : this.newPokemon.pokemonName,
      pokemonNumber : this.newPokemon.pokemonNumber,
      pokemonType : this.newPokemon.pokemonType,
      pokemonTeam: this.newPokemon.pokemonTeam ? {id : this.newPokemon.pokemonTeam.id} : null, 
      ...this.newPokemon,
    };

    this.pokemonService.addPokemon(pokemonToAdd).subscribe(
      (response) => {
        console.log('Pokemon ajouté avec succès:', response);
        this.pokemons.push(response); 
        this.newPokemon = { pokemonName: '', pokemonNumber: null, pokemonType: '', pokemonTeam: null }; // Réinitialiser le formulaire
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du Pokémon:', error);
      }
    );
  }

  addTeam(): void {
    const teamToAdd = {

      teamName : this.newTeam.teamName,

    };

    this.pokemonService.addTeam(teamToAdd).subscribe(
      (response) => {
        console.log('Team ajouté avec succès:', response);
        this.teams.push(response); 
        this.newTeam = { teamName: '' };
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du Pokémon:', error);
      }
    );
  }

  groupPokemonsByTeam():void {
    this.pokemons.forEach((pokemon) => {
      const teamName = pokemon.pokemonTeam ? pokemon.pokemonTeam.teamName : 'Unknown';
      if (!this.pokemonsGroupedByTeam[teamName]){
        this.pokemonsGroupedByTeam[teamName]=[];
      }
      this.pokemonsGroupedByTeam[teamName].push(pokemon);
    });
  }



}

