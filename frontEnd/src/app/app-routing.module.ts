//router configuration
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './component/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './component/footer/footer.component';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  //if there's no path match, then redirect to this path
  {path:"**",redirectTo:"login"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
