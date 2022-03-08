import { HttpClient } from '@angular/common/http';
import { provideRoutes, Router } from '@angular/router';
import { Articles } from './interfaces/Articles';
import { Injectable, OnInit } from '@angular/core';

export interface ArticleServiceResponse {
  count: number;
  stores: Array<Articles>;
  }

  @Injectable()

export class ArticleService implements OnInit{
  articles: Articles[] = [];

  constructor( private http : HttpClient, private router:Router) {  
    //this.http.get("http://localhost:8080/APSJ/rest/PC_Portable").toPromise().then(data=>{
 
    }
    ngOnInit(): void {
      this.getPcPortable();
    }

    public getPcPortable(){
      this.http.get<ArticleServiceResponse>("http://localhost:8080/APSJ/rest/articles/PC_Portable").subscribe(result=>{
        this.articles = result.stores
        console.log(result)
        console.log(this.articles)
      });
 
 }

   }
  

