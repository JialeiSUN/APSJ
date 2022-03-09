import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public registerForm !: FormGroup;
  constructor(private formBuilder: FormBuilder, private http : HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      id:['3'],
      nom:[''],
      prenom:[''],
      email:[''],
      telephone:[''],
      adresse:[''],
      password:[''],
      user_role:['User']
    })
  }
  signUp(){
    /*
    this.http.post<any>("http://localhost/testjson.php",this.registerForm.value)
    .subscribe(res =>{
      alert("Signup Successfull");
      this.registerForm.reset();
      this.router.navigate(['connexion'])
      
    },err=>{
      alert("Failed")
    })
    */
    this.http.post<any>("http://localhost:8080/apsj/users/siginup",JSON.stringify(this.registerForm.value)).subscribe(next =>{
      alert("Signup Successfull");
      this.registerForm.reset();
      this.router.navigate(['connexion'])
      
    },err=>{
      alert("Failed")
    })
   //console.log(JSON.stringify(this.registerForm.value));
  }
}
