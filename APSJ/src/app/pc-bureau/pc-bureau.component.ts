import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Articles } from '../interfaces/Articles';
@Component({
  selector: 'app-pc-bureau',
  templateUrl: './pc-bureau.component.html',
  styleUrls: ['./pc-bureau.component.css']
})
export class PcBureauComponent implements OnInit {

  articles: Array<Articles> = new Array<Articles>();

  constructor(private test : ArticleService) { }

  ngOnInit(): void {
    this.getData();
  }
  private getData(){
    this.test.getPC_de_Bureau()
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
