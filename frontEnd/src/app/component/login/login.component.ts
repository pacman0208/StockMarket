import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import {MenuStoreageService} from '../../services/menu-storeage.service';
interface User{
  username:string;
  password:string;
}
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

  constructor(private router:Router,private menuSvc:MenuStoreageService) { }

  ngOnInit(): void {
    
  }

  ngAfterViewInit(): void{
    this.menuSvc.removeMenuList();//clear menu list
  }

  login():void{
    if(this.user.username==="test" && this.user.password==="111"){
      this.msg='';
      this.menuSvc.generateList();//generate menu item
      this.router.navigate(['/userlanding']);
    }else{
      this.msg='username/password incorrect!';
    }
  }

  toSignup():void{
    this.router.navigate(['/signup']);
  }
}
