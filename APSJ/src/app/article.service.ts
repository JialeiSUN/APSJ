import { HttpClient } from '@angular/common/http';
<<<<<<< HEAD
import { Injectable } from '@angular/core';

  @Injectable({
    providedIn: 'root'
  })
  
=======
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
>>>>>>> b41060da4295c75562622357bd48d7d29760479c

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

<<<<<<< HEAD
  constructor(private http : HttpClient) {   }
  
  getPcPortable(){
     return this.http.get<any>('http://localhost:8080/apsj/articles/PC_Portable');
  }

  getArticleById(id:String){
    return this.http.get<any>("http://localhost:8080/apsj/articles/id/"+id);
  }
}
=======
   }
  

>>>>>>> b41060da4295c75562622357bd48d7d29760479c
