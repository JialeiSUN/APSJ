import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {
  messageError: string ="";
  login: string ="";
  mdp: string ="";


  constructor(
  private router: Router
  ) { }

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
