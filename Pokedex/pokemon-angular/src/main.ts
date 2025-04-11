import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { AppComponent } from './app/app.component';
import { appConfig } from './app/app.config';
import { importProvidersFrom } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { provideRouter, Routes} from '@angular/router';
import { PokedexComponent } from './app/pokedex/pokedex.component';
import { HomeComponent } from './app/home/home.component';
import { PokemonListComponent } from './app/pokemon-list/pokemon-list.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'pokedex', component: PokedexComponent},
  { path: 'pokelist', component: PokemonListComponent},
]

bootstrapApplication(AppComponent, {
  ...appConfig,
  providers: [
    provideHttpClient(),
    provideRouter(routes),
    importProvidersFrom(CommonModule, FormsModule), // Ajout de CommonModule
  ],
}).catch((err) => console.error(err));