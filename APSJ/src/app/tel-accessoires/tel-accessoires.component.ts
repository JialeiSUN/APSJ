import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Articles } from '../interfaces/Articles';
@Component({
  selector: 'app-tel-accessoires',
  templateUrl: './tel-accessoires.component.html',
  styleUrls: ['./tel-accessoires.component.css']
})
export class TelAccessoiresComponent implements OnInit {


  articles: Array<Articles> = new Array<Articles>();

  constructor(private test : ArticleService) { }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.test.getAccessoires_téléphone()
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
