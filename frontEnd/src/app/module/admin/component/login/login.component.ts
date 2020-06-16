import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import {MenuStoreageService} from '../../../../services/menu-storeage.service';

import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
import {CommonService} from '../../../../services/common.service';
import {AuthService} from "../../service/auth.service";
import {User} from '../../../../model/User';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  head:string = 'Sign in as admin';

  msg:string='';

  public user:User={
    username:'',
    password:''
  };

  loginUser:string;

  constructor(private router:Router,private menuSvc:MenuStoreageService,private authSvc:AuthService,private requestSvc:RequestService,private urlSvc:UrlService,private common:CommonService) { }

  ngOnInit(): void {
  }

  login(){
    console.log(this.user);
    this.requestSvc.post(this.urlSvc.getUserURL()+'/admin/login',this.user).then((resp:any)=>{
      // console.log(resp);
      console.log(resp.result);
      if(resp.code=="200"){
        this.common.setToken(resp.result.token);
        this.msg='';
        this.menuSvc.generateLeftMenu();//generate menu item
        this.router.navigate(['/admin/landing']);
        this.common.setToken(resp.result.token);
        this.authSvc.setLoginUser(this.user.username);
      }else{
        this.msg=resp.msg;
      }
     });
    // if(this.user.username==="admin" && this.user.password==="111"){
    //   this.msg='';
    //   this.menuSvc.generateLeftMenu();//generate menu item
    //   this.authSvc.setLoginUser(this.user.username);
    //   this.router.navigate(['/admin/landing']);
    // }else{
    //   this.msg='username/password incorrect!';
    // }
  }

}
