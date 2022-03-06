import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Articles } from './interfaces/Articles';
import { map, Observable } from 'rxjs';


export interface ArticleServiceResponse {
  count: number;
  stores: Array<Articles>;
  }


export class ArticleService {


  constructor( private http : HttpClient, private router:Router) {   }
  
  getPcPortable(): Observable<Array<Articles>>{
     return this.http.get<ArticleServiceResponse>("http://localhost:8080/apsj/articles/PC_Portable").pipe(map(response => response.stores));
  }
}
