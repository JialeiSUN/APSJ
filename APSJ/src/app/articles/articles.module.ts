import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticlesRoutingModule } from './articles-routing.module';
import { InformatiqueComponent } from './informatique/informatique.component';


@NgModule({
  declarations: [
    InformatiqueComponent
  ],
  imports: [
    CommonModule,
    ArticlesRoutingModule
  ]
})
export class ArticlesModule { }
