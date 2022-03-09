import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Articles } from '../interfaces/Articles';
@Component({
  selector: 'app-pc-accessoires',
  templateUrl: './pc-accessoires.component.html',
  styleUrls: ['./pc-accessoires.component.css']
})
export class PcAccessoiresComponent implements OnInit {

  articles: Array<Articles> = new Array<Articles>();

  constructor(private test : ArticleService) { }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.test.getAccessoires_ordinateurs()
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
