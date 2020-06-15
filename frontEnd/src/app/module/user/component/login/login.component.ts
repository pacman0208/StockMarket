import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import {MenuStoreageService} from '../../../../services/menu-storeage.service';
import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
import {CommonService} from '../../../../services/common.service';
import {User} from '../../../../model/User';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  head:string = 'Please sign in';

  msg:string='';

  public user:User={
    username : '',
    password : ''
  };

  constructor(private router:Router,private menuSvc:MenuStoreageService,private requestSvc:RequestService,private urlSvc:UrlService,private common:CommonService) { }

  ngOnInit(): void {
    this.menuSvc.removeMenuList();//clear menu list
  }

  ngAfterViewInit(): void{
    
  }

  login():void{
     this.requestSvc.post(this.urlSvc.getUserURL()+'/login',this.user).then((resp:any)=>{
      // console.log(resp);
      console.log(resp.result);
      if(resp.code=="200"){
        this.common.setToken(resp.result.token);
        this.msg='';
        this.menuSvc.generateList();//generate menu item
        this.router.navigate(['/user/userlanding']);
      }else{
        this.msg=resp.msg;
      }
     });
    // console.log(this.requestSvc.get(this.urlSvc.getUserURL()+'/userList'));
    // if(this.user.username==="test" && this.user.password==="111"){
    //   this.msg='';
    //   this.menuSvc.generateList();//generate menu item
    //   this.router.navigate(['/user/userlanding']);
    // }else{
    //   this.msg='username/password incorrect!';
    // }
  }

  toSignup():void{
    this.router.navigate(['/user/signup']);
  }
}
