import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(private http: HttpClient) { }
  postProduct(data:any){
    return this.http.post<any>("http://localhost:8080/APSJ/rest/articles/insert/",data);
  }
  getProduct(){
    return this.http.get<any>("http://localhost:8080/APSJ/rest/articles/");
  }
  
  putProduct(data:any,id : number){
    return this.http.post<any>("http://localhost:8080/APSJ/rest/articles/update/"+id,data)
  }
  deleteProduct(id:number){
    return this.http.delete<any>("http://localhost:8080/APSJ/rest/articles/delete/"+id)
  }
}
