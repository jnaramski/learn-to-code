import { Pokemon } from './pokemon.model';

export interface Team {
  id: number;          
  teamName: string;    
  pokemons: Pokemon[];

}