import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

  @Injectable({
    providedIn: 'root'
  })
  

export class ArticleService {


  constructor(private http : HttpClient) {   }
  
  getPcPortable(){
     return this.http.get<any>('http://localhost:8080/apsj/articles/PC_Portable');
  }

  getArticleById(id:String){
    return this.http.get<any>("http://localhost:8080/apsj/articles/id/"+id);
  }
}
