import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./home/home.component"
import { PcPortableComponent } from "./pc-portable/pc-portable.component"
import { PcBureauComponent } from "./pc-bureau/pc-bureau.component"
import { ConnexionComponent } from "./connexion/connexion.component"
import { PcAccessoiresComponent } from "./pc-accessoires/pc-accessoires.component"
import { SmartphoneComponent } from './smartphone/smartphone.component';
import { TelAccessoiresComponent } from "./tel-accessoires/tel-accessoires.component"
import { TelFixeComponent } from "./tel-fixe/tel-fixe.component"
import { DisqueDurComponent } from "./disque-dur/disque-dur.component"
import { StockageAccessoiresComponent } from "./stockage-accessoires/stockage-accessoires.component"
import { CleUsbComponent } from "./cle-usb/cle-usb.component"
import { RegisterComponent } from "./register/register.component"

const routes: Routes = [
  { path: "",component: HomeComponent },
  { path: "PcPortable",component: PcPortableComponent },
  { path: "PcBureau",component: PcBureauComponent },
  { path: "PcAccessoires",component: PcAccessoiresComponent },
  { path: "Connexion",component: ConnexionComponent },
  { path: "SmartPhone",component: SmartphoneComponent },
  { path: "TelAccessoires",component: TelAccessoiresComponent },
  { path: "TelFixe",component: TelFixeComponent },
  { path: "DisqueDur",component: DisqueDurComponent },
  { path: "StockageAccessoires",component: StockageAccessoiresComponent },
  { path: "CleUSB",component: CleUsbComponent },
  { path: "Register",component: RegisterComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
