import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

  @Injectable({
    providedIn: 'root'
  })

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  constructor(private http : HttpClient) { }

  getPanier(id: String){
    return this.http.get<any>("http://localhost:8080/apsj/paniers/session/"+id);
  }
}
