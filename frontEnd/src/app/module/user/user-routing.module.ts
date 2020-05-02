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


const routes: Routes = [
  
  {
    path:'',
    component:UserComponent,
    children:[
      {path:"signup",component:SignupComponent},
      {path:"login",component:LoginComponent},
      {path:"userlanding",component:UserlandingComponent},
      {path:"ipo",component:IpoComponent},
      {path:"compare",component:CompareComponent},
      {path:"edit-profile",component:EditProfileComponent},
      {path:"logout",component:LogoutComponent},
      {path:"signupConfirm",component:SignupConfirmComponent},
      {path:"compareDetail",component:CompareDetailComponent}
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
