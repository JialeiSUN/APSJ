import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Articles } from '../interfaces/Articles';
import { Paniers } from '../interfaces/Panier';
import { PanierService } from '../panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  paniers: Array<Paniers> = new Array<Paniers>();
  articles: Array<Articles> = new Array<Articles>();


  constructor(private panierservice : PanierService, private articleservice: ArticleService) { }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.panierservice.getPanier("1")
    .subscribe({
      next:(res)=>{
        console.log(typeof res)
        this.paniers = res
        console.log(this.paniers)
        this.paniers.forEach(element => {
          this.articleservice.getArticleById(element.REF_Article).subscribe({
            next:(res)=>{
              console.log(res)
              this.articles.push(res)
              console.log(this.articles)
            }
          })
        });
      },
      error:(err)=>{
        alert("Error")
      }
    })
  }
}
