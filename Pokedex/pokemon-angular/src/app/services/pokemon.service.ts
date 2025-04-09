import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PokemonService {
  private baseUrl = '/api';

  constructor(private http: HttpClient) {}

  getPokemons(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/pokemons`);
  }

  getTeams(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/teams`);
  }

  addPokemon(pokemon: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/pokemons`, pokemon);
  }

  
  addTeam(team: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/teams`, team);
  }

  
}