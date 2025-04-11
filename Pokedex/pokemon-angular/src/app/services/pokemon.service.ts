import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Team } from '../models/team.model';
import { Pokemon } from '../models/pokemon.model'

@Injectable({
  providedIn: 'root', 
})
export class PokemonService {
  private baseUrl = '/api'; 

  constructor(private http: HttpClient) {}

  getTeams(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/teams`);
  }

  getAllPokemons(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(`${this.baseUrl}/pokemons`);
  }

  addTeam(team: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/teams`, team);
  }

  deleteTeam(teamId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/teams/${teamId}`);
  }

  addPokemon(pokemon: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/pokemons`, pokemon);
  }

  deletePokemon(pokemonId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/pokemons/${pokemonId}`);
  }
}