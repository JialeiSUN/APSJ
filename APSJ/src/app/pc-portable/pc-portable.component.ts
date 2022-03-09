import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Articles } from '../interfaces/Articles';
import { TestService } from '../test.service';

@Component({
  selector: 'app-pc-portable',
  templateUrl: './pc-portable.component.html',
  styleUrls: ['./pc-portable.component.css']
})

export class PcPortableComponent implements OnInit {

  articles: Array<Articles> = new Array<Articles>();

  constructor(private test : ArticleService) { }


  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.test.getPcPortable()
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