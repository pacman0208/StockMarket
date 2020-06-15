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
import {RequestService} from './services/request.service';
import {UrlService} from './services/url.service';
//import httpclient module
import {HttpClientModule} from "@angular/common/http";
import { Browser } from 'protractor';


@NgModule({
  declarations: [ //config current project component
    AppComponent
  ],
  imports: [ //current module dependencies
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [// services
    MenuStoreageService,
    RequestService,
    UrlService,
    {
      provide:'COMPANY_BASE_URL',
      useValue:'http://localhost:8882/api/company'
    },
    {
      provide:'SECTOR_BASE_URL',
      useValue:'http://localhost:8882/api/sector'
    }
  ], 
  bootstrap: [AppComponent] //main view
})
export class AppModule { 
}
