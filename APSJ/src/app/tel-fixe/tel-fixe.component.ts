import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Articles } from '../interfaces/Articles';
@Component({
  selector: 'app-tel-fixe',
  templateUrl: './tel-fixe.component.html',
  styleUrls: ['./tel-fixe.component.css']
})
export class TelFixeComponent implements OnInit {


  articles: Array<Articles> = new Array<Articles>();

  constructor(private test : ArticleService) { }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.test.getTel_Fixe()
    .subscribe({
      next:(res)=>{
        //console.log(res)
        console.log(typeof res)
        this.articles = res
        console.log(this.articles)
      },
      error:(err)=>{
        alert("Error")
      }
    })
  }

}
