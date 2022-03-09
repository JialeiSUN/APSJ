import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) { }
  getProduct(){
    return this.http.get<any>("http://localhost:8080/apsj/articles/PC_Portable");
  }
}
