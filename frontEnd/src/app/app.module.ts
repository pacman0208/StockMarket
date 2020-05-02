//Angular root component
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

//import component
import { AppComponent } from './app.component';
//import service
import {MenuStoreageService} from './services/menu-storeage.service';


@NgModule({
  declarations: [ //config current project component
    AppComponent
  ],
  imports: [ //current module dependencies
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [// services
    MenuStoreageService
  ], 
  bootstrap: [AppComponent] //main view
})
export class AppModule { 
}
