import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import {MenuStoreageService} from '../../../../services/menu-storeage.service';

import {AuthService} from "../../service/auth.service";
import {User} from '../../../../model/User';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  head:string = 'Welcome to Stock Market system, Please sign in';

  msg:string='';

  public user:User={
    username:'',
    password:''
  };

  loginUser:string;

  constructor(private router:Router,private menuSvc:MenuStoreageService,private authSvc:AuthService) { }

  ngOnInit(): void {
  }

  login(){
    
    if(this.user.username==="admin" && this.user.password==="111"){
      this.msg='';
      this.menuSvc.generateLeftMenu();//generate menu item
      this.authSvc.setLoginUser(this.user.username);
      this.router.navigate(['/admin/landing']);
    }else{
      this.msg='username/password incorrect!';
    }
  }

}
