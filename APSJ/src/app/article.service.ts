import { HttpClient } from '@angular/common/http';
import { Injectable} from '@angular/core';

  @Injectable({
    providedIn: 'root'
  })


export class ArticleService {
  constructor(private http : HttpClient) {   }
    ngOnInit(): void {
      throw new Error('Method not implemented.');
    }
  
  getPcPortable(){
     return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/PC_Portable');
  }
  getPC_de_Bureau(){
    return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/PC_de_Bureau');
 }
 getAccessoires_ordinateurs(){
  return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/Accessoires_ordinateurs');
}
getSmart_phone(){
  return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/Smart_phone');
}
getTel_Fixe(){
  return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/Tel_Fixe');
}
getAccessoires_téléphone(){
  return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/Accessoires_téléphone');
}
getDisque_dur(){
  return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/Disque_dur');
}
getAccessoires_stockage(){
  return this.http.get<any>('http://localhost:8080/APSJ/rest/articles/Accessoires_stockage');
}

  getArticleById(id:String){
    return this.http.get<any>("http://localhost:8080/APSJ/rest/articles/id/"+id);
  }
}
