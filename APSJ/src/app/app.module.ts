import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './Components/menu/menu.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './Components/header/header.component';
import { SectionComponent } from './Components/section/section.component';
import { FooterComponent } from './Components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HeaderComponent,
    SectionComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
