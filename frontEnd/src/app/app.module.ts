//Angular root component
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './component/footer/footer.component';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';

@NgModule({
  declarations: [ //config current project component
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [ //current module dependencies
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [], // services
  bootstrap: [AppComponent] //main view
})
export class AppModule { 
}
