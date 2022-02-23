import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})

export class ArticleComponent implements OnInit {

  //Propriétés
  nom_Article: String="Chemise";
  taille_Article: number=40;
  couleur_Article : String ="Blue";
  message: String="Achat: pas encore effectué";
  maDate: Date= new Date ('2021-01-01');
  confirmation: boolean= false;
  nomCategorie: String = "";
  isColorChanged: boolean= false;


  constructor() { }

  ngOnInit(): void {
  }

  //Méthodes
  OnAchatArticle() {
  this.confirmation=true;
  this.message="Tu as appuyé t'es complètement guedin";
  }

  OnChoixCategorie(evt: Event) {
  this.nomCategorie=(<HTMLInputElement>evt.target).value;

  }
}
