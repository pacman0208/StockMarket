//router configuration
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './component/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './component/footer/footer.component';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { UserlandingComponent } from './component/userlanding/userlanding.component';
import { IpoComponent } from './component/ipo/ipo.component';
import { CompareComponent } from './component/compare/compare.component';
import { EditProfileComponent } from './component/edit-profile/edit-profile.component';
import { LogoutComponent } from './component/logout/logout.component';
import { SignupConfirmComponent } from './component/signup-confirm/signup-confirm.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"userlanding",component:UserlandingComponent},
  {path:"ipo",component:IpoComponent},
  {path:"compare",component:CompareComponent},
  {path:"edit-profile",component:EditProfileComponent},
  {path:"logout",component:LogoutComponent},
  {path:"signupConfirm",component:SignupConfirmComponent},
  //if there's no path match, then redirect to this path
  {path:"**",redirectTo:"login"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
