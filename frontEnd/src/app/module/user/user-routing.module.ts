import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {UserComponent} from './user.component';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { UserlandingComponent } from './component/userlanding/userlanding.component';
import { IpoComponent } from './component/ipo/ipo.component';
import { CompareComponent } from './component/compare/compare.component';
import { EditProfileComponent } from './component/edit-profile/edit-profile.component';
import { LogoutComponent } from './component/logout/logout.component';
import { SignupConfirmComponent } from './component/signup-confirm/signup-confirm.component';
import { CompareDetailComponent } from './component/compare-detail/compare-detail.component';
import { CompanyDetailComponent } from './component/company-detail/company-detail.component';


import {LoginGuardGuard} from './guard/login-guard.guard';
const routes: Routes = [
  
  {
    path:'',
    component:UserComponent,
    children:[
      {path:"signup",component:SignupComponent},
      {path:"login",component:LoginComponent},
      {path:"userlanding",component:UserlandingComponent,canActivate:[LoginGuardGuard]},
      {path:"ipo",component:IpoComponent,canActivate:[LoginGuardGuard]},
      {path:"compare",component:CompareComponent,canActivate:[LoginGuardGuard]},
      {path:"edit-profile",component:EditProfileComponent,canActivate:[LoginGuardGuard]},
      {path:"logout",component:LogoutComponent},
      {path:"signupConfirm",component:SignupConfirmComponent},
      {path:"compareDetail",component:CompareDetailComponent,canActivate:[LoginGuardGuard]},
      {path:"companyDetail/:id",component:CompanyDetailComponent}
    ]
    
  },
  {
    path:"**",redirectTo:'login'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
