import { Injectable } from '@angular/core';
import { Articles } from './interfaces/articles';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  articles: Array<Articles> = new Array<Articles>();

  constructor() { }
    this.articles.push({ nom: 'Chemise' , couleur: 'Bleue'});
    this.articles.push({ nom: 'Pantalon' , couleur: 'Noir'});
}
