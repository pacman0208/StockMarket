import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import {MenuStoreageService} from '../../../../services/menu-storeage.service';
import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
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

  constructor(private router:Router,private menuSvc:MenuStoreageService,private requestSvc:RequestService,private urlSvc:UrlService) { }

  ngOnInit(): void {
    this.menuSvc.removeMenuList();//clear menu list
  }

  ngAfterViewInit(): void{
    
  }

  login():void{
    console.log(this.requestSvc.post(this.urlSvc.getUserURL()+'/login',this.user));
    // console.log(this.requestSvc.get(this.urlSvc.getUserURL()+'/userList'));
    if(this.user.username==="test" && this.user.password==="111"){
      this.msg='';
      this.menuSvc.generateList();//generate menu item
      this.router.navigate(['/user/userlanding']);
    }else{
      this.msg='username/password incorrect!';
    }
  }

  toSignup():void{
    this.router.navigate(['/user/signup']);
  }
}
