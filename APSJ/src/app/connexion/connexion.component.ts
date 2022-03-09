import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http' ;
import {HttpHeaders} from '@angular/common/http' ;
@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {
  messageError: string ="";
  login: string ="";
  mdp: string ="";
  url = 'http://localhost:8080/apsj/users/id/1';
 //url = 'http://echo.jsontest.com/key/value/one/two'
 public httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin':'http://localhost:8080/' ,
    'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, OPTIONS',
    'Access-Control-Max-Age': '86400'
  })
};
  constructor(
  private router: Router,private http:HttpClient
  ) {
    this.httpOptions
    this.http.get(this.url).toPromise().then(data=>{
      console.log(data);
    });
   }

  ngOnInit(): void {
  }

  onSubmit() {

    if (this.login == "admin" && this.mdp == "elite") {
        this.messageError = "Réussite";
    }
    else {
        this.messageError = "Echec";
    }
  }

  OnLogin(evt: Event) {
    this.login=(<HTMLInputElement>evt.target).value;
  }
  OnMdp(evt: Event) {
    this.mdp=(<HTMLInputElement>evt.target).value;
  }

  connexion(connexionForm: any) {
    let data = connexionForm.value;
    console.log(connexionForm.value);

   /* this.sa.signIn(data.email, data.pass)
    .then(() => {
      console.log("done");
      this.route.navigate(['/Home]')
    }).catch() => {
      console.log("erreur");
      this.messageError="Erreur d'authentification"
    })*/
  }

}
