import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Articles } from '../interfaces/Articles';


@Component({
  selector: 'app-pc-portable',
  templateUrl: './pc-portable.component.html',
  styleUrls: ['./pc-portable.component.css']
})
export class PcPortableComponent implements OnInit {

  articles: Array<Articles> = new Array<Articles>();

  constructor(private articleService : ArticleService) { }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.articleService.getPcPortable().subscribe(result =>{
      this.articles = result
      console.log(result)
    });
    
  }

}
