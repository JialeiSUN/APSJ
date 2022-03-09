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

<<<<<<< HEAD
  constructor(private test : ArticleService) { }
=======
  constructor(private test : TestService) { }
>>>>>>> b41060da4295c75562622357bd48d7d29760479c

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
<<<<<<< HEAD
    this.test.getPcPortable()
=======
    this.test.getProduct()
>>>>>>> b41060da4295c75562622357bd48d7d29760479c
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