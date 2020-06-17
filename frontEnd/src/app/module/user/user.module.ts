import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';

import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';

import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { UserlandingComponent } from './component/userlanding/userlanding.component';
import { IpoComponent } from './component/ipo/ipo.component';
import { CompareComponent } from './component/compare/compare.component';
import { EditProfileComponent } from './component/edit-profile/edit-profile.component';
import { LogoutComponent } from './component/logout/logout.component';
import { SignupConfirmComponent } from './component/signup-confirm/signup-confirm.component';
import { CompareDetailComponent } from './component/compare-detail/compare-detail.component';
import { IpoDetailComponent } from './component/ipo-detail/ipo-detail.component';
import { CompanyDetailComponent } from './component/company-detail/company-detail.component';

@NgModule({
  declarations: [
    UserComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    UserlandingComponent,
    IpoComponent,
    CompareComponent,
    EditProfileComponent,
    LogoutComponent,
    SignupConfirmComponent,
    CompareDetailComponent,
    IpoDetailComponent,
    CompanyDetailComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
