import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http' ;
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './Components/menu/menu.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './Components/header/header.component';
import { SectionComponent } from './Components/section/section.component';
import { FooterComponent } from './Components/footer/footer.component';
import { PcPortableComponent } from './pc-portable/pc-portable.component';
import { PcBureauComponent } from './pc-bureau/pc-bureau.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PcAccessoiresComponent } from './pc-accessoires/pc-accessoires.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { SmartphoneComponent } from './smartphone/smartphone.component';
import { TelAccessoiresComponent } from './tel-accessoires/tel-accessoires.component';
import { TelFixeComponent } from './tel-fixe/tel-fixe.component';
import { DisqueDurComponent } from './disque-dur/disque-dur.component';
import { CleUsbComponent } from './cle-usb/cle-usb.component';
import { StockageAccessoiresComponent } from './stockage-accessoires/stockage-accessoires.component';
import { RegisterComponent } from './register/register.component';
import { ArticleComponent } from './article/article.component';
import { ArticlesModule } from './articles/articles.module';
import { ObservableComponent } from './observable/observable.component';
import { ArticleService } from './article.service';
import { CommonModule } from '@angular/common';
@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HeaderComponent,
    SectionComponent,
    FooterComponent,
   PcPortableComponent,
    PcBureauComponent,
    HomeComponent,
    NavbarComponent,
    PcAccessoiresComponent,
    ConnexionComponent,
    SmartphoneComponent,
    TelAccessoiresComponent,
    TelFixeComponent,
    DisqueDurComponent,
    CleUsbComponent,
    StockageAccessoiresComponent,
    RegisterComponent,
    ArticleComponent,
    ObservableComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
    ArticlesModule,
    HttpClientModule,
    CommonModule

  ],
 // providers: [ArticleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
